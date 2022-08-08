package board.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import board.model.EmpBoardDAO;
import board.model.EmpBoardDTO;
import board.model.EmpBoardStaticsDTO;
import emps.model.EmpsDTO;

public class EmpBoardService {
	
	public int add(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		//시퀀스 넘버를 아이디값으로 받아옴
		int seq = dao.getNextSeq();
		//DTO Id에 저장
		data.setId(seq);
		
		boolean result = dao.insertData(data);
									//data에 id, title, content, empId값 들어있음
		if(result) {//추가 성공하면 1반환 될거고
			dao.commit();
			dao.close();
			return data.getId(); //id값 반환
		}
		
		dao.rollback();
		dao.close();
		return -1;
	}

	public EmpBoardDTO getData(int id) {
		EmpBoardDAO dao = new EmpBoardDAO();
		EmpBoardDTO data = dao.selectData(id);
		dao.close();
		
		return data;
	}
	
	public List<EmpBoardDTO> getAll() {
		EmpBoardDAO dao = new EmpBoardDAO();
		List<EmpBoardDTO> datas = dao.searchData();
		dao.close();
		return datas;
	}

	public void incViewCnt(HttpSession session, EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardStaticsDTO staticsData = new EmpBoardStaticsDTO();
		
		//식별자로 쓰일 id 값들을 저장해주고
		staticsData.setbId(data.getId());//시퀀스 번호
		staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());
		//식별자로 담은 id값들을 쿼리로 보내서 해당아이디에 해당하는 데이터 받아오고
		staticsData = dao.selectStatics(staticsData);
		
		//데이터 정상적으로 받아오면 이미 조회기록이 있다는 것이므로 7주일 후에 조회수 오르게하고
		//데이터가 비어있을 경우 식별자 아이디 정보 dao.insertStatics로 보내서 정상 업데이트 되면.
		//조회수 올린다.
		boolean result = false;
		if(staticsData == null) {
			result = dao.updateViewCnt(data);
			//식별자 아이디 저장하고  dao.insertStatics로 보내서 조회기록DB에 추가되게 끔 한다.
			staticsData = new EmpBoardStaticsDTO();
			staticsData.setbId(data.getId());//어느게시물
			staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());//누가
			dao.insertStatics(staticsData);
			//추가 과정 진행되면 아래 IF문 실행
		} else {
			long timeDiff = new Date().getTime() - staticsData.getLatestViewDate().getTime();
							//현재일자기준 밀리초 - 해당아이디의 이전 조회 기록일자의 밀리초
			if(timeDiff / (1000 * 60 * 60 * 24) >= 7) {
				//위의 계산 값을 하루에 해당하는 밀리초값으로 나눴을 때 7초과면 7일 넘게 지난것이므로
				result = dao.updateViewCnt(data);// IF문에 부합하면 뷰+1하고
				dao.updateStatics(staticsData);// 다시 조회 일자 당일로 초기화 
				//업데이트 boolean값 반환 받아와서 아래 if문 진행
				//조회정보가 없거나 7일 이후의 조회기록이 있을경우에만 조회수 1증가하고 아닐경우 안올림
			}
		}
		
		if(result) {
			data.setViewCnt(data.getViewCnt() + 1);
			dao.commit();
			dao.close();
		}
		dao.rollback();
		dao.close();
	}

	
	public void incLike(HttpSession session, EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		//컨트롤러를 통해 세션데이터를 받고 거기서 세션아이디값 따로 저장하고 
		EmpsDTO empData = (EmpsDTO)session.getAttribute("loginData");
		EmpBoardStaticsDTO staticsData = new EmpBoardStaticsDTO();
		staticsData.setbId(data.getId());
		staticsData.setEmpId(empData.getEmpId());//세션에서 아이디 얻어오기
		
		staticsData = dao.selectStatics(staticsData);
		//이전에 추천을 했는지 안했는지 확인
		if(staticsData.isLiked()) {
			//이전에 추천을 한 기록이 있으면 -> 추천 취소로 전환
			staticsData.setLiked(false);
			data.setLike(data.getLike() - 1);
		}else {
			//이전에 추천을 한 기록이 없으면 -> 추천으로 전환
			staticsData.setLiked(true);
			data.setLike(data.getLike() + 1);
		}
		
		dao.updateStaticsLike(staticsData);
		boolean result = dao.updateLike(data);

		if(result) {
			dao.commit();
		}else {
			dao.rollback();
		}
		dao.close();
	}

	public boolean modify(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		boolean result = dao.updateData(data);
		
		if(result) {
			dao.commit();
		}
		dao.close();
		
		return result;
	}

	public boolean remove(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardStaticsDTO staticsData = new EmpBoardStaticsDTO();
		staticsData.setbId(data.getId());
		
		dao.deleteStaticsData(staticsData);
		boolean result = dao.deleteData(data);
		
		if(result) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		return result;
	}

	
}