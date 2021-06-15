<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.urecord.vo.GroupVO" %>
<%@ page import="java.util.ArrayList" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학기록 | 그룹</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
	h3 {
		font-size: 30px;
	}
	section {
		float: left;
	}
	#enterGroup {
		width: 300px;
	}
	#group {
		width: 700px;
	}
	#grouplist {
		width: 195px;
		height: 200px;
		border: 2px solid #FFC81E;
		float: left;
		margin: 5px 15px 15px 0px;
		background-color: #FFF064;
		padding-left: 5px;
		padding-right: 5px;
	}
	input[type="button"] {
		padding: 5px 10px 5px 10px ;
		margin-left: 10px;
		border:2px solid #D5D5D5; 
		color: #000000;
		font-weight: bold;
		background-color: #ffffff;
		border-radius: 5px;
	}
	input[type="submit"] {
		padding: 5px 15px 5px 15px ;
		margin-left: 10px;
		border:2px solid #D5D5D5; 
		color: #000000;
		font-weight: bold;
		background-color: #ffffff;
		border-radius: 5px;
	}
	#b {
		padding: 7px 15px 7px 15px ;
		border: 2px solid #FFC81E;
		color: #000000;
		font-weight: bold;
		background-color: #ffffff;
		border-radius: 5px;
		margin-bottom: 15px;
		float: right;
	}
	#b:hover {
		color: #FFC81E;
	}
	#name {
		font-size: 25px;
		font-weight: bold;
		letter-spacing: 2px;

	}
	#t{
		font-size: 15px;
	}
	#c{
		width: 195px;
		height: 100px;
		font-size: 17px;
	}
	#enterlist {
		font-size: 20px;
		margin-top: 5px;
	}
	input[type="text"] {
		width: 200px;
		height: 30px;
		font-size: 16px;
		border-left: none;
		border-right: none;
		border-top: none;
		border-bottom: 2px solid #D5D5D5;
		outline: none;
		margin-left: 5px;
	}
	form {
		margin-bottom: 10px;
		margin-top: 5px;
	}
</style>
</head>
	<%@ include file="/result/nav.jsp" %>
<body>
<script>
	function enter() {
		var epw = prompt("비밀번호 입력"); 
		var pwd = document.enterForm.pwd.value;
		var u = document.enterForm.gid.value;
		if(epw == pwd)
			location.href="enterGroup.do?gid="+u;
		else
			alert("비밀번호가 틀렸습니다.");
	}
</script>
<%
	GroupVO sg = (GroupVO)request.getAttribute("sgroup");
	ArrayList<GroupVO> gnlist = (ArrayList<GroupVO>)request.getAttribute("gnlist");
	String result = (String)request.getAttribute("result");
%>
<section id="enterGroup">
	<h3>참여 그룹</h3>
	<%
		for(int i = 0; i < gnlist.size(); i++) {
			GroupVO gn = gnlist.get(i); %>
			<div id="enterlist">
				<a href="group.do?gid=<%= gn.getId() %>"><%= gn.getName() %></a>
			</div>
	<%} %>
</section>

<section id="group">
<h3>검색 결과<input type="button" value="전체보기" onClick="location.href='memberGroup.do'"></h3>
		
		<%if(sg==null) {%>
			${result } 	
		<%} else { %>
			<div id="grouplist">
			<p id="name"><%= sg.getName() %></p>
			<p id="t"><%= sg.getType() %></p>
			<p id="c"><%= sg.getContent() %></p>
			
			<%if(sg.getType().equals("공개")) {%>
				<input type="button" value="들어가기" onClick="location.href='enterGroup.do?gid=<%=sg.getId()%>'" id="b">
			<%} else { %>
				<form name="enterForm">
					<input type="hidden" name="pwd" value="<%=sg.getPwd()%>">
					<input type="hidden" name="gid" value="<%=sg.getId()%>">
					<input type="button" value="들어가기" onClick="enter()" id="b">
				</form>
				</div>
		<%}%>
	<%}%>
	
</section>
</body>
</html>