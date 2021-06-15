package com.urecord.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.GroupService;
import com.urecord.vo.GroupVO;

public class GroupSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String gid = request.getParameter("gid");
		
		GroupService service = GroupService.getInstance();
		GroupVO group = service.groupSearch(gid);
		ArrayList<GroupVO> gnlist = service.groupNameList(id);
		
		if(group == null) {
			request.setAttribute("result", "검색 결과가 없습니다.");
		}
		request.setAttribute("gnlist", gnlist);
		request.setAttribute("sgroup", group);
		HttpUtil.forward(request, response, "/result/groupSearchOutput.jsp");
		
	}

}
