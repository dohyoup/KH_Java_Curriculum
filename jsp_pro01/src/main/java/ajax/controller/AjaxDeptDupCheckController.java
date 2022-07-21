package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/ajax/deptDupCheck")
public class AjaxDeptDupCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptService deptService = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String deptId = request.getParameter("deptId");
	response.setContentType("application/json; charset=utf-8");
	if(deptId != null) {
		DeptDTO data = deptService.getDeptId(deptId);
		
		PrintWriter out = response.getWriter();
			if(data != null) {
				out.println("{");
				out.println("    \"errCode\": \"duplicate\",");
				out.println("    \"errMessage\": \"정상.\"");
				out.println("}");
				out.flush();
			}   else {
				out.println("{");
				out.println("    \"errCode\": \"notDuplicate\",");
				out.println("    \"errMessage\": \"ID가 맞지 않습니다.\"");
				out.println("}");
				out.flush();
			}
		}
	
	}

}
