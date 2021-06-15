package com.urecord.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.GroupService;
import com.urecord.vo.GroupVO;

public class GroupListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		GroupService service = GroupService.getInstance();
		ArrayList<GroupVO> list = service.groupList();
		ArrayList<GroupVO> gnlist = service.groupNameList(id);
		
		request.setAttribute("openGroup", list);
		request.setAttribute("gnlist", gnlist);
		HttpUtil.forward(request, response, "/memberGroup.jsp");
	}

}
