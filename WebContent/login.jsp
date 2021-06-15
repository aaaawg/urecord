<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학기록</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
	@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@700&display=swap');
	* {
		margin: 0;
		padding: 0;
		font-family: 'Noto Sans KR', sans-serif;
	}
	#logo h1{
		font-family: 'Nanum Myeongjo', serif;
		padding: 50px;
		text-align: center;
		letter-spacing: 10px;
		font-size: 50px;
	}
	#login {
		padding-top: 70px;
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
	#sub a{
		text-decoration: none;
		color: #797979;
		font-size: 17px;
		padding-right: 15px;
		float: right;
	}
	#sub {
		padding-top: 20px;
		padding-right: 85px;
	}
	#main {
		width: 600px;
		height: 400px;
		margin: auto;
		border: solid #FFC81E;
	}
	#error {
		text-align: left;
		padding-left: 100px;
		color: #FF3523;
		font-weight: bold;
	}
</style>
</head>
<body>
<div id="logo">
	<h1>대학기록</h1>
</div>
<div id="main">
	<form action="memberLogin.do" method="post">
		<div id=login>
			<input type="text" name="id" placeholder="아이디" autofocus>
			<input type="password" name="pwd" placeholder="비밀번호">
			<p id="error">${error }</p>
			<input type="submit" value="로그인">
		</div>
	</form>	
	<div id="sub">
		<a href="adminLogin.jsp">관리자 로그인</a>
		<a href="memberInsert.jsp">회원가입</a>
	</div>
</div>

</body>
</html>