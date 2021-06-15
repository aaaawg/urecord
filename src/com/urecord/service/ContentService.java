package com.urecord.service;

import java.util.ArrayList;

import com.urecord.dao.ContentDAO;
import com.urecord.vo.ContentVO;

public class ContentService {
	private static ContentService service = new ContentService();
	private ContentService() {}
	private ContentDAO dao = ContentDAO.getInstance();
	public static ContentService getInstance() { 
		return service;
	}
	public void addContent(ContentVO content) {
		// TODO Auto-generated method stub
		dao.addContent(content);
	}
	public ArrayList<ContentVO> contentList(String gid) {
		// TODO Auto-generated method stub
		return dao.contentList(gid);
	}
	public void ContentDelete(String num) {
		// TODO Auto-generated method stub
		dao.contentDelete(num);
	}
}