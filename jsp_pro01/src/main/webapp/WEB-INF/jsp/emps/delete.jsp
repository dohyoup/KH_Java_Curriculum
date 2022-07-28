<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보 삭제</title>
</head>

<body>
	<c:if test="${empty error}">
		<form action="/emps/delete" method="post">
			<input type="hidden" name="empId" value="${empsData.empId}">
			<ul>
				<li>${empsData.empName}</li>
				<li>${empsData.email}</li>
			</ul>
			<p>삭제하려는 데이터가 맞습니까?</p>
			<div>
				<button type="submit">삭제</button>
				<button type="button" onclick="location.href='/emps/detail?id=${empsData.empId}'">취소</button>
			</div>
		</form>	
	</c:if>
	<c:if test="${not empty error}">
		<h1>${error}</h1>
	</c:if>
</body>
</html>