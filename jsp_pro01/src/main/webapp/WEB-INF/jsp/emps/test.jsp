<!--
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보 추가</title>
<%@ include file="../module/head.jsp" %>
</head>
<body>
	<section class="container">
		<form class="small-form" action="./add" method="post">
			<div class="input-form-label">
				<label class="input-label">직원ID</label>
				<input class="input-text" type="text" name="empId" value="${data.empId}">		
			</div>
			<div class="input-form-label">
				<label class="input-label">성</label>
				<input class="input-text" type="text" name="firstName" value="${data.firstName}">		
			</div>
			<div class="input-form-label">
				<label class="input-label">이름</label>
				<input class="input-text" type="text" name="lastName" value="${data.lastName}">		
			</div>
			<div class="input-form-label">
				<label class="input-label">이메일</label>
				<input class="input-text" type="text" name="email" value="${data.email}">		
			</div>
			<div class="input-form-label">
				<label class="input-label">직급</label>
				<select class="select-form w-auto" name="jobName">
					<c:forEach items="${jobsName}">
						<option>${jobsName}</option>
					</c:forEach>
				</select>		
			</div>
			<div class="input-form-label">
				<label class="input-label">부서</label>
				<input class="input-text" type="text" name="deptName" value="${data.deptName}">		
			</div>
			<div class="input-form wide form-right">
				<button class="btn btn-outline btn-ok" type="submit">저장</button>
				<button class="btn btn-outline btn-cancel" type="button" onclick="location.href='../emps'">취소</button>
			</div>
		</form>
	</section>
</body>
</html>
-->