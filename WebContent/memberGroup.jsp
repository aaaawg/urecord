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
		box-shadow: 3px 3px 5px 2px #dcdcdc;
	}
	input[type="button"] {
		padding: 5px 10px 5px 10px ;
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
	#button {
		float: right;
		margin-right: 4px;
		border:2px solid #FFC81E; 
	}
	#button:hover {
		color: #FFC81E
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
		border: none;
		border-bottom: 2px solid #D5D5D5;
		outline: none;
		margin-left: 5px;
	}
	form {
		margin-bottom: 10px;
		margin-top: 5px;
	}
	#enterlist a:hover {
		color: #FFC81E;
		font-weight: bold;
	}
}
</style>
<script>
function groupPopup() {
	var newWin = window.open("addGroup.jsp", "popup", "width=350, height=400");
	if(newWin == null) {
		alert("팝업 차단을 해제해 주세요.")
	}
	newWin.moveBy(100,100);
}
</script>
<%
	ArrayList<GroupVO> openGroup = (ArrayList<GroupVO>)request.getAttribute("openGroup");
	ArrayList<GroupVO> gnlist = (ArrayList<GroupVO>)request.getAttribute("gnlist");
%>
</head>
<body>
<%@ include file="/result/nav.jsp" %>
<section id="enterGroup">
	<h3>참여 그룹</h3>
	<%
		for(int i = 0; i < gnlist.size(); i++) {
			GroupVO gn = gnlist.get(i); %>
			<div id="enterlist">
				<a href="group.do?gid=<%= gn.getId() %>&type=member"><%= gn.getName() %></a>
			</div>
	<%} %>
</section>

<section id="group">
	<h3>전체 그룹 <input type="button" value="만들기" onClick="groupPopup()"></h3>
	<form action="groupSearch.do">
		<input type="text" name="gid" placeholder="그룹아이디 입력" required>
		<input type="submit" value="검색">
	</form>
	<%
		for(int i = 0; i < openGroup.size(); i++) {
			GroupVO og = openGroup.get(i); %>
			<div id="grouplist">
				<p id="name"><%= og.getName() %></p>
				<p id="t"><%= og.getType() %></p>
				<p id="c"><%= og.getContent() %></p>
				<input type="button" value="들어가기" onClick="location.href='enterGroup.do?gid=<%=og.getId()%>'" id="button">
			</div>
	<%} %>
</section>
</body>
</html>