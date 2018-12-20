package com.zzu.StuManage.entity;

public class Course {

	private String cno;
	
	private String cname;
	
	private String tname;
	
	private int preiod;
	
	private int ctype;
	
	private int credit;

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getPreiod() {
		return preiod;
	}

	public void setPreiod(int preiod) {
		this.preiod = preiod;
	}

	public int getCtype() {
		return ctype;
	}

	public void setCtype(int ctype) {
		this.ctype = ctype;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Course [cno=" + cno + ", cname=" + cname + ", tname=" + tname + ", preiod=" + preiod + ", ctype="
				+ ctype + ", credit=" + credit + "]";
	}
	
}
