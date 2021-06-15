package com.urecord.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.urecord.service.ScheduleService;
import com.urecord.vo.ScheduleVO;

public class MemberAddScheduleController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String date = request.getParameter("date");
		
		ScheduleVO schedule = new ScheduleVO();
		schedule.setmId(id);
		schedule.setType(type);
		schedule.setName(name);
		schedule.setContent(content);
		schedule.setDate(date);
		
		ScheduleService service = ScheduleService.getInstance();
		service.scheduleAdd(schedule);
		
		if(type.equals("assignment")) {
			HttpUtil.forward(request, response, "/addSchedule.jsp");
		} else {
			HttpUtil.forward(request, response, "/addExam.jsp");
		}
	}

}
