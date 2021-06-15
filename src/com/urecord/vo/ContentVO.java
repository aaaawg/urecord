package com.urecord.vo;

public class ContentVO {
	private String gId; //그룹 아이디. 외부 노출용 아님
	private String num; //글 번호 
	private String text; //올릴 내용 
	private String date; //올린 날짜
	private String writer; //쓴 사람. member아이디나 이름.
	
	public String getgId() {
		return gId;
	}
	public void setgId(String gId) {
		this.gId = gId;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
}
