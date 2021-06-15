package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.urecord.service.ScheduleService;

public class MemberDeleteScheduleController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		
		ScheduleService service = ScheduleService.getInstance();
		service.scheduleDelete(num);
		
		HttpUtil.forward(request, response, "/memberSchedule.do");
	}

}
