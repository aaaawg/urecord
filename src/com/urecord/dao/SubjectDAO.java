package com.urecord.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.urecord.vo.SubjectVO;

public class SubjectDAO {
	private static SubjectDAO dao = new SubjectDAO();
	private SubjectDAO() {}
	public static SubjectDAO getInstance() {
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
	public void subjectAdd(SubjectVO subject) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject(week,name,s_time,e_time,mem_id) values(?,?,?,?,?);");
			pstmt.setInt(1, subject.getWeek());
			pstmt.setString(2, subject.getName());
			pstmt.setString(3, subject.getStime());
			pstmt.setString(4, subject.getEtime());
			pstmt.setString(5, subject.getMid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("subjectAdd error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<SubjectVO> subjectList(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO subject = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select num, week, name, time_format(s_time, '%H:%i'), "
					+ "time_format(e_time, '%H:%i') from subject where mem_id=? order by week asc, s_time asc;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				subject = new SubjectVO();
				subject.setNum(rs.getString(1));
				subject.setWeek(rs.getInt(2));
				subject.setName(rs.getString(3));
				subject.setStime(rs.getString(4));
				subject.setEtime(rs.getString(5));
				list.add(subject); 
			}
		} catch (Exception e) {
			System.out.println("subjectList error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public void subjectDelete(String num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from subject where num=?;");
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("subjectDelete error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
}
