<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, locs.model.LocsDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지역 조회 결과</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/default.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/form.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/navigation.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/paging.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/required.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/table.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/static/js/required.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/module/navigation.jsp" %>
	<section class="container">
		<div>
			<form action="./locs" method="get">
				<div class="input-form form-right">
					<input class="input-text" type="text" name="search"> <!-- search에 들어가는건 deptId 정보-->
					<button  class="btn btn-outline" type="submit">조회</button>
				</div>
			</form>
		</div>
	</section>	
		<table class="table wide vertical-hidden hover">
			<colgroup>
				<col class="col-120">
				<col class="col-auto">
				<col class="col-120">
				<col class="col-180">
				<col class="col-120">
			</colgroup>
			<thead>
			<tr>
				<th class="${sort == 'locationId' ? 'sort-desc' : ''}"
				onclick="location.href='./locs?page=${page}&sort=locationId'">LocationId
				</th>
				<th class="${sort == 'streetAddress' ? 'sort-desc' : ''}"
				onclick="location.href='./locs?page=${page}&sort=streetAddress'">StreetAddress
				</th>
				<th class="${sort == 'postalCode' ? 'sort-desc' : ''}"
				onclick="location.href='./locs?page=${page}&sort=postalCode'">PostalCode
				</th>
				<th class="${sort == 'city' ? 'sort-desc' : ''}"
				onclick="location.href='./locs?page=${page}&sort=city'">City
				</th>
				<th class="${sort == 'stateProvince' ? 'sort-desc' : ''}"
				onclick="location.href='./locs?page=${page}&sort=stateProvince'">StateProvince
				</th>
				<th class="${sort == 'countryId' ? 'sort-desc' : ''}"
				onclick="location/href='./locs?page=${page}&sort=countryId'">CountryId
				</th>
			</tr>
			</thead>
			<tbody>
				<c:if test="${not empty datas}">
						<c:forEach items="${datas}" var="data">
							<tr>
								<td>${requestScope.data.locationId}</td>
								<td>${data.streetAddress}</td>
								<td>${data.postalCode}</td>
								<td>${data.city}</td>
								<td>${data.stateProvince}</td>
								<td>${data.countryId}</td>
							</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	<c:if test="${not empty pageList}">
		<c:set var="currentPage" value="${page}"/>
			<div class="paging">
				<ul class="page center">
					<c:if test="${currentPage - 1 > 0 }">
						<li class="page-item">
							<a class="page-link" href="./depts?page=${currentPage - 1 }">Prev</a>
						</li>
					</c:if>
					<c:set var="i" value="${currentPage - 1 }"/>	
					<c:set var="maxPage" value="${i + 5 > pageList.size() ? pageList.size() : i + 5 }"/>
					<c:forEach begin="${i}" end="${maxPage -1}" var="num">
						<li class="page-item">
							<a class="page-link" href="./locs?page=${pageList.get(num)}">${pageList.get(num)}</a>
						</li>
					</c:forEach>
					<c:if test="${currentPage + 1 <= pageList.size()}">
						<li class="page-item">
							<a class="page-link" href="./depts?page=${currentPage + 1}">Next</a>
						</li>
					</c:if>
				</ul>
			</div>
			
	
	</c:if>		
</body>
</html>