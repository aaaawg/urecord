<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 추가</title>
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
		width: 250px;
		height: 30px;
		font-size: 16px;
		margin-left: 5px;
	}
	input[type="submit"] {
		padding: 2px 13px 2px 13px;
		border: 2px solid #F08A8A;
		color: #ffffff;
		background-color: #F08A8A;
		border-radius: 5px;
		margin-left: 5px;
	}
	input[type="button"] {
		padding: 2px 13px 2px 13px;
		border: 2px solid #F08A8A;
		color: #F08A8A;
		background-color: #ffffff;
		border-radius: 5px;
		margin-left: 5px;
	}
	input {
		outline: none;
		border: none;
		margin-top: 10px;
		border-bottom: 2px solid #D5D5D5;
	}
</style>
</head>
<body>
<form action="addSubject.do" method="post"> 
	과목명 <input type="text" name="name" required autofocus ><br>
	<select name="week">
			<option value="1">월</option>
			<option value="2">화</option>
			<option value="3">수</option>
			<option value="4">목</option>
			<option value="5">금</option>
	</select>
	<input type="time" name="stime" required> - <input type="time" name="etime" required><br>
	<input type="submit" value="추가" onClick="opener.location.reload();">
	<input type="button"  value="닫기" onClick="window.close();">
</form>
</body>
</html>