package com.youzi.yuchou.admin.common.login.domain;

//系统token数据
public class TokenInfo {

	private String sid;		//sessionID
	private Long uid;		//用户id
	private long firstVisitTime;	//首次访问时间
	private long lastVisitTime;		//上次访问时间


	public long getFirstVisitTime() {
		return firstVisitTime;
	}

	public void setFirstVisitTime(long firstVisitTime) {
		this.firstVisitTime = firstVisitTime;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}


	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public long getLastVisitTime() {

		return lastVisitTime;
	}

	public void setLastVisitTime(long lastVisitTime) {

		this.lastVisitTime = lastVisitTime;
	}


}
