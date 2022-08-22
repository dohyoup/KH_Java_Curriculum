package com.myhome.web.interceptor;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.myhome.web.emp.model.EmpDTO;


public class LoginInterceptor implements HandlerInterceptor {
	//로그인을 하지 않고 특정 기능에 접근하려 했을 때 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 HttpSession session = request.getSession();

		 if(session.getAttribute("loginData")==null){
			 String qs = "";
			 if(request.getQueryString() != null) {
				 qs = "?" + request.getQueryString();
			 }
			    EmpDTO empData = new EmpDTO();
				session.setAttribute("loginData", empData);
	            response.sendRedirect(request.getContextPath() + "/login?url=" + request.getRequestURI() + qs);
	        	return false;
	        }else{
	        	return true;
	        }
	    }
	     
	
}
