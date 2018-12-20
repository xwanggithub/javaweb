package com.zzu.StuManage.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.zzu.StuManage.entity.Student;
import com.zzu.StuManage.util.DBUtil;

public class  AdminDao {
	
	//按学号查询学生信息
	public Student StuInfo(String sno){
		String sql = "select * from students where sno="+sno+""; 
		return StuDao.StudentInfoUtil(sql);
	}	
	//按姓名查询学生信息
	public List<Student> querryStuBySname(String sname){
		String sql = "select * from students where sname='"+sname+"'"; 
		return StuDao.StudentsInfoUtil(sql);
	}
	//查询专业的学生信息
	public List<Student> querryStu(String specially){
		String sql = "select * from students where specially='"+specially+"'"; 
		return StuDao.StudentsInfoUtil(sql);
	}	
	//按学号更新学生信息
	public int updateStuById(String sno,Object[] params) {
		String sql="update students set sname=?,gender=?,birthday=?,enrollyear=?,specially=?,dno=? where sno="+sno+"";		
		return StuDao.updateStu(sql,params);
	}
	//按专业和姓名查询学生信息
	public List<Student> querryStuBySnameAndSpe(String specially,String sname){
			String sql = "select * from students where sname='"+sname+"' and specially='"+specially+"'"; 
			return StuDao.StudentsInfoUtil(sql);
		}	
	//添加学生数据
	public int insertStuInfo(Object[] params) {
		String sql = "insert into students(sno,sname,gender,birthday,enrollyear,specially,dno)values(?,?,?,?,?,?,?)";
		return StuDao.updateStu(sql,params);
	}	
	//按学号删除学生
	public int deleteStu(String sno) {
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		int rows = 0;
		String sql ="delete from students where sno="+sno+"";
		try {
			rows = qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	//录入学生成绩信息和修改
	public int addGrade(Object[] params) {
		String sql = "update sc set grade=? where sno=? and cno=?";
		return StuDao.updateStu(sql, params);
	}	
	
	//重置学生账号密码
	public int resetPsd(String sno) {
		String sql = "update users set password=123456 where userid=?";
		return StuDao.update(sql, sno);
	}
		
	//录入课程信息
	//删除课程信息
	//修改课程信息
	//给专业分配课程
	
}
