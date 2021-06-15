package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.GroupService;
import com.urecord.vo.GroupVO;

public class MemberAddGroupController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		String type = request.getParameter("type");
		String gid = request.getParameter("gid");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String content = request.getParameter("content");
		String mtype = request.getParameter("mtype");
		
		GroupVO group = new GroupVO();
		group.setType(type);
		group.setmId(id);
		group.setId(gid);
		group.setName(name);
		group.setPwd(pwd);
		group.setContent(content);
		group.setmType(mtype);
		
		GroupService service = GroupService.getInstance();
		service.addGroup(group);
		
		request.setAttribute("result", "추가 되었습니다.");
		HttpUtil.forward(request, response, "/addGroup.jsp");
	}

}
