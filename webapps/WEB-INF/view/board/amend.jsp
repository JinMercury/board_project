<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/amend.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<form action="amend" method="post">
			<div class="amendDiv">
				<select class="select" name="boardDiv">
				<c:choose>
					<c:when test="${vo.boardDiv eq '공지'}">
						<option value="공지" selected>공지</option>
						<option value="잡담">잡담</option>
					</c:when>
					<c:when test="${vo.boardDiv eq '잡담'}">
						<option value="공지">공지</option>
						<option value="잡담" selected>잡담</option>
					</c:when>
				</c:choose>
				</select>
				<div class="textDiv">
					<label class="text">제목</label>
					<input type="hidden" name="boardIdx" value="${vo.boardIdx}">
					<input type="text" name="boardSubject" placeholder="제목" value="${vo.boardSubject}">
				</div>
				<div class="textDiv">
					<label class="text content">내용</label>
					<textarea name="boardContent" placeholder="내용을 입력해 주세요.">${vo.boardContent}</textarea>
				</div>
			</div>
			<button class="amendbtn" type="submit">수정</button>
		</form>
	</section>
</body>
</html>