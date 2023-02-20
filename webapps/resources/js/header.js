/**
 * 
 */

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