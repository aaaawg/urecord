<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.urecord.vo.ScheduleVO" %>
<%@ page import="com.urecord.vo.SubjectVO" %>
<%@ page import="java.util.ArrayList" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학기록 | 일정</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
	h3 {
		font-size: 30px;
	}
	section {
		width: 330px;
		float: left;
	}
	input[type="button"] {
		padding: 5px;
		border: 1px solid #F08A8A;
		color: #ffffff;
		font-size: 15px;
		background-color: #F08A8A;
		border-radius: 5px;
		margin-left: 15px;
	}
	#subject {
		width: 290px;
		padding-top: 10px;
	}
	#contents {
		width: 290px;
		padding-top: 10px;
	}
	#n a {
		float: right;
	}
	#b {
		letter-spacing: 15px;
	}
	#t {
		padding-bottom: 10px;
	}
	#mon:hover {
		background-color: #8785a2;
		color: #ffffff;
	}
	#mon a:hover {
		color: #ffffff;
	}
	#tue:hover {
		background-color: #ffe2e2;
	}
	#wed:hover {
		background-color:  #aaaaaa;
	}
	#thu:hover {
		background-color: #ffc7c7;
	}
	#fri:hover {
		background-color:  #505050;
		color: #ffffff;
	}
	#fri a:hover {
		color: #ffffff;
	}
	#sub div{
		width: 290px;
		font-size: 17px;
		padding: 8px;
	}
	#sub a {
		float: right;
	}
	#s {
		padding-bottom: 10px;
	}
}
</style>
<script>
	function assignmentPopup() {
		var popup = window.open("addSchedule.jsp", "apop", "width=350, height=360, left=300, top=200");
		if(popup == null) {
			alert("팝업 차단을 해제해 주세요.")
		}
	}
	function examPopup() {
		var popup = window.open("addExam.jsp", "epop", "width=350, height=360, left=300, top=200");
		if(popup == null) {
			alert("팝업 차단을 해제해 주세요.")
		}
	}
	function subjectPopup() {
		var popup = window.open("addSubject.jsp", "spop", "width=360, height=200, left=100, top=100");
		if(popup == null) {
			alert("팝업 차단을 해제해 주세요.")
		}
	}
</script>
</head>
<%
	ArrayList<ScheduleVO> exam = (ArrayList<ScheduleVO>)request.getAttribute("exam");
	ArrayList<ScheduleVO> assignment = (ArrayList<ScheduleVO>)request.getAttribute("assignment");
	ArrayList<SubjectVO> subject = (ArrayList<SubjectVO>)request.getAttribute("subject");
	String id = (String)session.getAttribute("id");
%>
<body>
<%@ include file="/result/nav.jsp" %>
<section id="sub">
<h3 id="s">강의<input type="button" value="추가하기" onClick="subjectPopup()"></h3>
<%	
	for(int i = 0; i < subject.size(); i++) {
		SubjectVO su = subject.get(i); 
		if(su.getWeek()==1) { %>
		<div id="mon">
			<%= su.getName() %><a href="deleteSubject.do?num=<%=su.getNum()%>">삭제</a><br>
			월 <%= su.getStime() %>-<%= su.getEtime() %><br>
		</div>
	<%} else if(su.getWeek()==2) {%>
		<div id="tue">
			<%= su.getName() %><a href="deleteSubject.do?num=<%=su.getNum()%>">삭제</a><br>
			화 <%= su.getStime() %>-<%= su.getEtime() %><br>
		</div>
	<%} else if(su.getWeek()==3) {%>
		<div id="wed">
			<%= su.getName() %><a href="deleteSubject.do?num=<%=su.getNum()%>">삭제</a><br>
			수 <%= su.getStime() %>-<%= su.getEtime() %>
		</div>
	<%} else if(su.getWeek()==4) {%>
		<div id="thu">
			<%= su.getName() %><a href="deleteSubject.do?num=<%=su.getNum()%>">삭제</a><br>
			목 <%= su.getStime() %>-<%= su.getEtime() %><br>
		</div>
	<%} else if(su.getWeek()==5) {%>
		<div id="fri">
			<%= su.getName() %><a href="deleteSubject.do?num=<%=su.getNum()%>">삭제</a><br>
			금 <%= su.getStime() %>-<%= su.getEtime() %><br>
		</div>
		<%} %>
	<%} %>	
</section> 

<section>
	<h3>과제<input type="button" value="추가하기" onClick="assignmentPopup()"></h3>
<%
	for(int i = 0; i < assignment.size(); i++) {
		ScheduleVO as = assignment.get(i); %>
		<div id="contents">
			<p id="n"><b>과목명</b> | <%= as.getName() %><a href="deleteSchedule.do?num=<%=as.getNum()%>">삭제</a></p>
			<b id="b">내</b><b>용</b> | <%= as.getContent() %> <br>
			<p id="t"><b id="b">기</b><b>한</b> | <%= as.getDate() %> 까지</p><hr>
		</div>
<%} %>	
</section>  

<section>
	<h3>시험 <input type="button" value="추가하기" onClick="examPopup()"></h3>
	
<%
	for(int i = 0; i < exam.size(); i++) {
		ScheduleVO ex = exam.get(i); %>
		<div id="contents">
			<p id="n"><b>과목명</b> | <%= ex.getName() %> <a href="deleteSchedule.do?num=<%=ex.getNum()%>">삭제</a></p>
			<b id="b">범</b><b>위</b> | <%= ex.getContent() %><br>
			<p id="t"><b id="b">일</b><b>시</b> | <%= ex.getDate() %> </p><hr>
		</div>
<%} %>
</section>
</body>
</html>