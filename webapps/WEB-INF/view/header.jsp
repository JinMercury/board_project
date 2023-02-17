<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div class="hdDiv">
		<p class="logo"><a href="<%= request.getContextPath() %>/">LOGO</a></p>
		<div class="btnDiv">
			<button class="hdbtn lgibtn">로그인</button>
			<button class="hdbtn lgobtn">로그아웃</button>
			<button class="hdbtn enrbtn">회원정보</button>
		</div>
	</div>
</header>

<!-- style>
	@font-face {
	    font-family: 'NanumSquareNeo-Variable';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/NanumSquareNeo-Variable.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;
	}
	
	body {
		font-family: 'NanumSquareNeo-Variable';
	}
	
	.hdbtn {
		all: unset;
		position: absolute;
		font-size: 24px;
		color: white;
		background-color: #545454;
	}
	
	.lgibtn, .lgobtn {
		right: 25%;
		top: 130px;
	}
	
	.enrbtn {
		right: 14%;
		top: 130px;
	}

	.hdDiv {
		margin: 0 auto;
		margin-top: 50px;
		background-color: #545454;
		width: 80%;
		height: 110px;
		border: 4px solid #545454;
	}

	.logo {
		font-size: 36px;
		color: white;
		text-align: center;
	}
	
	.btnDiv {
		display: inline-block;
		float: right;
		padding: 20px;
		padding-top: 60px;
	}
	
	a {
		color: #fff;
		text-decoration: none;
		outline: none;
		text-align: center;
	}
	
	a:hover, a:active {
		text-decoration: none;
	}
</style-->