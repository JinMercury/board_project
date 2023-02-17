<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/login.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 로그인</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<div class="loginDiv">
			<div id="loginform">
				<form action="login" method="post">
					<p class="logintext">로그인<p>
					<input type="text" name="memberId" placeholder="아이디">
					<br>
					<input type="password" name="memberPw" placeholder="비밀번호">
					<br>
					<button class="loginbtn" type="submit">로그인</button>
					<button class="enrollbtn" type="button">회원가입</button>
				</form>
				<c:if test="${not empty error}">
					<p style="color: red;">${error}</p>
				</c:if>
			</div>
		</div>
	</section>
	<script>
		$(".enrollbtn").on("click", enroll);
		
		function enroll() {
			location.href="<%= request.getContextPath() %>/enroll";
		}
	</script>
</body>
</html>