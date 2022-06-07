package com.conn.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBConn {

	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String BASE_URL = "jdbc:oracle:thin:@";
	
	private String url_address;
	private Connection conn;
	//private Statement stat;
	private PreparedStatement pstat;
	
	
	
	public DBConn(File config) throws Exception{
		
			Map<String, String> map = new HashMap<String, String>();
			
			BufferedReader br = new BufferedReader(new FileReader(config));
			
	//		StringBuilder sb = new StringBuilder();
			
				while(br.ready()) {
					String[] kv = br.readLine().split("=");
					map.put(kv[0].strip(), kv[1].strip());
				}
				
				if(map.get("host") != null) {
					url_address = String.format("%s:%s/%s",map.get("host"),map.get("port"), map.get("service"));
				} else if(map.get("tns_alias") != null) {
					url_address = String.format("%s?TNS_ADMIN=%s", map.get("tns_alias"), map.get("wallet_path"));
				} else {
					System.out.println(config.getName() + "파일의 데이터베이스 연결 구성 정보가 잘못되었습니다.");
				}
				
				this.createConnection(map.get("username"), map.get("password"));
		}	
	
	
	
	
	
	public DBConn(String address, String port, String serviceName, String username, String password) throws Exception {
		url_address = String.format("%s:%s/%s", address, port, serviceName);
		this.createConnection(username, password);
	}  
	public DBConn(String tnsAlias, String walletPath, String username, String password) throws Exception {
		url_address = String.format("%s?TNS_ADMIN=%s", tnsAlias, walletPath);
		this.createConnection(username, password);
	}
	
	
	
	
	
	private void createConnection(String username, String password) throws Exception {
		//1. Driver 등록
				Class.forName(DRIVER_NAME);
				
				//2. DBMS 연결
				conn = DriverManager.getConnection(BASE_URL + url_address, username, password);
				
				//3. Statement 생성
				//stat = conn.createStatement();
	}

	public PreparedStatement getPstat(String query) throws SQLException {// 외부로부터 쿼리를 먼저 받아야한다.
		pstat = conn.prepareStatement(query);
		return pstat;
	}
	
	
	
	
	
	//4. SQL 질의문 전송 및 반환
	//이 메소드를 호출하는 다른 외부객체로 리절트셋을 반환해서 이 리절트셋에 어떤데이터가있는지 추출 확인하는작업을할거다 외부클래스객체에서
	//프리페어스테이트 먼트는 일반 스테이트먼트와 달리 위의 생성때 외부에서 이미 쿼리를 받기때문에 호출때 따로 외부에서 쿼리를 안받아도 된다.
	public ResultSet sendSelectQuery() throws Exception {
		return this.pstat.executeQuery();
	}
	
	public int sendInsertQuery() throws Exception{
		return this.pstat.executeUpdate();
	}

	public int sendUpdateQuery() throws Exception{
		return this.pstat.executeUpdate();
	}

	public int sendDeleteQuery() throws Exception{
		return this.pstat.executeUpdate();
	}

	//5. 객체반환
	public void close() throws Exception{
	 this.pstat.close();
	 this.conn.close();
	}
	
	
	
//	public void localConnect() throws Exception {
		
		//4. SQL 질의문 전송 및 반환
//		int rowCount = stat.executeUpdate("INSERT INTO DEPARTMENTS VALUES(280, 'Tester', NULL, 1700)");
//	    int rowCount = stat.executeUpdate("UPDATE DEPARTMENTS SET DEPARTMENT_NAME = 'Dept Tester' WHERE DEPARTMENT_ID = 280");
//		int rowCount = stat.executeUpdate("DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = 280");
		
//		System.out.println(rowCount + "개 행이 반영되었습니다.");
		
	//}
		


}