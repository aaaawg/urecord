package com.urecord.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.urecord.vo.GroupVO;

public class GroupDAO {
	private static GroupDAO dao = new GroupDAO();
	private GroupDAO() {}
	public static GroupDAO getInstance() {
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
	public void addGroup(GroupVO group) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into grop values(?,?,?,?,?,?);");
			pstmt.setString(1, group.getId());
			pstmt.setString(2, group.getName());
			pstmt.setString(3, group.getType());
			pstmt.setString(4, group.getPwd());
			pstmt.setString(5, group.getContent());
			pstmt.setString(6, group.getmId());
			pstmt.executeUpdate();
			close(conn, pstmt);
			
			conn = connect();
			pstmt = conn.prepareStatement("insert into grop_list values(?,?,?);");
			pstmt.setString(1, group.getmId());
			pstmt.setString(2, group.getId());
			pstmt.setString(3, group.getmType());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("addGroup error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<GroupVO> groupList() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupVO group = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select id, name, type, content from grop where type='공개';");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				group = new GroupVO();
				group.setId(rs.getString(1));
				group.setName(rs.getString(2));
				group.setType(rs.getString(3));
				group.setContent(rs.getString(4));
				list.add(group); 
			}
		} catch (Exception e) {
			System.out.println("groupList error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public GroupVO groupSearch(String gid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupVO group = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select id, name, type, pwd, content from grop where id=?;");
			pstmt.setString(1, gid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				group = new GroupVO();
				group.setId(rs.getString(1));
				group.setName(rs.getString(2));
				group.setType(rs.getString(3));
				group.setPwd(rs.getString(4));
				group.setContent(rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println("groupSearch error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return group;
	}
	public void enterGroup(String id, String gid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into grop_list values(?,?,?);");
			pstmt.setString(1, id);
			pstmt.setString(2, gid);
			pstmt.setString(3, "member");
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("enterGroup error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public void deleteGroup(String id, String gid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from grop_list where mem_id=? and grop_id=?;");
			pstmt.setString(1, id);
			pstmt.setString(2, gid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteGroup error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<GroupVO> groupMemberList(String gid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupVO member = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select mem_id, mem_type from grop_list where grop_id=?;");
			pstmt.setString(1, gid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new GroupVO();
				member.setmId(rs.getString(1));
				member.setmType(rs.getString(2));
				list.add(member); 
			}
		} catch (Exception e) {
			System.out.println("groupMemberList error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public ArrayList<GroupVO> groupNameList(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupVO group = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select grop.id, grop.name from grop, grop_list "
					+ "where grop_list.mem_id=? and grop.id=grop_list.grop_id;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				group = new GroupVO();
				group.setId(rs.getString(1));
				group.setName(rs.getString(2));
				list.add(group); 
			}
		} catch (Exception e) {
			System.out.println("groupNameList error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public GroupVO groupInfo(String gid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupVO group = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select id, name, content, mem_id from grop where id=?;");
			pstmt.setString(1, gid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				group = new GroupVO();
				group.setId(rs.getString(1));
				group.setName(rs.getString(2));
				group.setContent(rs.getString(3));
				group.setmId(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println("groupInfo error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return group;
	}
	public void adminDeleteGroup(String gid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from grop_list where grop_id=?;");
			pstmt.setString(1, gid);
			pstmt.executeUpdate();
			close(conn, pstmt);
			
			conn = connect();
			pstmt = conn.prepareStatement("delete from contents where grop_id=?;");
			pstmt.setString(1, gid);
			pstmt.executeUpdate();
			close(conn, pstmt);
			
			conn = connect();
			pstmt = conn.prepareStatement("delete from grop where id=?;");
			pstmt.setString(1, gid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("adminDeleteGroup error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<GroupVO> adminGroupList() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupVO group = null;
		ArrayList<GroupVO> list = new ArrayList<GroupVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select id, name, type, mem_id from grop;");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				group = new GroupVO();
				group.setId(rs.getString(1));
				group.setName(rs.getString(2));
				group.setType(rs.getString(3));
				group.setmId(rs.getString(4));
				list.add(group); 
			}
		} catch (Exception e) {
			System.out.println("groupList error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
}
