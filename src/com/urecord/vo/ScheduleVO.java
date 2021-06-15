package com.urecord.vo;

public class ScheduleVO {
	private String num; //등록한 일정 번호 
	private String type; //시험인지 과제인지 구분. exam assignment 
	private String name; //과목 이름 
	private String content; //범위나 시험방식 같은 정보 
	private String date; //과제 시험 날짜
	private String mId; //쓴 멤버 아이디 - 멤버아이디로 select * from schedule where mem_id=? 목록조회
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
}
