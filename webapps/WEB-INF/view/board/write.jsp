<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
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
			<button class="writebtn" type="submit">작성</button>
		</form>
		
		
	</section>
	
	<style>
		.writeDiv {
			margin: 0 auto;
			margin-top: 20px;
			width: 80%;
			height: 500px;
			border: 4px solid #545454;
		}
		
		.btnDiv {
			margin: 0 auto;
			width: 80%;
		}
		
		.text {
			font-size: 24px;
			padding-right: 20px; 
		}
		
		.content {
			position: relative;
			bottom: 260px;
		}
		
		.select {
			margin-left: 30px;
			margin-top: 20px;
			margin-bottom: 10px;
			font-size: 16px;
			font-family: 'NanumSquareNeo-Variable';
			border: 2px solid #545454;
		}
		
		input {
			margin: 10px;
			border: 4px solid #545454;
			width: 80%;
			height: 50px;
			font-size: 24px;
		}
		
		textarea {
			margin: 10px;
			border: 4px solid #545454;
			width: 80%;
			height: 15em;
			font-size: 18px;
			font-family: 'NanumSquareNeo-Variable';
		}
		
		.textDiv{
			margin-left: 30px;
		}
		
		.writebtn {
			all: unset;
			background-color: #545454; 
			font-size: 16px;
			color: white;
			width: 100px;
			height: 30px;
			border-radius: 12px;
			text-align: center;
			padding: 10px;
			float: right;
			margin-right: 110px;
			margin-top: 20px;
		}
	</style>
</body>
</html>