package com.urecord.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.ScheduleService;
import com.urecord.service.SubjectService;
import com.urecord.vo.ScheduleVO;
import com.urecord.vo.SubjectVO;

public class MemberScheduleController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ScheduleService service = ScheduleService.getInstance();
		ArrayList<ScheduleVO> exam = service.examList(id);
		ArrayList<ScheduleVO> assignment = service.assignmentList(id);
		
		SubjectService sservice = SubjectService.getInstance();
		ArrayList<SubjectVO> subject = sservice.subjectList(id);
		
		request.setAttribute("exam", exam);
		request.setAttribute("assignment", assignment);
		request.setAttribute("subject", subject);
		HttpUtil.forward(request, response, "/memberSchedule.jsp");
	}
}
