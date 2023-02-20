<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/write.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<form action="write" method="post">
			<div class="writeDiv">
				<select class="select" name="boardDiv">
					<option value="공지">공지</option>
					<option value="잡담">잡담</option>
				</select>
				<div class="textDiv">
					<label class="text">제목</label>
					<input type="text" name="boardSubject" placeholder="제목">
				</div>
				<div class="textDiv">
					<label class="text content">내용</label>
					<textarea name="boardContent" placeholder="내용을 입력해 주세요."></textarea>
				</div>
			</div>
			<div class="btnDiv">
				<button class="writebtn" type="submit">작성</button>
			</div>
		</form>
	</section>
</body>
</html>