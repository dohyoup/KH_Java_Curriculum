package com.conn.exam;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.conn.db.DBConn;

public class Employees {
	
	private DBConn db;
	
	public Employees() throws Exception {
		db = new DBConn("localhost","1521","XE", "puser2","puser2");
	}
	
	public void getSalary() throws Exception  {
		/*
		 * salary 에 해당하는 데이터를 조회하여 출력해보기.
		 * 출력에 사용할 컬럼은 EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY 로 한다.
		 */
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES WHERE SALARY = ?" ;
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setInt(1, 10000);
			ResultSet rs = db.sendSelectQuery();
			while(rs.next()) {
				System.out.println("EMPLOYEE_ID : " + rs.getInt("EMPLOYEE_ID"));
				System.out.println("FIRST_NAME : " + rs.getString("FIRST_NAME"));
				System.out.println("LAST_NAME : " + rs.getString("LAST_NAME"));
				System.out.println("SALARY : " + rs.getInt("SALARY"));
				System.out.println("------------------------------------------");
			}
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		
//		Connection conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "puser2","puser2");
//		
//		Statement stat1 = conn1.createStatement();
//		
//		ResultSet ra = stat1.executeQuery("SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES");
//		while(ra.next()) {
//			System.out.print(ra.getString(1) + "\t"); //첫번째 컬럼을 출력해라
//			System.out.print(ra.getString(2) + "\t"); //두번째 컬럼을 출력해라
//			System.out.print(ra.getString(3) + "\t"); //세번째 컬럼을 출력해라
//			System.out.print(ra.getString(4) + "\n"); //네번째 컬럼을 출력해라
//		}
//		ra.close();
//		stat1.close();
//		conn1.close();
	}
	
	public void close() {
		try {
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception  {
		Employees emp = new Employees();
		emp.getSalary();
		emp.close();
}
}
