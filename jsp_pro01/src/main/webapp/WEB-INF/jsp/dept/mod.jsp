<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dept.model.DeptDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>부서 수정 화면</title>
	<%@ include file="../module/head.jsp" %>
</head>
<script type="text/javascript">
	function deptDupCheck(value) {
		$.ajax({
			type: "get",
			url: "/ajax/deptDupCheck",
			data: {
				deptId: value
			},
			dataType: "json",
			success: function(data, status) {
				var form = document.forms[0];
				if(data.errCode === "duplicate") {
					if(form.deptId.nextElementSibling === null) {
						var label = document.createElement("label");
						label.setAttribute("class", "input-label-error");
						label.innerText = data.errMessage;
						form.deptId.after(label);
					}else {
						form.deptId.nextElementSibling.setAttribute("class", "input-label-error");
						form.deptId.nextElementSibling.innerText = data.errMessage;
					}
				} else if(data.errCode === "notDuplicate"){
					if(form.deptId.nextElementSibling === null) {
						var label = document.createElement("label");
						label.setAttribute("class", "input-label-error");
						label.innerText = data.errMessage;
						form.deptId.after(label);
					} else {
						form.deptId.nextElementSibling.setAttribute("class", "input-label-error");
						form.deptId.nextElementSibling.innerText = data.errMessage;
					}
				}
			}
		});
	}		
function deptExistsCheck(value) {
	$.ajax({
			type: "get",
			url: "/ajax/deptExistsCheck",
			data: {
				deptName: value
			},
			dataType: "json",
			success: function(data, status) {
				var form = document.forms[0];
				if(data.errCode === "notExists") {
					if(form.deptName.nextElementSibling === null) {
						var label = document.createElement("label");
						label.setAttribute("class", "input-label-error");
						label.innerText = data.errMessage;
						form.deptName.after(label);
					}else{
						form.deptName.nextElementSibling.setAttribute("class", "input-label-error");
						form.deptName.nextElementSibling.innerText = data.errMessage;
					}
				}else if(data.errCode === "exists") {
					if(form.deptName.nextElementSibling === null) {
						var label = document.createElement("label");
						label.setAttribute("class", "input-label-error");
						label.innerText = data.errMessage;
						form.deptName.after(label);
					}else{
						form.deptName.nextElementSibling.setAttribute("class", "inupt-label-error");
						form.deptName.nextElementSibling.innerText = data.errMessage;
					}
				}
			}
	});
}
</script>
<body>
	<h1>부서 수정 화면</h1>
	<c:if test="${not empty data}">
	<form action="./mod" method="post">
		<div>
			<input type="text" name="deptId" onclick="deptDupCheck(this.value)" value="${data.deptId}">
		</div>
		<div>
			<input type="text" name="deptName" onkeyup="deptExistsCheck(this.value);" value="${data.deptName}" >
		</div>
		<div>
			<input  type="text" name="mngId" value="${data.mngId}" readonly>
		</div>
		<div>
			<input type="text" name="locId" value="${data.locId}"  readonly>
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
	</c:if>
</body>
</html>