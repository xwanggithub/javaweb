package com.zzu.StuManage.entity;

import java.util.Date;

public class Student {
	
	@Override
	public String toString() {
		return "Student [Sno=" + Sno + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday
				+ ", enrollyear=" + enrollyear + ", specially=" + specially + ", dno=" + dno + ", picture=" + picture
				+ "]";
	}

	private String Sno;				//学号
	
	private String sname;			//姓名
	
	private String gender;			//性别
	
	private Date birthday;			//生日
	
	private String enrollyear;		//入学年份
	
	private String specially ;		//专业
	
	private String dno;				//学院
	
	private String picture;			//照片位置
	
	public Student(){
		
	}
	
	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
	}

	public String getName() {
		return sname;
	}

	public void setName(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEnrollyear() {
		return enrollyear;
	}

	public void setEnrollyear(String enrollyear) {
		this.enrollyear = enrollyear;
	}

	public String getSpecially() {
		return specially;
	}

	public void setSpecially(String specially) {
		this.specially = specially;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


}
