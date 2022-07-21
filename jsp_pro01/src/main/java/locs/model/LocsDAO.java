package locs.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;



public class LocsDAO {
	
	
private SqlSession session;
	
	public LocsDAO() {
		session = DBConn.getSqlSession();
	}
	
	public List<LocsDTO> searchAll() {
		List<LocsDTO> datas = session.selectList("locsMapper.locsSelectAll");
		return datas;
	}
	
	public LocsDTO serachLocsId(int id) {
		LocsDTO data = session.selectOne("locsMapper.locsSelectId", id);
		return data;
	}
	
	public List<LocsDTO> searchPage(int start, int end) {
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		List<LocsDTO> datas = session.selectList("locsMapper.selectPage", page);
		return datas;
	}
	
	public List<LocsDTO> searchPage(int start, int end, String sort) {
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("start", start);
		page.put("end", end);
		
		switch(sort) {
			case "locationId":
				page.put("sort", 1); break;
			case "streetAddress":
				page.put("sort", 2); break;
			case "postalCode":
				page.put("sort", 3); break;
			case "loccityId":
				page.put("sort", 4); break;
			case "stateProvince":
				page.put("sort", 5); break;
			case "countryId":
				page.put("sort", 6); break;	
		} 
		List<LocsDTO> datas = session.selectList("locsMapper.selectPage", page);
		return datas;
	}
	
	public int rowCount() {
		int count = session.selectOne("locsMapper.locsRowCount");
		return count;
	}
	
	public void commit() {
		session.commit();
	}
	
	public void rollback() {
		session.rollback();
	}
	
	public void close() {
		session.close();
	}

}
	
	
	
	
	
	
	
	
	
	
	

