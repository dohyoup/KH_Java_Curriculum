<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome JSP/Servlet</title>
	<%@ include file="./module/head.jsp" %>
</head>
<script type="text/javascript">
	
</script>
<body>
	<%@ include file="/WEB-INF/jsp/module/navigation.jsp" %>
	<section class="container">
		<c:url var="loginUrl" value="/login" />
		<form class="small-form" action="${loginUrl}" method="post">
			<div class="input-form wide">
				<label class="input-label">직원ID</label>
				<input class="input-text" type="text" name="empId" value="">
				<c:if test="${errorCode eq 'deptId'}">
					<label class="input-label-error">${errorMsg}</label>
				</c:if>
			</div>
			<div class="input-form wide">
				<label class="input-label wide">부서명</label>
				<select class="select-form" name="deptId">
					<c:forEach items="${deptDatas}" var="deptDto">
						<option value="${deptDto.deptId}">${deptDto.deptName}</option>
					</c:forEach>
				</select>
				<c:if test="${errorCode eq 'deptId'}">
					<label class="input-label-error">${errorMsg}</label>
				</c:if>
			</div>
			<div class="input-form wide">
				<label class="input-label">이름</label>
				<input class="input-text" type="text" name="empName" value="">
				<c:if test="${errorCode eq 'deptName'}">
					<label class="input-label-error">${errorMsg}</label>
				</c:if>
			</div>
			<div class="input-form wide form-right">
				<button class="btn btn-outline btn-ok" type="submit">로그인</button>
			</div>
			<div>
				<label class="input-label">로그인 유지</label>
				<input type="checkbox" name="useCookie">
			</div>
		</form>
	</section>
</body>
</html>