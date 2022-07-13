package dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.model.DeptDTO;
import dept.service.DeptService;
import oracle.jdbc.internal.XSCacheOutput;

@WebServlet("/depts")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService service = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/dept/index.jsp";
		String search = request.getParameter("search");
		String page = request.getParameter("page");
		String sort = "deptId";
		int count = 5;
		
		HttpSession session = request.getSession();//세션생성
		if(session.getAttribute("pgc") != null) {//값 가져오기
			count = Integer.parseInt(session.getAttribute("pgc").toString());
		}
		if(session.getAttribute("sort") != null) {
			sort=(String)session.getAttribute("sort");
		}
		if(request.getParameter("pgc") != null) {
			count = Integer.parseInt(request.getParameter("pgc"));
		}
		if(request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
		}
		session.setAttribute("pgc", count);//값 저장하기
		session.setAttribute("sort", sort);
		
		
		/* 설정값 확인작업
		Cookie cookies[] = request.getCookies();
		for(Cookie c: cookies) {//처음 브라우저 실행시에 있는 쿠키 값 가져옴
			if(c.getName().equals("pgc")) {// 무조건 true
				count = Integer.parseInt(c.getValue());
			}
		}
		Cookie cookie = null;
		if(request.getParameter("pgc") != null) {
			count = Integer.parseInt(request.getParameter("pgc"));
			cookie = new Cookie("pgc", request.getParameter("pgc"));
		} else { //브라우저 처음접속했을때는 pgc값이 null이니깐
			cookie = new Cookie("pgc", String.valueOf(count)); // 생성해줌 여기서 count값은 위에 처음실행시 가져온 쿠키값
		}
		cookie.setMaxAge(60*60*24);
		cookie.setPath("/depts");//depts 하위 경로에서만 적용받도록 바뀜
		response.addCookie(cookie);
		 */
		
		
		request.setAttribute("pgc", count); // 현재 브라우저에있는 쿠키값을 바로 적용시키기 위해 따로 사용
		request.setAttribute("menuLocation", "depts");
		List<DeptDTO> datas = null;
		if(search == null) {
			int pageNum = 1;
			if(page != null) {
				if(!page.isEmpty() && page.matches("\\d+")) {
					pageNum = Integer.parseInt(page);
				}
			}
			datas = service.getPage(pageNum, count, sort);
			request.setAttribute("pageList", service.getPageNumberList(count));
			request.setAttribute("page", pageNum);
		} else {
			DeptDTO data = service.getDeptId(search);
			if(data != null) {
				datas = new ArrayList<DeptDTO>();
				datas.add(data);
			}
		}
		
		
		request.setAttribute("datas", datas);
		request.getRequestDispatcher(view).forward(request, response);
		
		
		
	}

}
