package com.urecord.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urecord.service.GroupService;
import com.urecord.vo.GroupVO;

public class AdminGroupController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GroupService service = GroupService.getInstance();
		ArrayList<GroupVO> list = service.adminGroupList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/adminGroup.jsp");
	}

}
