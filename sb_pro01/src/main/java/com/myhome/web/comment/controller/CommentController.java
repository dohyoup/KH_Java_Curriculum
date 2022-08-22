package com.myhome.web.comment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhome.web.comment.model.CommentDTO;
import com.myhome.web.comment.service.CommentService;
import com.myhome.web.emp.model.EmpDTO;

@Controller
public class CommentController {
	

	@Autowired
	private CommentService service;
	
	@PostMapping(value="/comment/add" )
	@ResponseBody
	public String commentAdd(HttpSession session
			,HttpServletRequest request
			,@RequestParam String content
			,@RequestParam String bid) {
		JSONObject json = new JSONObject();
		EmpDTO empData = (EmpDTO)session.getAttribute("loginData");
		CommentDTO commentData = new CommentDTO();
		commentData.setbId(Integer.parseInt(bid));
		commentData.setContent(content);
		commentData.setEmpId(empData.getEmpId());
		
		boolean result = service.add(commentData);
		if(result) {
			json.put("data", request.getContextPath() +"/board/detail?id=" + commentData.getbId());
			return json.toJSONString();
		}else {
			json.put("data",request.getContextPath() +"/board/detail?id=" + commentData.getbId()); 
			return json.toJSONString();
		}
	}
	
	@PostMapping(value="/comment/modify")
	@ResponseBody
	public String commentModify(HttpSession session
			,@RequestParam String content
			,@RequestParam String id
			) {
		
		JSONObject json = new JSONObject();
		EmpDTO empData = (EmpDTO)session.getAttribute("loginData");
		CommentDTO commentData =service.getData(Integer.parseInt(id));
		
		if(empData.getEmpId() == commentData.getEmpId()) {
			commentData.setContent(content);
			boolean result = service.modify(commentData);
			if(result) {
				json.put("data", commentData.getContent()
						.replace("\r", "\\r").replace("\n", "\\n"));
				return json.toJSONString();
			}
		}
		return json.toJSONString();
	}
	
	@PostMapping(value="/comment/delete")
	@ResponseBody
	public String commentDelete(HttpSession session,
			@RequestParam String id) {
		
		JSONObject json = new JSONObject();
		EmpDTO empData = (EmpDTO)session.getAttribute("loginData");
		CommentDTO commentData =service.getData(Integer.parseInt(id));
		
		if(empData.getEmpId() ==  commentData.getEmpId()) {
			boolean result = service.remove(commentData);
			if(result) {
				json.put("code", "success");
				return json.toJSONString();
			}
		}
		return json.toJSONString();
	}
	
}
