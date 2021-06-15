<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학기록 | 관리자 로그인</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
	@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@700&display=swap');
	* {
		margin: 0;
		padding: 0;
		font-family: 'Noto Sans KR', sans-serif;
	}
	#logo a{
		font-family: 'Nanum Myeongjo', serif;
		letter-spacing: 10px;
		text-decoration: none;
		color: #000000;
		font-size: 50px;
		text: 50px;
	}
	#logo {
		text-align: center;
		padding: 50px;
	}
	#login {
		padding-top: 10px;
		text-align: center;
	}
	input {
		width: 400px;
		height: 40px;
		margin: 10px;
		font-size: 20px;
		border: none;
		border-bottom: 3px solid #D5D5D5;
		outline: none;
	}
	input[type="submit"] {  
  		height: 50px;
  		font-weight: bold;
  		border: 1px solid #D5D5D5; 
	}
	input[type="submit"]:hover {
		background-color: #FFC81E;
		color: #ffffff;
	}
	#main {
		width: 600px;
		height: 400px;
		margin: auto;
		border: solid #FFC81E;
	}
	p {
		font-size: 30px;
		text-align: center;
		font-weight: bold;
		padding-top: 50px;
	}
</style>
</head>
<body>
<div id="logo">
	<h1><a href="/urecord/login.jsp">대학기록</a></h1>
</div>
<div id="main">
	<form action="adminLogin.do" method="post">
		<p>관리자 로그인</p>
		<div id=login>
			<input type="text" name="id" placeholder="아이디" required>
			<input type="password" name="pwd" placeholder="비밀번호" required>
			<input type="submit" value="로그인">
		</div>
	</form>
</div>
</body>
</html>