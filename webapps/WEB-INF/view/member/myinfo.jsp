<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/myinfo.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 회원정보</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<c:set var="vo" value="${lgnss}" />
		<div class="myinfoDiv">
			<div id="myinfoform">
				<form action="myinfo" method="post">
					<p class="myinfotext">회원정보<p>
					<input type="text" name="memberId" value="${vo.memberId}" readonly>
					<br>
					<input type="password" name="memberPw" placeholder="비밀번호">
					<br>
					<input type="password" name="pwCheck" placeholder="비밀번호 확인">
					<br>
					<input type="text" name="nickname" value="${vo.nickname}">
					<br>
					<button class="myinfobtn" type="submit">수정</button>
					<div id="errDiv">
						<c:if test="${not empty infoErr}">
							<p style='color: red;'>${infoErr}</p>
						</c:if>
					</div>
				</form>
			</div>		
		</div>
	</section>
	
	<script>
		$(document).ready(function(){
			$('input[name=pwCheck]').change(function(){
				if($('input[name=memberPw]').val() === $('input[name=pwCheck]').val()) {
					$("#errDiv").html("<p style='color: green;'>비밀번호가 같습니다.</p>");
					$(".myinfobtn").removeAttr("disabled");
				} else {
					$("#errDiv").html("<p style='color: red;'>비밀번호가 다릅니다.</p>");
					$(".myinfobtn").attr("disabled", "disabled");
				}
			});
			
			$('input[name=memberPw]').change(function(){
				if($('input[name=memberPw]').val() === $('input[name=pwCheck]').val()) {
					$("#errDiv").html("<p style='color: green;'>비밀번호가 같습니다.</p>");
					$(".myinfobtn").removeAttr("disabled");
				} else {
					$("#errDiv").html("<p style='color: red;'>비밀번호가 다릅니다.</p>");
					$(".myinfobtn").attr("disabled", "disabled");
				}
			});
		});
	</script>
</body>
</html>