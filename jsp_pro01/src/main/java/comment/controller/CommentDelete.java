package comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.model.CommentDTO;
import comment.service.CommentService;
import emps.model.EmpsDTO;

@WebServlet("/comment/delete")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CommentService service = new CommentService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset-utf-8");
		HttpSession session = request.getSession(); // loginData 가져오기위함
		
		String id = request.getParameter("id");
		CommentDTO commentData = service.getData(Integer.parseInt(id));
		//loginData 에있는 직원아이디와 삭제를 시도하는 직원아이디가 같을 경우에만 삭제 가능
		EmpsDTO empData = (EmpsDTO)session.getAttribute("loginData");
		StringBuilder sb = new StringBuilder();
		sb.append("{");
			//댓글작성자 id  == 로그인한 사용자 id 일때만 삭제요청 동작
		if(commentData.getEmpId() == empData.getEmpId()) {
			boolean result = service.remove(commentData);
			if(result) {
				sb.append(String.format("\"%s\": \"%s\"", "code", "success"));
			}else {
				sb.append(String.format("\"%s\": \"%s\"", "code", "error"));
			}
		}else {
			sb.append(String.format("\"%s\": \"%s\"", "code", "error"));
		}
		sb.append("}");
		response.getWriter().append(sb.toString());
		response.getWriter().flush();
	}
}


