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
	
	<style>
		.postDiv {
			margin: 0 auto;
			margin-top: 20px;
			width: 80%;
			height: 400px;
			border: 4px solid #545454;
		}
		
		.comment {
			margin: 0 auto;
			margin-top: 5px;
			width: 80%;
			height: 300px;
			border: 4px solid #545454;
		}
		
		.comWriDiv {
			margin: 0 auto;
			margin-top: 5px;
			width: 80%;
			height: 50px;
			border: 4px solid #545454;
		}
		
		.text {
			font-size: 16px;
			padding-right: 20px; 
		}
		
		.spanDiv {
			margin: 20px;
		}
		
		.contents {
			width: 90%;
			margin: 20px;
			margin-top: 30px;
		}
		
		.commDiv {
			margin-top: 10px;
		}
		
		.comm {
			padding-left: 10px;
			padding-right: 10px;
		}
		
		input {
			border: none;
			width: 700px;
			height: 40px;
			margin-top: 4px;
			margin-left: 10px;
			font-size: 16px;
		}
		
		.commbtn {
			all: unset;
			background-color: #545454; 
			font-size: 16px;
			color: white;
			padding: 10px;
			width: 70px;
			border-radius: 12px;
			float: right;
			margin-right: 10px;
			margin-top: 6px;
			text-align: center;
		}
	</style>
</body>
</html>