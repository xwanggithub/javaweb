package com.zzu.StuManage.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.StuManage.dao.AnnoDao;
import com.zzu.StuManage.entity.Announcement;
@WebServlet("/An.action")
public class AnnoServlet extends BaseServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//列出所有公告
	public void querryAnno(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		AnnoDao ad = new AnnoDao();
		List<Announcement> annoList = new ArrayList<Announcement>();
		annoList = ad.AnnouncementsInfoUtil();
		request.setAttribute("alist", annoList);
		request.getRequestDispatcher("/views/welcome.jsp").forward(request, response);;
 	}
	//查看公告
	public void announcement(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String ano = request.getParameter("ano");
		AnnoDao ad = new AnnoDao();
		Announcement ac = new Announcement();
		ac = ad.AnnouncementInfo(ano);
		request.setAttribute("announce", ac);
		request.getRequestDispatcher("/views/read.jsp").forward(request, response);
	}
	//添加公告
	public void addAnno(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat id = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// new Date()为获取当前系统时间
		
		Object[] params = new Object[4];
		params[0] = id.format(new Date());				//公告ID
		params[1] = request.getParameter("atitle");
		params[2] = df.format(new Date());								//时间
		params[3] = request.getParameter("amessage");
		AnnoDao ad = new AnnoDao();
		ad.addAnno(params);
		this.admAnno(request, response);
	}
	//修改公告
	public void updateAnno(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {		
		Object[] params = new Object[3];
		params[0] = request.getParameter("atitle");				//公告ID
		System.out.println(params[0] );
		params[1] = request.getParameter("amessage");
		System.out.println(params[1] );
		params[2] = request.getParameter("ano");							//时间
		System.out.println(params[2] );
		int rows = 0;
		
	
		
		
		AnnoDao ad = new AnnoDao();
		rows = ad.updateAnno(params);
		if(rows!=0) {
			this.admAnno(request, response);
		}else {
			System.out.println("chuzuole??");
		}		
	}
	public void changeAnno(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {		
		String ano = request.getParameter("ano");							//时间
		AnnoDao ad = new AnnoDao();
		Announcement ac = new Announcement();
		ac = ad.AnnouncementInfo(ano);
		request.setAttribute("announce", ac);
		request.getRequestDispatcher("/admviews/updateAnno.jsp").forward(request, response);
	}
	
	//管理界面
	public void admAnno(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		AnnoDao ad = new AnnoDao();
		List<Announcement> annoList = new ArrayList<Announcement>();
		annoList = ad.AnnouncementsInfoUtil();
		request.setAttribute("alist", annoList);
		request.getRequestDispatcher("/admviews/annoManage.jsp").forward(request, response);;
 	}
	
	//删除公告
	public void deleteAnno(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {		
		String ano = request.getParameter("ano");		
		AnnoDao ad = new AnnoDao();		
		int rows = 0;
		   rows = ad.deleteAnno(ano);
		   if(rows!=0) {
				response.getWriter().append("true");
			}else {
				response.getWriter().append("false");
			}
	}
}
