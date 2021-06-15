package com.urecord.service;

import java.util.ArrayList;

import com.urecord.dao.ScheduleDAO;
import com.urecord.vo.ScheduleVO;

public class ScheduleService {
	private static ScheduleService service = new ScheduleService();
	private ScheduleService() {}
	private ScheduleDAO dao = ScheduleDAO.getInstance();
	public static ScheduleService getInstance() { 
		return service;
	}
	public void scheduleAdd(ScheduleVO schedule) {
		// TODO Auto-generated method stub
		dao.scheduleAdd(schedule);
	}
	public ArrayList<ScheduleVO> examList(String id) {
		// TODO Auto-generated method stub
		return dao.examList(id);
	}
	public ArrayList<ScheduleVO> assignmentList(String id) {
		// TODO Auto-generated method stub
		return dao.assignmentList(id);
	}
	public void scheduleDelete(String num) {
		// TODO Auto-generated method stub
		dao.scheduleDelete(num);
	}
}
