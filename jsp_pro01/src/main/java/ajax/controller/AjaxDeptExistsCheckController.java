package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/ajax/deptExistsCheck")
public class AjaxDeptExistsCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService deptService = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String value = request.getParameter("deptName");
			response.setContentType("application/json; charset=utf-8");
			String errMessage = "";
			//TODO 상세 로직 구현
			System.out.println(value);
			boolean is_deptname = deptService.existsDeptName(value);
			System.out.println(is_deptname);
			if(is_deptname) {
				errMessage = "    \"errMessage\": \"해당 부서명은 이미 있는 부서입니다.\"";
			}else {
				errMessage = "    \"errMessage\": \"해당 부서명은 수정 가능합니다.\"";
			}
			
			PrintWriter out = response.getWriter();
			if(!is_deptname) {
				out.println("{");
				out.println("    \"errCode\": \"exists\",");
				out.println("    \"errMessage\": \"정상.\"");
				out.println("}");
				out.flush();
			} else {
				out.println("{");
				out.println("    \"errCode\": \"notExists\",");
				out.println(errMessage);
				out.println("}");
				out.flush();
			}
		}
}
