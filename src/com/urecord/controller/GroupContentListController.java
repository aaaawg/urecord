package com.urecord.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urecord.service.ContentService;
import com.urecord.service.GroupService;
import com.urecord.vo.ContentVO;
import com.urecord.vo.GroupVO;

public class GroupContentListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gid = request.getParameter("gid");

		ContentService service = ContentService.getInstance();
		ArrayList<ContentVO> list = service.contentList(gid);
		
		GroupService gservice = GroupService.getInstance();
		ArrayList<GroupVO> glist = gservice.groupMemberList(gid);
		GroupVO gi = gservice.groupInfo(gid);
				
		request.setAttribute("contentList", list);
		request.setAttribute("gmlist", glist);
		request.setAttribute("gi", gi);
		HttpUtil.forward(request, response, "/group.jsp");
	}

}
