package locs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import locs.model.LocsDTO;
import locs.service.LocsService;

@WebServlet("/locs")
public class LocsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LocsService service = new LocsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/locs/index.jsp";
		String search = request.getParameter("search");
		String page = request.getParameter("page");
		String sort = "locsId";
		int count = 5;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("pgc") != null) {//값 가져오기
			count = Integer.parseInt(session.getAttribute("pgc").toString());
		}
		if(session.getAttribute("sort") != null) {
			sort=(String)session.getAttribute("sort");
		}
		if(request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
		}
		if(request.getParameter("pgc") != null) {
			count = Integer.parseInt(request.getParameter("pgc"));
		}
		session.setAttribute("pgc", count);//값 저장하기
		session.setAttribute("sort", sort);
		
		request.setAttribute("menuLocation", "locs");
		List<LocsDTO> datas = null;
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
		}else {
			LocsDTO data = service.getLocsId(search);
			if(data != null) {
				datas = new ArrayList<LocsDTO>();
				datas.add(data);
			}
	}
		request.setAttribute("datas", datas);	
		request.getRequestDispatcher(view).forward(request, response);
	
	}

}
