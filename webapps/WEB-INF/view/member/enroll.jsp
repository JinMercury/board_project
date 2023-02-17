<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/enroll.css">
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
					<input type="text" name="nickname" placeholder="닉네임">
					<br>
					<button class="enrollbtn" type="submit">회원가입</button>
					<div id="errDiv"></div>
				</form>
			</div>		
		</div>
	</section>
	
	<script>
		$(document).ready(function(){
			$('input[name=pwCheck]').change(function(){
				if($('input[name=memberPw]').val() === $('input[name=pwCheck]').val()) {
					$("#errDiv").html("<p style='color: green;'>비밀번호가 같습니다.</p>");
					$(".enrollbtn").removeAttr("disabled");
				} else {
					$("#errDiv").html("<p style='color: red;'>비밀번호가 다릅니다.</p>");
					$(".enrollbtn").attr("disabled", "disabled");
				}
			});
			
			$('input[name=memberPw]').change(function(){
				if($('input[name=memberPw]').val() === $('input[name=pwCheck]').val()) {
					$("#errDiv").html("<p style='color: green;'>비밀번호가 같습니다.</p>");
					$(".enrollbtn").removeAttr("disabled");
				} else {
					$("#errDiv").html("<p style='color: red;'>비밀번호가 다릅니다.</p>");
					$(".enrollbtn").attr("disabled", "disabled");
				}
			});
		});
	</script>
</body>
</html>