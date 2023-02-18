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
		<c:set var="getPost" value="${getPost}"/>
		<div class="postDiv">
			<div class="spanDiv">
				<span class="text">작성자</span>
				<span class="text">${getPost.boardWriter}</span>
				<span class="text">작성일</span>
				<span class="text">${getPost.boardDate}</span>
			</div>
			<div class="spanDiv">
				<span class="text">[분류] 제목</span>
				<span class="text">${getPost.boardSubject}</span>
			</div>
			<div class="contents">
				${getPost.boardContent}
			</div>
		</div>
		<div class="comment">
			<c:forEach var="getComm" items="${getComm}">
				<div class="commDiv">
					<span class="comm">작성자</span>
					<span class="comm">${getComm.commentWriter}</span>
					<span class="comm">작성일</span>
					<span class="comm">${getComm.commentDate}</span>
					<c:if test="${lgnss.nickname eq getComm.commentWriter}">
						<button class="commDel" type="button" value="${getComm.commentIdx}">삭제</button>
					</c:if>
					<br><br>
					<span class="comm">${getComm.commentContent}</span>
				</div>
			</c:forEach>
		</div>
		<div class="comWriDiv">
			<form action="post" method="post">
				<input type="hidden" name="boardIdx" value="${getPost.boardIdx}">
				<input type="text" name="commentContent" placeholder="댓글 작성">
				<c:if test="${not empty lgnss}">
				<button class="commbtn" type="submit">작성</button>
				</c:if>
				<c:if test="${empty lgnss}">
				<button class="commbtn" type="submit" disabled>작성</button>
				</c:if>
			</form>
		</div>
		<c:if test="${lgnss.nickname eq getPost.boardWriter}">
			<button class="btn postDel" type="submit">삭제</button>
			<button class="btn postAmd" type="submit">수정</button>
		</c:if>
	</section>
	
	<script>
		$(".commDel").on("click", commDel);
		$(".postDel").on("click", postDel);
		$(".postAmd").on("click", postAmd);
		
		function commDel() {
			$.ajax({
				url : "<%=request.getContextPath()%>/commdel",
				type : "post",
				async : false,
				data : {
					commidx : $('.commDel').val()
				},
				dataType : "text",
				success : function(){
					location.reload();
				}
			 });
		}
		
		function postDel() {
			$.ajax({
				url : "<%=request.getContextPath()%>/postdel",
				type : "post",
				async : false,
				data : {
					boardidx : $('input[name=boardIdx]').val()
				},
				dataType : "text",
				success : function(){
					location.href = "<%=request.getContextPath()%>/"
				}
			 });
		}
		
		function postAmd() {
			var boardidx = $('input[name=boardIdx]').val();
			location.href = "<%=request.getContextPath()%>/amend?idx="+boardidx
		}
	</script>
	
</body>
</html>