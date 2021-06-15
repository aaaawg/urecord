<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
	@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@700&display=swap');
	* {
		margin: 0;
		padding: 0;
		font-family: 'Noto Sans KR', sans-serif;
	}
	body {
		width: 1000px;
		height: 100px;
		margin: auto;
	}
	#nav {
		margin-left: 80px;
	}
	a {
		text-decoration: none;
		color: #000000;
	}
	#nav li {
		float: left;
		padding: 6px 25px;
		margin: 3px 4px 0px 4px;
		border: 1px solid #D5D5D5;
		border-bottom: none;
		background-color: #FFFFFF;
		list-style: none;
		border-top-left-radius: 10px;
		border-top-right-radius: 10px;
		font-weight: bold;
	}
	hr {
		clear: left;
	}
	#logo h1 {
		font-family: 'Nanum Myeongjo', serif;
		padding: 30px;
		letter-spacing: 5px;
		font-size: 50px;
	}
	#sc:hover {
		background-color: #FFCBCB;
	}
	#gr:hover {
		background-color: #FFFFA1;
	}
	#in:hover {
		background-color: #E0FF8B;
	}
	#lo:hover {
		background-color: #A5D8FA;
	}
	
</style>
</head>
<div id="logo">
	<h1>대학기록</h1>
</div>
<body>
<nav>
	<ul id='nav'>
		<li id="sc"><a href="memberSchedule.do">일정</a></li>
		<li id="gr"><a href="memberGroup.do">그룹</a></li>
		<li id="in"><a href="memberSearch.do">정보</a></li>
		<li id="lo"><a href="logout.do">로그아웃</a></li>
	</ul>
</nav>
	<hr>
</body>
</html>