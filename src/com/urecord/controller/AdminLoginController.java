package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.MemberService;

public class AdminLoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberService service = MemberService.getInstance(); 
		boolean result = service.adminLogin(id, pwd);
		
		if(result) {
			HttpSession session = request.getSession(); 
			session.setAttribute("id", id); 
			HttpUtil.forward(request, response, "/adminMember.do");
		} else {
			request.setAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
			HttpUtil.forward(request, response, "/adminLogin.jsp");
		}
	}

}
