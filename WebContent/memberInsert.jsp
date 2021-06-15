<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학기록 | 회원가입</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
	@import url('https://fonts.googleapis.com/css2?family=Nanum+Myeongjo:wght@700&display=swap');
	* {
		margin: 0;
		padding: 0;
		font-family: 'Noto Sans KR', sans-serif;
	}
	h1{
		font-family: 'Nanum Myeongjo', serif;
		padding: 50px;
		text-align: center;
		letter-spacing: 10px;
		font-size: 50px;
	}
	h2 {
		text-align: center;
		letter-spacing: 5px;
	}
	form {
		width: 330px;
		margin: auto;
	}
	#main {
		border: solid #FFC81E;
		width: 600px;
		height: 420px;
		margin: auto;
		padding: 20px;
	}
	li {
		padding-top: 20px;
		font-size: 15px;
		line-height: 30px;
		list-style: none;
	}
	input {
		width: 330px;
		height: 40px;
		font-size: 20px;
		border: none;
		border-bottom: 3px solid #D5D5D5;
		outline: none;
	}
	input[type="submit"] {    
  		height: 50px;
  		font-weight: bold;
  		border:1px solid #D5D5D5; 
  		margin-top: 10px;
	}
	input[type="submit"]:hover {
		background-color: #FFC81E;
		color: #ffffff;
	}
	p {
		margin-top: 10px;
		color: #FF3523;
		font-weight: bold;
	}
</style>
</head>
<body>
<div id="logo">
		<h1>대학기록</h1>
</div>
	<div id = "main">
	<form action="memberInsert.do" method="post">
		<h2>회원가입</h2>
		<ul>
			<li>
				<label for="id">아이디 *</label>
				<input type="text" name="id" autofocus>
			</li>
			<li>
				<label for="pwd">비밀번호 *</label>
				<input type="password" name="pwd">
			</li>
			<li>
				<label for="name">이름 *</label>
				<input type="text" name="name">
			</li>
		</ul>
		<p>${error }</p>
		<input type="submit" value="가입하기">
	</form>
	</div>
</body>
</html>