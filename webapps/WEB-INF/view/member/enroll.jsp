<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<div class="enrollDiv">
			<div id="enrollform">
				<form action="enroll" method="post">
					<p class="enrolltext">회원가입<p>
					<input type="text" name="memberId" placeholder="아이디">
					<br>
					<input type="password" name="memberPw" placeholder="비밀번호">
					<br>
					<input type="password" name="pwCheck" placeholder="비밀번호 확인">
					<br>
					<input type="text" name="memberPw" placeholder="닉네임">
					<br>
					<button class="enrollbtn" type="submit">회원가입</button>
				</form>
			</div>		
		</div>
	</section>
	
	<style>
		.enrollDiv {
			margin: 0 auto;
			margin-top: 20px;
			width: 80%;
			border: 4px solid #545454;
		}
		
		#enrollform {
			width: 100%;
			display: inline-block;
			text-align: center;
			height: 600px;
		}
		
		.enrollbtn {
			all: unset;
			background-color: #545454; 
			font-size: 24px;
			color: white;
			padding: 10px;
			width: 200px;
			border-radius: 12px;
			margin-top : 20px;
			margin-bottom : 20px;
		}
		
		input {
			margin: 10px;
			border: 6px solid #545454;
			width: 400px;
			height: 50px;
			font-size: 24px;
		}
		
		.enrolltext {
			padding-top: 20px;
			font-size: 30px;
			color: #545454;
		}
	</style>
</body>
</html>