<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 생성</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
	* {
		argin: 0;
		padding: 0;
		font-family: 'Noto Sans KR', sans-serif;
		font-size: 17px;
	}
	p {
		font-size: 20px;
		font-weight: bold;
		margin-left: 10px;
	}
	form {
		margin-left: 10px;
	}
	li {
		list-style: none;
		margin-top: 5px;
	}
	input[type="text"] {
		width: 230px;
		height: 30px;
		font-size: 16px;
		border: none;
		border-bottom: 2px solid #D5D5D5;
		outline: none;
		margin-left: 5px;
	}
	input[type="submit"] {
		padding: 2px 13px 2px 13px;
		border: 2px solid #FFC81E;
		color: #ffffff;
		background-color: #FFC81E;
		border-radius: 5px;
		margin-left: 5px;
	}
	input[type="button"] {
		padding: 2px 13px 2px 13px;
		border: 2px solid #FFC81E;;
		color: #FFC81E;
		background-color: #ffffff;
		border-radius: 5px;
		margin-left: 5px;
	}
	textarea {
		outline: none;
		border: 2px solid #D5D5D5;
	}
	#pw {
		width: 215px;
	}
</style>
</head>
<script>
	function epw(){
		var pw="비밀번호 <input type='text' name='pwd' required id='pw'>";
		var password = document.getElementById('password');
		if(add.type.value == '비공개') {
			password.innerHTML = pw;
		} else if(add.type.value == '공개'){
			password.innerHTML = "";
		}
	}
</script>
<body>
	<form name="add" action="addGroup.do" method="post">
		<ul>
			<li>
				구분 
				<label><input type="radio" name="type" value="공개" onclick="epw();" checked>공개</label>
				<label><input type="radio" name="type" value="비공개" onclick="epw();">비공개</label>
			</li>
			<li>
				아이디 <input type="text" name="gid" autofocus required>
				<input type="hidden" name="mtype" value="manager">
			</li>
			<li>
				그룹명 <input type="text" name="name" required>
			</li>
			<li id="password">
				
			</li>
			<li>소개<br>
				<textarea name="content" cols="33" rows="4" style="resize:none" required></textarea>
			</li>
		</ul>
		<input type="submit" value="생성">
		<input type="button" value="닫기" onClick="window.close(); opener.location.reload();">
	</form>
</body>
</html>