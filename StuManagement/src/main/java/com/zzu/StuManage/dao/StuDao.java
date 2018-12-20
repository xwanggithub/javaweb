package com.zzu.StuManage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.zzu.StuManage.entity.Course;
import com.zzu.StuManage.entity.Student;
import com.zzu.StuManage.entity.Stugrade;
import com.zzu.StuManage.util.DBUtil;

public class StuDao {
	
	/**
	 * 返回单个学生信息
	 */
	public static Student StudentInfoUtil(String sql){				
		Student Student = new Student();
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		try {
			Student = qr.query(sql,new ResultSetHandler<Student>(){
				public Student handle(ResultSet rs) throws SQLException{
					Student Student = null;
					if(rs.next()){
						Student = new Student();
						Student.setSno(rs.getString("Sno"));
						Student.setName(rs.getString("sname"));
						Student.setGender(rs.getString("gender"));
						Student.setBirthday(rs.getDate("birthday"));
						Student.setEnrollyear(rs.getString("enrollyear"));
						Student.setSpecially(rs.getString("specially"));
						Student.setDno(rs.getString("dno"));
						Student.setPicture(rs.getString("picture"));
					}
					return Student;
				}
			});	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Student;
	}
	
	/**		
	 * 返回学生信息列表 
	 */
	public static List<Student> StudentsInfoUtil(String sql){				
		List<Student> StudentList = new ArrayList<Student>();
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		try {
			StudentList = qr.query(sql,new ResultSetHandler<List<Student>>(){
				public List<Student> handle(ResultSet rs) throws SQLException{
					List<Student> StudentList = new ArrayList<Student>();
					Student Student = null;
					while(rs.next()){
						Student = new Student();
						Student.setSno(rs.getString("Sno"));
						Student.setName(rs.getString("sname"));
						Student.setGender(rs.getString("gender"));
						Student.setBirthday(rs.getDate("birthday"));
						Student.setEnrollyear(rs.getString("enrollyear"));
						Student.setSpecially(rs.getString("specially"));
						Student.setDno(rs.getString("dno"));
						Student.setPicture(rs.getString("picture"));
						StudentList.add(Student);
					}
					return StudentList;
				}
			});		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return StudentList;
	}	
	
	/**
	 *学生选课列表
	 */
	public List<Course> CoursesInfoUtil(String sql){				
		List<Course> courseList = new ArrayList<Course>();
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		try {
			courseList = qr.query(sql,new ResultSetHandler<List<Course>>(){
				public List<Course> handle(ResultSet rs) throws SQLException{
					List<Course> courseList = new ArrayList<Course>();
					Course course = null;
					while(rs.next()){
						course = new Course();
						course.setCno(rs.getString("cno"));
						course.setCname(rs.getString("cname"));
						course.setTname(rs.getString("tname"));
						course.setPreiod(rs.getInt("preiod"));
						course.setCtype(rs.getInt("ctype"));
						course.setCredit(rs.getInt("credit"));
						courseList.add(course);
						
					}
					return courseList;
				}
			});		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return courseList;
	}	
		
	/**
	 * 学生成绩信息
	 * @param sql
	 * @return
	 */
	public List<Stugrade> StugradesInfoUtil(String sql){				
		List<Stugrade> StugradeList = new ArrayList<Stugrade>();
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		try {
			StugradeList = qr.query(sql,new ResultSetHandler<List<Stugrade>>(){
				public List<Stugrade> handle(ResultSet rs) throws SQLException{
					List<Stugrade> StugradeList = new ArrayList<Stugrade>();
					Stugrade Stugrade = null;
					if(rs.next()){
						Stugrade = new Stugrade();
//						Stugrade.setSsemester(rs.getString("ssemester"));
						Stugrade.setCourseNo(rs.getString("cno"));
//						Stugrade.setCourseNum(rs.getString("courseNum"));
						Stugrade.setCname(rs.getString("cname"));
						Stugrade.setCtype(rs.getInt("ctype"));
						Stugrade.setCredit(rs.getInt("credit"));
						Stugrade.setScore(rs.getInt("grade"));
						if(Stugrade.getCtype()==1) {
							Stugrade.setGpa(getGpa(Stugrade.getScore()));							
						}
						StugradeList.add(Stugrade);
					}
					return StugradeList;
				}
			});		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return StugradeList;
	}
	//绩点计算
	public double getGpa(int a) {
		 double gpa=0.0;
		 if(a>=60&&a<65) 
			 gpa=1.2;	 
		 if(a>=65&&a<70)
			 gpa=1.7;
		 if(a>=70&&a<75)
			 gpa=2.2;
		 if(a>=75&&a<80)
			 gpa=2.7;
		 if(a>=80&&a<85)
			 gpa=3.2;
		 if(a>=85&&a<90)
			 gpa=3.7;
		 if(a>=90)
			 gpa=4.0;
			return gpa;
		}
	
	/**
	  * 更新数据
	 */	
	public static int updateStu (String sql,Object[] params) {
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		int rows=0;
		try {
			 rows = qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	//更新信息
	public static int update(String sql , Object param) {
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		int rows=0;
		try {
			 rows = qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}	
			
	//学生信息详情
	public Student StudentInfo(String sno){
		String sql = "select * from students where sno="+sno+""; 
		return StuDao.StudentInfoUtil(sql);
	}
	//学生成绩信息
	public List<Stugrade> scoreStudent(String sno){
		String sql = "select * from stu_grades where sno="+sno+""; 
		return this.StugradesInfoUtil(sql);
	}
	
	//学生选课数据
	public List<Course> myCourse(String sno){
		String sql = "select * from mycourse where sno="+sno+"";
		return this.CoursesInfoUtil(sql);
	}
	//删除选课
	public int delCourse(String sno,String cno) {
		int rows = 0;
		QueryRunner qr = new QueryRunner(DBUtil.getDS());
		String sql = "delete from sc where sno="+sno+"and cno="+cno+"";
		try {
			rows = qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	//课程评价
	public int courseComment(String sno,String cno,Object comment) {
		String  sql = "update sc set evaluate=? where sno="+sno+" and cno="+cno+"";
		return StuDao.update(sql,comment);
	}
	
	
	
	
}
