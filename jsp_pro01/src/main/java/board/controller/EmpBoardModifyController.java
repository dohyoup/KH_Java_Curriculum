package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.EmpBoardDTO;
import board.service.EmpBoardService;
import emps.model.EmpsDTO;

@WebServlet("/board/modify")
public class EmpBoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		EmpBoardService service = new EmpBoardService();
		EmpBoardDTO dto = new EmpBoardDTO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		//특정 id에 대한 게시물 정보 조회
		EmpBoardDTO data = service.getData(Integer.parseInt(id));
		EmpsDTO empsData = (EmpsDTO)session.getAttribute("loginData");
		//게시글 작성한 사람 id == 로그인 사람 id
		if(data.getEmpId() == empsData.getEmpId()) {
			//저간 만족하면 데이터세팅
		request.setAttribute("data", data);
		
		String view = "/WEB-INF/jsp/board/modify.jsp";
		request.getRequestDispatcher(view).forward(request, response);
		} else {
			//리다이렉트 혹은 에러페이지로 포워드
		}
	 
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		//특정 id에 대한 게시물 정보 조회
		EmpBoardDTO data = service.getData(Integer.parseInt(id));
		//로그인한 계정 정보
		EmpsDTO empsData = (EmpsDTO)session.getAttribute("loginData");
		
		if(data.getEmpId() == empsData.getEmpId()) {
				data.setTitle(title);
				data.setContent(content);
				
				boolean result = service.modify(data);
				
				if(result) {
					//수정요청한 그 디테일 페이지로
					response.sendRedirect(request.getContextPath() + "/board/detail?id=" + data.getId());
				}else {
					doGet(request, response);
				}
		}else {
			//리다이렉트 혹은 에러페이지로 포워드
		}
	}
	
}