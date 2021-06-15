package com.urecord.vo;

public class GroupVO {
	private String id; //그룹 아이디. 외부 노출용 아님
	private String name; //그룹 이름
	private String type; //그룹 공개인지 비공개인지
	private String pwd; //그룹 비공개 시 사용하는 비밀번호
	private String content; //그룹 소개. 무슨 활동을 하는 그룹인지
	private String mId; //그룹을 최초로 생성한 멤버아이디 -> 이사람한테만 멤버 삭제 권한
	private String mType;
	
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
}
