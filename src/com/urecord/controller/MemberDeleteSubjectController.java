package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urecord.service.SubjectService;

public class MemberDeleteSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		
		SubjectService service = SubjectService.getInstance();
		service.subjectDelete(num);
		
		HttpUtil.forward(request, response, "/memberSchedule.do");
	}

}
