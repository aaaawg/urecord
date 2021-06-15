<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과제 추가</title>
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
	input[type="text"], [type="datetime-local"] {
		width: 290px;
		height: 30px;
		font-size: 16px;
		border: none;
		border-bottom: 2px solid #D5D5D5;
		outline: none;
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
</style>
</head>
<body>
	<form action="addSchedule.do" method="post">
		<ul>
			<li>
				<b>구분</b><br>
				<label><input type="radio" name="type" value="assignment" checked >과제</label>
			</li>
			<li>
				<b>과목명</b><br> <input type="text" name="name" autofocus required>
			</li>
			<li>
				<b>내용</b><br> <input type="text" name="content">
			</li>
			<li>
				<b>기한</b><br> <input type="datetime-local" name="date" required>
			</li>
		</ul>
		<input type="submit" value="추가" onclick="opener.location.reload();">
		<input type="button"  value="닫기" onClick="window.close();">
	</form>
</body>
</html>