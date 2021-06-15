package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urecord.service.MemberService;
import com.urecord.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		if(id.isEmpty() || pwd.isEmpty() || name.isEmpty()) {
			request.setAttribute("error", "필수 항목을 입력해주세요.");
			HttpUtil.forward(request, response, "/memberInsert.jsp");
			return;
		}
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);
		
		HttpUtil.forward(request, response, "login.jsp");
	}

}
