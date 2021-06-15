package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.ContentService;
import com.urecord.vo.ContentVO;

public class GroupContentController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		String gid = request.getParameter("gid");
		String text = request.getParameter("text");
		
		ContentVO content = new ContentVO();
		content.setWriter(id);
		content.setgId(gid);
		content.setText(text);
		
		ContentService service = ContentService.getInstance();
		service.addContent(content);
		HttpUtil.forward(request, response, "/group.do");
	}

}
