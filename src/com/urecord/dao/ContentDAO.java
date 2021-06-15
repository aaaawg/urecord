package com.urecord.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.urecord.vo.ContentVO;
import com.urecord.vo.GroupVO;

public class ContentDAO {
	private static ContentDAO dao = new ContentDAO();
	private ContentDAO() {}
	public static ContentDAO getInstance() {
		return dao;
	}
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/urecord","root","a025763");
		} catch (Exception e) {
			 System.out.println("MDAO:connect" + e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(Exception e) {
				System.out.println("Pstmt close error" + e);
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				System.out.println("Conn close error" + e);
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				System.out.println("rs close error" + e);
			}
		}
		close(conn,pstmt);
	}
	public void addContent(ContentVO content) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into contents(grop_id,text,writer) values(?,?,?);");
			pstmt.setString(1, content.getgId());
			pstmt.setString(2, content.getText());
			pstmt.setString(3, content.getWriter());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("contentAdd error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<ContentVO> contentList(String gid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContentVO content = null;
		ArrayList<ContentVO> list = new ArrayList<ContentVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select writer, text, date, num from contents where grop_id=? order by date desc;");
			pstmt.setString(1, gid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				content = new ContentVO();
				content.setWriter(rs.getString(1));
				content.setText(rs.getString(2));
				content.setDate(rs.getString(3));
				content.setNum(rs.getString(4));
				list.add(content); 
			}
		} catch (Exception e) {
			System.out.println("contentList error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public void contentDelete(String num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from contents where num=?;");
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("contentDelete error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public GroupVO groupInfo(String gid) {
		// TODO Auto-generated method stub
		return null;
	}
}
