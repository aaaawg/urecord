package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.GroupService;

public class GroupDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String gid = request.getParameter("gid");
		String mid = request.getParameter("mid");
		String type = request.getParameter("type");
		
		if(type.equals("manager")) {
			GroupService service = GroupService.getInstance();
			service.deleteGroup(mid, gid);
			HttpUtil.forward(request, response, "/group.do");
		}
		else {
			GroupService service = GroupService.getInstance();
			service.deleteGroup(id, gid);
			HttpUtil.forward(request, response, "/memberGroup.do");
		}
			
	}

}
