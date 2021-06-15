package com.urecord.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urecord.service.MemberService;
import com.urecord.vo.MemberVO;

public class AdminMemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService service = MemberService.getInstance();
		ArrayList<MemberVO> list = service.memberList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/adminMember.jsp");
	}

}
