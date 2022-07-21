package common.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public abstract class AbstractDAO<C, E> {
	
	protected SqlSession session = DBConn.getSqlSession();
	
	public abstract C selectAll(); //제네릭 타입 생성해주는 과정 
	public abstract E selectId(E e); //제네릭 타입 생성해주는 과정 
	public abstract E selectId(int id); //제네릭 타입 생성해주는 과정 
	public abstract int rowCount(); //제네릭 타입 생성해주는 과정 
	public abstract boolean insertData(E e); //제네릭 타입 생성해주는 과정 
	public abstract boolean updateData(E e); //제네릭 타입 생성해주는 과정 
	public abstract boolean deleteData(int id); //제네릭 타입 생성해주는 과정 
	public abstract boolean deleteData(E e); //제네릭 타입 생성해주는 과정 
	
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
