package emps.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emps.model.EmpsDTO;
import emps.service.EmpsService;

@WebServlet("/emps/delete")
public class EmpsDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String view = "/WEB-INF/jsp/emps/delete.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//선택한 아이디에 해당하는 데이터 가져오는 작업
		String id = request.getParameter("id");
		EmpsService empsService = new EmpsService();
		EmpsDTO empsData = empsService.getId(id);
		
		if(empsData == null) {
			request.setAttribute("error", "해당 데이터는 존재하지 않습니다.");
		}
		
		request.setAttribute("empsData",  empsData);
		
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("empId");
		//조회
		EmpsService empsService = new EmpsService();
		EmpsDTO empsData = empsService.getId(id);
		//이상확인
		if(empsData == null) {
			request.setAttribute("error", "해당 데이터는 이미 삭제되었습니다.");
		}
		//이상없으면 삭제진행
		
		boolean result = empsService.removeId(empsData.getEmpId());
		
		if(result) {
			response.sendRedirect("/emps");
			return;
		}else {
			request.setAttribute("error", "삭제 작업중 문제가 발생하였습니다.");
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

}
