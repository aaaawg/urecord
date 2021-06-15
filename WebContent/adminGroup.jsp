<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.urecord.vo.GroupVO" %>
<%@ page import="java.util.ArrayList" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학기록 | 관리자</title>
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
	#am:hover {
		background-color: #FFCBCB;
	}
	#ag:hover {
		background-color: #FFFFA1;
	}
	#lo:hover {
		background-color: #A5D8FA;
	}
	#a {
		float: right;
		font-size: 22px;
	}
	table {
   		width: 100%;
    	border-top: none;
    	border-collapse: collapse;
  	}
 	th, td {
    	border-bottom: 1px solid #a0a0a0;
    	padding: 10px;
    	text-align: center;
  }
</style>
</head>
<body>
<div id="logo">
	<h1>대학기록</h1>
</div>
<%String id = (String)session.getAttribute("id");  %>

<nav id="nav">
	<ul>
		<li id="am"><a href="/urecord/adminMember.do">회원관리</a></li>
		<li id="ag"><a href="/urecord/adminGroup.do">그룹관리</a></li>
		<li id="lo"><a href="/urecord/logout.do">로그아웃</a></li>
	</ul>
	<p id="a">관리자(<b><%=id %></b>) 로그인</p>
</nav>
<hr>
<%
		ArrayList<GroupVO> list = (ArrayList<GroupVO>)request.getAttribute("list");
		if(!list.isEmpty()) {
	%>
		<table>
			<tr><th>아이디</th><th>이름</th><th>그룹 관리자</th><th>구분</th><th>이동</th><th>삭제</th></tr>
	<%		for(int i=0; i < list.size(); i++) {
				GroupVO group = list.get(i); %>
				<tr><td><%=group.getId() %></td>
				<td><%=group.getName() %></td>
				<td><%=group.getmId() %></td>
				<td><%=group.getType() %></td>
				<td><a href="/urecord/group.do?gid=<%=group.getId() %>&type=admin">이동</a></td>
				<td><a href="/urecord/adminDeleteGroup.do?gid=<%=group.getId() %>&type=admin">삭제</a></td></tr>
			<%} %>
		</table>
	<%	} else {
			out.print("<h3>등록된 그룹이 없습니다.</h3>");
		}
	%>
</body>
</html>