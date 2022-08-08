<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, board.model.EmpBoardDTO" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>게시글 수정</title>
	<link rel="stylesheet" type="text/css" href="/static/bs5/css/bootstrap.min.css">
	<script type="text/javascript" src="/static/bs5/js/bootstrap.min.js"></script>
</head>

<body>
	<header></header>
	<section class="container">
		<div class="mt-3">
			<c:url var = "boardModifyUrl" value="/board/modify"/>
			<form action="${boardModifyUrl}" method="post">
				<input type="hidden" name="id" value="${data.id}">				
				<div class="mb-3">
					<input class="form-control" type="text" name="title" value="${data.title}" placeholder="제목을 입력하세요.">
				</div>
				<div class="mb-3">
					<textarea class="form-control" name="content" rows="8"
						placeholder="내용을 입력하세요.">${data.content}</textarea>
				</div>
				<div class="mb-3 text-end">
					<button class="btn btn-primary" type="submit">저장</button>
				</div>
			</form>
		</div>
	</section>
	<footer></footer>
</body>
</html>