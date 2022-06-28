package dept.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public class DeptDAO {
	//데이터베이스에 접근
	private SqlSession session;
	
	public DeptDAO() {
		session = DBConn.getSqlSession();
	}
	
	public List<DeptDTO> searchAll() {
		List<DeptDTO> datas = session.selectList("deptMapper.deptSelectAll");
		return datas;
	}
	

}
