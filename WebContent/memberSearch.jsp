<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.urecord.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학기록 | 정보</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
	* {
		margin: 0;
		padding: 0;
		font-family: 'Noto Sans KR', sans-serif;
	}
	h3 {
		text-align: center;
		font-size: 30px;
	}
	form {
		width: 330px;
		margin: auto;
	}
	li {
		padding-top: 10px;
		font-size: 15px;
		line-height: 30px;
		list-style: none;
		text-align: center;
	}
	input {
		width: 330px;
		height: 40px;
		font-size: 20px;
		border-left: none;
		border-right: none;
		border-top: none;
		border-bottom: 3px solid #D5D5D5;
		outline: none;
	}
	input[type="submit"] {    
  		height: 50px;
  		margin-top: 30px;
  		font-weight: bold;
  		border:1px solid #D5D5D5; 
	}
	input[type="submit"]:hover {
		background-color: #B2FA5C;
		color: #ffffff;
	}

</style>
</head>
<body>
<%@ include file="/result/nav.jsp" %>
<%
	MemberVO member = (MemberVO)request.getAttribute("member");
%>
<h3>개인 정보 수정</h3>
	<div id="main">
		<form action="memberUpdate.do" method="post">
			<ul>
				<li>
					<label for="id">아이디 *</label>
					<input type="text" name="id" readonly value="${member.id }">
				</li>
				<li>
					<label for="pwd">비밀번호 *</label>
					<input type="password" name="pwd" required autofocus>
				</li>
				<li>
					<label for="name">이름 *</label>
					<input type="text" name="name" value="${member.name }" required >
				</li>
			</ul>		
			<input type="submit" value="수정하기">
		</form>
	</div>
</body>
</html>