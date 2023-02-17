
$(".hdbtn.lgibtn").on("click", login);
$(".hdbtn.lgobtn").on("click", logout);
$(".hdbtn.enrbtn").on("click", enroll);

function login() {
	console.log("로그인버튼");
	location.href="<%= request.getContextPath() %>/login";
}

function logout() {
	console.log("로그아웃버튼");
	location.href="<%= request.getContextPath() %>/logout";
}

function enroll() {
	console.log("회원가입버튼");
	location.href="<%= request.getContextPath() %>/enroll";
}