<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.urecord.vo.ContentVO" %>
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
	input[type="button"] {
		padding: 5px 10px 5px 10px ;
		margin-left: 3px;
		border:2px solid #D5D5D5; 
		color: #000000;
		font-weight: bold;
		background-color: #ffffff;
		border-radius: 5px;
	}
	input[type="submit"] {
		padding: 5px 10px 5px 10px ;
		border:2px solid #D5D5D5; 
		color: #000000;
		font-weight: bold;
		background-color: #ffffff;
		border-radius: 5px;
	}
	input[type="text"] {
		outline: none;
		border: none;
		width: 150px;
		border-bottom: 2px solid #bbbbbb;
		font-size: 17px;
		margin-top: 5px;
	}
	#info {
		font-size: 25px;
	}
	textarea {
		font-size: 18px;
		outline: none;
		padding: 0px 5px 0px 5px;
		margin-top: 5px;
		border: 2px solid #D5D5D5;
	}
	#s {
		width: 670px;
		height: 40px;
		border: 2px solid #D5D5D5; 
		color: #000000;
		font-weight: bold;
		background-color: #ffffff;
		border-radius: 5px;
	}
	#s:hover {
		color: #ffffff;
		background-color: #FFC81E;
	}
	#grouplist {
		font-size: 20px;
		margin-top: 5px;
	}
	#contentlist {
		width: 670px;
		height: 100px;
		margin-bottom: 10px;
		margin-top: 10px;
	}
	#w {
		font-size: 17px;
	}
	#de {
		float: right;
	}
	#c {
		height: 50px;
	}
	table {
   		width: 90%;
    	border-top: none;
    	border-collapse: collapse;
    	margin-left: 10px;
  	}
 	th, td {
    	border-bottom: 1px solid #a0a0a0;
    	padding: 10px;
    	text-align: left;
 	}
  	#cl {
	  	width: 670px;
	  	border: 1px solid #FFC81E;
  	}
}
</style>
</head>
<body>
<nav>
	<%@ include file="/result/nav.jsp" %>
</nav>
<%
	String gid = request.getParameter("gid");
	ArrayList<ContentVO> contentList = (ArrayList<ContentVO>)request.getAttribute("contentList");
	ArrayList<GroupVO> memberList = (ArrayList<GroupVO>)request.getAttribute("gmlist");
	GroupVO info = (GroupVO)request.getAttribute("gi");
	String id = (String)session.getAttribute("id"); 
%>
<section id="enterGroup">
	<h3>참여자</h3>
	<%	if(info.getmId().equals(id)) {%>
		<form action="deleteGroup.do" method="post" name="manager">
			<input type="text" name="mid" placeholder="아이디" required>
			<input type="hidden" name="gid" value="<%=gid%>">
			<input type="hidden" name="type" value="manager">
			<input type="submit" value="내보내기">
		</form>
	<%} %>
	<%
		for(int i = 0; i < memberList.size(); i++) {
			GroupVO ml = memberList.get(i); %>
			<div id="grouplist">
				<%= ml.getmId() %>
			</div>
	<%} %>
</section>
<section id="group">
	<h3><%= info.getName()%>
	<%	if(info.getmId().equals(id)) { %>
			<input type="button" value="뒤로가기" onClick="location.href='memberGroup.do'">
			<input type="button" value="나가기" onClick="location.href='adminDeleteGroup.do?gid=<%=gid%>&type=manager'">
	<%} else { %>
			<input type="button" value="뒤로가기" onClick="location.href='memberGroup.do'"> 
			<input type="button" value="나가기" onClick="location.href='deleteGroup.do?gid=<%=gid%>&type=member'">
	<%} %>
	</h3>
	<p id="info"><%= info.getContent()%></p>
	<form action="addContent.do" method="post">
		<input type="hidden" name="gid" value="<%= gid %>">
		<textarea rows="3" cols="80" name="text" style="resize:none" required></textarea>
		<input type="submit" value="등록" id="s">
	</form>
	<%
		for(int i = 0; i < contentList.size(); i++) {
			ContentVO cl = contentList.get(i); %>
			<div id="contentlist">
				<p id="w"><b>작성자</b> | <%= cl.getWriter() %><a href="deleteContent.do?gid=<%= gid %>&num=<%=cl.getNum()%>" id="de"><b>삭제</b></a></p>
				<div id="c"><%= cl.getText() %></div>
				<p id="w"><b>작성일</b> | <%= cl.getDate() %></p>
			</div>
			<hr id="cl">
	<%} %>
</section>
</body>
</html>