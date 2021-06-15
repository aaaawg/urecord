package com.urecord.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.urecord.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
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
	public boolean memberLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=? and pwd=?;");
			pstmt.setString(1, id); 
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); 
			if(rs.next()) { 
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			System.out.println("memberLogin error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	public void memberInsert(MemberVO member) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into member values(?,?,?);");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("memberInsert error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public void memberUpdate(MemberVO member) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set pwd=?,name=? where id=?;");
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("memberUpdate error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public MemberVO memberSearch(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPwd(rs.getString(2));
				member.setName(rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println("오류발생: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return member;
	}
	public ArrayList<MemberVO> memberList() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member;");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString(1));
				member.setPwd(rs.getString(2));
				member.setName(rs.getString(3));
				list.add(member); 
			}
		} catch (Exception e) {
			System.out.println("memberList error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public boolean AdminLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from admin where id=? and pwd=?;");
			pstmt.setString(1, id); 
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); 
			if(rs.next()) { 
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			System.out.println("adminLogin error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	public void memberDelete(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from member where id=?;");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			close(conn, pstmt);
			
			conn = connect();
			pstmt = conn.prepareStatement("delete from contents where writer=?;");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			close(conn, pstmt);
			
			conn = connect();
			pstmt = conn.prepareStatement("delete from grop where mem_id=?;");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			close(conn, pstmt);
			
			conn = connect();
			pstmt = conn.prepareStatement("delete from schedule where mem_id=?;");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			close(conn, pstmt);
			
			conn = connect();
			pstmt = conn.prepareStatement("delete from grop_list where mem_id=?;");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			close(conn, pstmt);
			
			conn = connect();
			pstmt = conn.prepareStatement("delete from subject where mem_id=?;");
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("memberDelete error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
}
