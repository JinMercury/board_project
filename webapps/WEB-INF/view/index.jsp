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
				<c:forEach var="data" items="${paging.page}">
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
		
		<div class="pageDiv">
			<c:set var="pageNumber" value="${empty param.p ? 1 : param.p}" />
			<c:choose>
				<c:when test="${requestScope.paging.prevPage eq -1}">
					<a> &lt; </a>
					<span>&#124;</span>
				</c:when>
				<c:otherwise>
					<c:if test="${empty param.selDiv && empty param.searchInp}">
						<a href="./&?p=${requestScope.paging.prevPage}"> &lt; </a>
						<span>&#124;</span>
					</c:if>
					<c:if test="${not empty param.selDiv || not empty param.searchInp}">
						<a href="./?selDiv=${param.selDiv}&searchInp=${param.searchInp}&p=${requestScope.paging.prevPage}"> &lt; </a>
						<span>&#124;</span>
					</c:if>
				</c:otherwise>
			</c:choose>
			<c:forEach var="pNum" items="${requestScope.paging.pageList}">
				<c:if test="${empty param.selDiv && empty param.searchInp}">
					<a href="./?p=${pNum}">${pNum}</a>
					<span>&#124;</span>
				</c:if>
				<c:if test="${not empty param.selDiv || not empty param.searchInp}">
					<a href="./?selDiv=${param.selDiv}&searchInp=${param.searchInp}&p=${pNum}">${pNum}</a>
					<span>&#124;</span>
				</c:if>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.paging.nextPage eq -1}">
					<a> &gt; </a>
				</c:when>
				<c:otherwise>
					<c:if test="${empty param.selDiv && empty param.searchInp}">
						<a href="./&?p=${requestScope.paging.nextPage}"> &gt; </a>
						</c:if>
					<c:if test="${not empty param.selDiv || not empty param.searchInp}">
						<a href="./?selDiv=${param.selDiv}&searchInp=${param.searchInp}&p=${requestScope.paging.nextPage}"> &gt; </a>
					</c:if>
				</c:otherwise>
			</c:choose>
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
	
	<script>
		$(".writeBtn").on("click", hrefWriteBtn);
	
		function hrefWriteBtn() {
			location.href = "<%= request.getContextPath() %>/write";
		}
	</script>
</body>
</html>