package board.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public class EmpBoardDAO {
	private String mapper = "empBoardMapper.%s";
	private SqlSession session;
	
	
	public EmpBoardDAO() {
		this.session = DBConn.getSqlSession();
	}
	
	public int getNextSeq() {
		String mapperId = String.format(mapper, "getNextSeq");
		int seq= session.selectOne(mapperId);
		return seq;
	}

	public boolean insertData(EmpBoardDTO data) {
		int res = session.insert("empBoardMapper.insertData", data);
		return res ==1 ? true : false;
	}
	
	public EmpBoardDTO selectData(int id) {
		String mapperId = String.format(mapper, "selectData");
		EmpBoardDTO res= session.selectOne(mapperId, id);
		return res;
	}
	
	public boolean updateData(EmpBoardDTO data) {
		String mapperId = String.format(mapper,  "updateDataMap");
		int res = session.update(mapperId, data);
		return res == 1 ? true: false;
	}
	
	public boolean updateLike(EmpBoardDTO data) {
		String mapperId = String.format(mapper,  "updateLike");
		int res = session.update(mapperId, data);
		return res == 1 ? true: false;
	}
	
	public void commit() {
		this.session.commit();
	}
	
	public void rollback() {
		this.session.rollback();
	}
	
	public void close() {
		this.session.close();
	}



}
