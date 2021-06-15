package com.urecord.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.urecord.vo.ScheduleVO;

public class ScheduleDAO {
	private static ScheduleDAO dao = new ScheduleDAO();
	private ScheduleDAO() {}
	public static ScheduleDAO getInstance() {
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
	public void scheduleAdd(ScheduleVO schedule) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into schedule(type,name,content,date,mem_id) values(?,?,?,?,?);");
			pstmt.setString(1, schedule.getType());
			pstmt.setString(2, schedule.getName());
			pstmt.setString(3, schedule.getContent());
			pstmt.setString(4, schedule.getDate());
			pstmt.setString(5, schedule.getmId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("scheduleAdd error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<ScheduleVO> examList(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ScheduleVO schedule = null;
		ArrayList<ScheduleVO> exam = new ArrayList<ScheduleVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select num, name, content, date_format(date, '%Y-%m-%d %H:%i') as date "
					+ "from schedule where mem_id=? and type='exam' order by date asc;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				schedule = new ScheduleVO();
				schedule.setNum(rs.getString(1));
				schedule.setName(rs.getString(2));
				schedule.setContent(rs.getString(3));
				schedule.setDate(rs.getString(4));
				exam.add(schedule); 
			}
		} catch (Exception e) {
			System.out.println("examList error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return exam;
	}
	public ArrayList<ScheduleVO> assignmentList(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ScheduleVO schedule = null;
		ArrayList<ScheduleVO> assignment = new ArrayList<ScheduleVO>();
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select num, name, content, date_format(date, '%Y-%m-%d %H:%i') as date "
					+ "from schedule where mem_id=? and type='assignment' order by date asc;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				schedule = new ScheduleVO();
				schedule.setNum(rs.getString(1));
				schedule.setName(rs.getString(2));
				schedule.setContent(rs.getString(3));
				schedule.setDate(rs.getString(4));
				assignment.add(schedule); 
			}
		} catch (Exception e) {
			System.out.println("assignmentList error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return assignment;
	}
	public void scheduleDelete(String num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from schedule where num=?;");
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("scheduleDelete error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	
}
