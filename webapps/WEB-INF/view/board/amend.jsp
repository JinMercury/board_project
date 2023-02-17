<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/amend.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<form action="write" method="post">
			<div class="writeDiv">
				<select class="select">
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
			<button class="writebtn" type="submit">수정</button>
		</form>
	</section>
</body>
</html>