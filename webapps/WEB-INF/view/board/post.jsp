<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/post.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<div class="postDiv">
			<div class="spanDiv">
				<span class="text">작성자</span>
				<span class="text">작성자</span>
				<span class="text">작성일</span>
				<span class="text">작성일</span>
			</div>
			<div class="spanDiv">
				<span class="text">[분류] 제목</span>
				<span class="text">[분류] 제목</span>
			</div>
			<div class="contents">
				내용
			</div>
		</div>
		<div class="comment">
			<div class="commDiv">
				<span class="comm">작성자</span>
				<span class="comm">작성자</span>
				<span class="comm">작성일</span>
				<span class="comm">작성일</span> <br><br>
				<span class="comm"> 내용 </span>
			</div>
			<div class="commDiv">
				<span class="comm">작성자</span>
				<span class="comm">작성자</span>
				<span class="comm">작성일</span>
				<span class="comm">작성일</span> <br><br>
				<span class="comm"> 내용 </span>
			</div>
		</div>
		<div class="comWriDiv">
			<form action="post" method="post">
				<input type="text" name="memberId" placeholder="댓글 작성">
				<button class="commbtn" type="submit">작성</button>
			</form>
		</div>
	</section>
</body>
</html>