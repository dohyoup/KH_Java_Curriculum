<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> <!-- 지시자 태그 페이지설정, 언어설정, 컨텐츠타입설정 -->
<%! // 선언태그나 스크립트릿 태그안에는 주석을 자바식 주석으로 사용가능
	//멤버변수
	private String name = "Hello"; //멤버변수 들어가는 선언문태그 함수선언도 가능
	//메서드
	public String hello() {
		return "Hello";
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP - Script Tag</title>
</head>
<body>
	<h1>JSP - Script Tag</h1>
	<ul>
	<%
		for(int i = 0; i < 5; i++ ) {
			Random rd = new Random();
	%>
		<li><%= rd.nextInt(100) %></li>
	<%
	}
	%>
	</ul>
	<input type="text" value="<%=name %>"><br>
	<input type="text" value="<%=hello() %>">
</body>
</html>