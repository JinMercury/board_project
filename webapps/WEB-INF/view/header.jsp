<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<div class="hdDiv">
		<p class="logo"><a href="<%= request.getContextPath() %>/">LOGO</a></p>
		<div class="btnDiv">
			<c:if test="${empty lgnss}">
				<button class="hdbtn lgibtn">로그인</button>
			</c:if>
			<c:if test="${not empty lgnss}">
				<button class="hdbtn lgobtn">로그아웃</button>
			</c:if>
			<button class="hdbtn enrbtn">회원정보</button>
		</div>
	</div>
</header>

	<script>
		$(".hdbtn.lgibtn").on("click", login);
		$(".hdbtn.lgobtn").on("click", logout);
		$(".hdbtn.enrbtn").on("click", enroll);
	
		function login() {
			location.href="<%= request.getContextPath() %>/login";
		}
	
		function logout() {
			location.href="<%= request.getContextPath() %>/logout";
		}
		
		function enroll() {
			location.href="<%= request.getContextPath() %>/myinfo";
		}
	</script>