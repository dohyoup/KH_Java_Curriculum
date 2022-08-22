package com.myhome.web.comment.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSession session;
	
	public boolean insertData(CommentDTO data) {
		String mapId = String.format("commentMapper.%s", "insertData");
		int res = session.insert(mapId, data);
		return res == 1 ? true : false;
	}
	

	public List<CommentDTO> selectDatas(int id) {
		String mapId = String.format("commentMapper.%s", "selectDatas");
		List<CommentDTO> result = session.selectList(mapId, id);
		return result;
	}

	public CommentDTO selectData(int id) {
		String mapId = String.format("commentMapper.%s", "selectData");
		CommentDTO result = session.selectOne(mapId, id);
		return result;
	}

	
	public boolean deleteData(CommentDTO data) {
		String mapId = String.format("commentMapper.%s", "deleteData");
		int res = session.update(mapId, data);
		return res == 1 ? true : false;
	}
	
	public boolean updateData(CommentDTO commentData) {
		String mapId = String.format("commentMapper.%s", "updateData");
		int res = session.update(mapId, commentData);
		return res == 1 ? true : false;
	}







}
