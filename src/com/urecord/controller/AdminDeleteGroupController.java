package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urecord.service.GroupService;

public class AdminDeleteGroupController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gid = request.getParameter("gid");
		String type = request.getParameter("type");
		
		GroupService service = GroupService.getInstance();
		service.adminDeleteGroup(gid);
		
		if(type.equals("manager")) {
			HttpUtil.forward(request, response, "/memberGroup.do");
		} else
			HttpUtil.forward(request, response, "/adminGroup.do");
	}

}
