package com.zzu.StuManage.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.StuManage.dao.AdminDao;
import com.zzu.StuManage.entity.Student;

@WebServlet("/Adm.action")
public class AdminServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//查询学生
	public void querryStu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("specially");
		String specially = new String(s.getBytes("ISO-8859-1"),"utf-8");
		String sno = request.getParameter("sno");
		String sn = request.getParameter("sname");
		String sname = new String(sn.getBytes("ISO-8859-1"),"utf-8");
		AdminDao  ad = new AdminDao();
		List<Student> sList = new ArrayList<Student>();
		Student stu = new Student();
		if(sno=="") {
			if(sname=="") {
				
			}else if("--请选择专业--".equals(specially)) {
				sList =ad.querryStuBySname(sname);
			}else {
				sList =ad.querryStu(specially);
			}
		}else {
			stu = ad.StuInfo(sno);
			sList.add(stu);
		}
	
		request.setAttribute("sList", sList);
		request.getRequestDispatcher("/admviews/main.jsp").forward(request, response);
	}	
	//更新修改学生个人信息
	public void updateStu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Object [] params = new Object[6] ;
		int rows = 0;
		String sno = request.getParameter("sno");
		params[0] = request.getParameter("sname");
		String gender = request.getParameter("gender");
		params[1]  = new String(gender.getBytes("ISO-8859-1"),"utf-8");
		params[2] = request.getParameter("birthday");
		params[3] = request.getParameter("enrollyear");
		String specially = request.getParameter("specially");
		params[4]  = new String(specially.getBytes("ISO-8859-1"),"utf-8");
		params[5] = request.getParameter("dno");
		System.out.println("sno"+sno);
		for(int i=0;i<6;i++) {
			System.out.println(" == "+params[i]);
		}
		AdminDao ad = new AdminDao() ;
		rows =  ad.updateStuById(sno, params);
		if(rows!=0) {
			this.querryStu(request, response);
		}else {
			System.out.println("出错");
		}
		
	}
	//修改跳转
	public void changeStu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String sno = request.getParameter("sno");
		AdminDao  ad = new AdminDao();
		Student stu = new Student();
		stu = ad.StuInfo(sno);
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("/admviews/updateStu.jsp").forward(request, response);
	}

	//添加学生信息
	public void addStu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Object params[] = new Object[7];
		int rows= 0;
		params[0] = request.getParameter("sno");
		params[1] = request.getParameter("sname");
		String gender = request.getParameter("gender");
		params[2]  = new String(gender.getBytes("ISO-8859-1"),"utf-8");
		params[3] = request.getParameter("birthday");
		params[4] = request.getParameter("enrollyear");
		String specially = request.getParameter("specially");
		params[4]  = new String(specially.getBytes("ISO-8859-1"),"utf-8");
		params[6] = request.getParameter("dno");	
		
		System.out.println(params[0]);
		
		AdminDao ad = new AdminDao() ;
		rows =  ad.insertStuInfo(params);
		 if(rows!=0) {
				this.querryStu(request, response);
			}else {
				System.out.println("出错");
			}
		
	}
	//按学号删除学生信息
	public void deleteStu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	   String sno =request.getParameter("sno");
	   AdminDao ad = new AdminDao();
	   int rows = 0;
	   rows =  ad.deleteStu(sno);
	   if(rows!=0) {
			response.getWriter().append("true");
		}else {
			response.getWriter().append("false");
		}
	}
	//录入学生成绩
	public void addStuGrade(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Object params[] = new Object[3];
		AdminDao ad = new AdminDao();
		params[0] =request.getParameter("sno");
		params[1] =request.getParameter("grade");
		params[2] =request.getParameter("cno");
		ad.addGrade(params);
		request.getRequestDispatcher("");
	}
	//重置学生账号密码
	public void resetPsd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String sno =request.getParameter("sno");
		AdminDao ad = new AdminDao();
		int rows = 0;
		   rows = ad.resetPsd(sno);
		   if(rows!=0) {
				response.getWriter().append("true");
			}else {
				response.getWriter().append("false");
			}

	}
}
