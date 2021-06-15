package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.GroupService;

public class GroupEnterController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String gid = request.getParameter("gid");
		
		GroupService service = GroupService.getInstance();
		service.enterGroup(id, gid);
		
		HttpUtil.forward(request, response, "/group.do");
	}

}
