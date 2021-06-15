package com.urecord.service;

import java.util.ArrayList;

import com.urecord.dao.MemberDAO;
import com.urecord.vo.MemberVO;

public class MemberService {
	private static MemberService service = new MemberService();
	private MemberService() {}
	private MemberDAO dao = MemberDAO.getInstance();
	public static MemberService getInstance() { 
		return service;
	}
	public boolean memberLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.memberLogin(id, pwd);
	}
	public void memberInsert(MemberVO member) {
		// TODO Auto-generated method stub
		dao.memberInsert(member);
	}
	public void memberUpdate(MemberVO member) {
		// TODO Auto-generated method stub
		dao.memberUpdate(member);
	}
	public MemberVO memberSearch(String id) {
		// TODO Auto-generated method stub
		MemberVO member = dao.memberSearch(id);
		return member;
	}
	public ArrayList<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return dao.memberList();
	}
	public boolean adminLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.AdminLogin(id, pwd);
	}
	public void memberDelete(String id) {
		// TODO Auto-generated method stub
		dao.memberDelete(id);
	}
}
