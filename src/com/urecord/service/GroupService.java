package com.urecord.service;

import java.util.ArrayList;

import com.urecord.dao.GroupDAO;
import com.urecord.vo.GroupVO;

public class GroupService {
	private static GroupService service = new GroupService();
	private GroupService() {}
	private GroupDAO dao = GroupDAO.getInstance();
	public static GroupService getInstance() { 
		return service;
	}
	public void addGroup(GroupVO group) {
		// TODO Auto-generated method stub
		dao.addGroup(group);
	}
	public GroupVO groupSearch(String gid) {
		// TODO Auto-generated method stub
		return dao.groupSearch(gid);
	}
	public ArrayList<GroupVO> groupList() {
		// TODO Auto-generated method stub
		return dao.groupList();
	}
	public void enterGroup(String id, String gid) {
		// TODO Auto-generated method stub
		dao.enterGroup(id, gid);
	}
	public void deleteGroup(String id, String gid) {
		// TODO Auto-generated method stub
		dao.deleteGroup(id, gid);
	}
	public ArrayList<GroupVO> groupMemberList(String gid) {
		// TODO Auto-generated method stub
		return dao.groupMemberList(gid);
	}
	public ArrayList<GroupVO> groupNameList(String id) {
		// TODO Auto-generated method stub
		return dao.groupNameList(id);
	}
	public GroupVO groupInfo(String gid) {
		// TODO Auto-generated method stub
		return dao.groupInfo(gid);
	}
	public void adminDeleteGroup(String gid) {
		// TODO Auto-generated method stub
		dao.adminDeleteGroup(gid);
	}
	public ArrayList<GroupVO> adminGroupList() {
		// TODO Auto-generated method stub
		return dao.adminGroupList();
	}
}
