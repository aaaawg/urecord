package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.SubjectService;
import com.urecord.vo.SubjectVO;

public class MemberAddSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		String name = request.getParameter("name");
		int week = Integer.parseInt(request.getParameter("week"));
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		
		SubjectVO subject = new SubjectVO();
		subject.setName(name);
		subject.setMid(id);
		subject.setWeek(week);
		subject.setStime(stime);
		subject.setEtime(etime);
		
		SubjectService service = SubjectService.getInstance();
		service.subjectAdd(subject);
		
		HttpUtil.forward(request, response, "/addSubject.jsp");
	}

}
