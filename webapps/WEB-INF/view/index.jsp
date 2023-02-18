<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/index.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 메인</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<div class="tabDiv">
			<table>
				<tr>
					<td>글번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
				</tr>
				<c:forEach var="data" items="${getList}">
					<tr>
						<td>${data.boardIdx}</td>
						<td>${data.boardWriter}</td>
						<td>
							<a href="./post?idx=<c:out value='${data.boardIdx}'/>" style="color: black">
								<span>[${data.boardDiv}]</span>
								<span>${data.boardSubject}</span>
							</a>
							<span>(${data.viewCount})</span>
						</td>
						<td>${data.boardDate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="writeDiv">
			<button class="btn writeBtn" type="button">글쓰기</button>
		</div>
		<div class="searchDiv">
			<form>
				<select class="select" name="selDiv">
					<option value="공지">공지</option>
					<option value="잡담">잡담</option>
				</select>
				<input type="text" name="searchInp" placeholder="검색어">
				<button class="btn searchBtn" type="submit">검색</button>
			</form>
		</div>
	</section>
</body>
</html>