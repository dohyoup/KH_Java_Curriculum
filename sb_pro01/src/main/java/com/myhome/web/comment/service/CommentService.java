package com.myhome.web.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.web.comment.model.CommentDAO;
import com.myhome.web.comment.model.CommentDTO;


@Service 
public class CommentService {

	@Autowired
	private CommentDAO dao;
	
	public boolean add(CommentDTO data) {
		
		boolean result = dao.insertData(data);
		
		if(!result) {
			throw new RuntimeException("댓글 등록에 문제가 발생하였습니다.");
		}
		
		return result;
	}

	public List<CommentDTO> getDatas(int id) {
		List<CommentDTO> datas = dao.selectDatas(id);
		return datas;
	}

	public CommentDTO getData(int id) {
		CommentDTO data = dao.selectData(id);
		return data;
	}

	public boolean remove(CommentDTO data) {
		boolean result = dao.deleteData(data);
		
		
		return result;
	}

	public boolean modify(CommentDTO commentData) {
		
		boolean result = dao.updateData(commentData);
		
		
		return result;
	}


	
}
