package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.MemberService;

public class MemberLoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberService service = MemberService.getInstance(); 
		boolean result = service.memberLogin(id, pwd);
		
		if(id.isEmpty()) {
			request.setAttribute("error", "아이디를 입력해주세요.");
			HttpUtil.forward(request, response, "/login.jsp");
			return;
		} else if(pwd.isEmpty()){
			request.setAttribute("error", "비밀번호를 입력해주세요.");
			HttpUtil.forward(request, response, "/login.jsp");
			return;
		} else if(result) {
			HttpSession session = request.getSession(); 
			session.setAttribute("id", id); 
			HttpUtil.forward(request, response, "/memberSchedule.do");
		} else {
			request.setAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
			HttpUtil.forward(request, response, "/login.jsp");
			return;
		}

	}
	
}
