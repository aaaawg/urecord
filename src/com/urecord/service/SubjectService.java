package com.urecord.service;

import java.util.ArrayList;

import com.urecord.dao.SubjectDAO;
import com.urecord.vo.SubjectVO;

public class SubjectService {
	private static SubjectService service = new SubjectService();
	private SubjectService() {}
	private SubjectDAO dao = SubjectDAO.getInstance();
	public static SubjectService getInstance() { 
		return service;
	}
	public void subjectAdd(SubjectVO subject) {
		// TODO Auto-generated method stub
		dao.subjectAdd(subject);
	}
	public ArrayList<SubjectVO> subjectList(String id) {
		// TODO Auto-generated method stub
		return dao.subjectList(id);
	}
	public void subjectDelete(String num) {
		// TODO Auto-generated method stub
		dao.subjectDelete(num);
	}
}
