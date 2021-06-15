package com.urecord.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> map = null;
	String charset = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		charset = config.getInitParameter("charset");
		map = new HashMap<String, Controller>();
		map.put("/memberLogin.do", new MemberLoginController());
		map.put("/memberInsert.do", new MemberInsertController());
		map.put("/addSchedule.do", new MemberAddScheduleController());
		map.put("/memberUpdate.do", new MemberUpdateController());
		map.put("/memberSchedule.do", new MemberScheduleController());
		map.put("/memberSearch.do", new MemberSearchController());
		map.put("/deleteSchedule.do", new MemberDeleteScheduleController());
		map.put("/addGroup.do", new MemberAddGroupController());
		map.put("/groupSearch.do", new GroupSearchController());
		map.put("/memberGroup.do", new GroupListController());
		map.put("/addContent.do", new GroupContentController());
		map.put("/group.do", new GroupContentListController());
		map.put("/enterGroup.do", new GroupEnterController());
		map.put("/deleteGroup.do", new GroupDeleteController());
		map.put("/deleteContent.do", new GroupContentDeleteController());
		map.put("/adminMember.do", new AdminMemberListController());
		map.put("/adminLogin.do", new AdminLoginController());
		map.put("/adminDeleteMember.do", new AdminDeleteController());
		map.put("/adminGroup.do", new AdminGroupController());
		map.put("/adminDeleteGroup.do", new AdminDeleteGroupController());
		map.put("/logout.do", new LogoutController());
		map.put("/addSubject.do", new MemberAddSubjectController());
		map.put("/deleteSubject.do", new MemberDeleteSubjectController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding(charset);
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath(); 
		String path = uri.substring(contextPath.length()); 
		Controller subController = map.get(path); 
		subController.execute(req, resp); 
	}
}
