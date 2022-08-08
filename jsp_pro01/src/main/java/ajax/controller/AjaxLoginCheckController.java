package ajax.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.EmpBoardDTO;
import board.service.EmpBoardService;
import emps.service.EmpsService;

@WebServlet("/ajax/loginCheck")
public class AjaxLoginCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		EmpBoardService service = new EmpBoardService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EmpBoardDTO data = service.getData(Integer.parseInt(id));
		//로그인 유지 체크하면 쿠키 생성해서 클라로 보냄
		if(request.getParameter("useCookie")!=null) {
				Cookie loginCookie = new Cookie("loginCookie",String.valueOf(data.getId()));
				loginCookie.setPath("/");
            	loginCookie.setMaxAge(60*60*24*7);
            	response.addCookie(loginCookie);
		}
		
		//TODO 쿠키아이디와 유지기간을 DB까지 리턴시켜줄 메서드 구현
		//SERVICE DAO까지 관련 메서드 만들고 DB업데이트 쿼리작성(쿠키ID,유지시간)
		//쿠키키값이랑 사용자아이디
	}
}


