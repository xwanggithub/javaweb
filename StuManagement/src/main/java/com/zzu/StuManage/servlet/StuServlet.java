package com.zzu.StuManage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.StuManage.dao.StuDao;
import com.zzu.StuManage.entity.Student;

@WebServlet("/Stu.action")
public class StuServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//学生个人信息
	public void queryStuInfo(HttpServletRequest request,HttpServletResponse response) {
		StuDao sind = new StuDao();
		Student stu = new Student();
		String userId = (String) request.getSession().getAttribute("userId");
		stu = sind.StudentInfo(userId);
		request.setAttribute("stu", stu);
		try {
			request.setAttribute("enrollyear", stu.getEnrollyear().substring(0, 4));
			request.getRequestDispatcher("/views/information.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//成绩信息
	public void getStuGrades(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userId = (String) request.getSession().getAttribute("userId");
		StuDao sgd = new StuDao();		
		request.setAttribute("sgds", sgd.scoreStudent(userId));
		request.getRequestDispatcher("/views/score.jsp").forward(request, response);
	}
	//学生选课
	public void myCourse(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		StuDao sd = new StuDao();
		String userId = (String) request.getSession().getAttribute("userId");
		request.setAttribute("mycourse", sd.myCourse(userId));
		request.getRequestDispatcher("/views/mycourse.jsp").forward(request, response);
	}
	//退选课程
	public void delCourse(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		StuDao sd = new StuDao();
		int rows = 0;
		String userId = (String) request.getSession().getAttribute("userId");
		String cno = request.getParameter("cno");
		System.out.println("userid="+userId+"cno="+cno);
		rows = sd.delCourse(userId, cno);
		System.out.println("删除行数"+rows);
		if(rows!=0) {
			response.getWriter().append("true");
		}else {
			response.getWriter().append("false");
		}
	}
	//显示我的选课
	public void showMyCose(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		StuDao sd = new StuDao();
		String userId = (String) request.getSession().getAttribute("userId");
		request.setAttribute("mycourse", sd.myCourse(userId));
		request.getRequestDispatcher("/views/showMyCourse.jsp").forward(request, response);
	}
	
	public void transform(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		request.setAttribute("cno", cno);
		request.setAttribute("cname", cname);
		request.getRequestDispatcher("/views/comment.jsp").forward(request, response);
	}
	//课程评价
	public void courseComment(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		StuDao sd = new StuDao();
		String userId = (String) request.getSession().getAttribute("userId");
		String cno = request.getParameter("cno");
		String comment1 = request.getParameter("comment");
		String comment = new String(comment1.getBytes("ISO-8859-1"),"utf-8");
		System.out.println("cno:"+cno+"comment:"+comment);
		int rows = 0;
		rows = sd.courseComment(userId, cno, comment);
		if(rows!=0) {
			this.showMyCose(request, response);
		}else {
			response.getWriter().append("false");
		}
	}
		
}
