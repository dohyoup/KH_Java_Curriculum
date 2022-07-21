package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ajax/test")
public class AjaxTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x= request.getParameter("x");
		String y= request.getParameter("y");
		
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		//클라이언트에서 서버에보내는 데이터 형식
		out.println("{");
		out.println("    \"attributeName\": \"value\"");
		out.println("}");
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
