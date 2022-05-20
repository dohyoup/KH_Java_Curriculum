package com.join.controller;

import com.join.dao.JoinDAO;
import com.join.vo.JoinVO;

public class JoinController {
	
	private JoinDAO dao = new JoinDAO();
	
	
	public boolean join(JoinVO data) {
		//회원 가입 처리 전 필여한 로직(데이터 검사, 계산 등.)
		//회원 가입 처리 후 결과를 반환한다.
		
		//가입을 진행하기 전에 아이디 중복 확인
		JoinVO account = dao.get(data.getUserid());
		if(account == null) {
			boolean result = dao.add(data);
			if(result) {
				return true;
			}
		}
		return false;
	}
	
	
	public JoinVO login(String userid, String userpw) {
		JoinVO account = dao.get(userid);
		
		//userid 에 해당하는 계정이 있는지 확긴.
		if(account != null) {
			if(account.getUserpw().equals(userpw)) {
				return account;
			}
		}
		return null;
		//해당 계정이 userpw 의 값과 동일한 패스워드를 가지고 있는지 확인 후
		
		//동일한 정보면 사용자 정보 객체 (JoinVO)전달 아니면 null전달
	}
	
	public boolean update(JoinVO data) {
		return dao.modify(data);
	}
	
	
	public boolean remove(JoinVO data, String password) {
		if(data.getUserpw().equals(password)) {
			return dao.remove(data);
		}else {
			return false;
		}
	}
	
	
}	
