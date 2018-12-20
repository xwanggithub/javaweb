package com.zzu.StuManage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.StuManage.dao.CheckDao;

@WebServlet("/doLogin")
public class LoginServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
				
		String userName = null;
		String userId = request.getParameter("username");
		String password = request.getParameter("password");
		String identity = request.getParameter("user");
		String auto = request.getParameter("auto");
		
		System.out.println("-------->"+userId+"下次是否自动登录"+auto);
		
		CheckDao cl = new CheckDao();
		if(identity.equals("user")) {
			userName = cl.checkUser(userId, password);
		}else {
			userName = cl.checkAdmin(userId, password);
		}		
		System.out.println("--------->"+identity);
		if(null!=userName) {	
			request.getSession().setAttribute("userId", userId);
			request.getSession().setAttribute("userName", userName);
			
			if("1".equals(auto)) {
				Cookie nameC = new Cookie("userId", userId);
				Cookie passwdC = new Cookie("passwd", password);
				Cookie identifyC = new Cookie("identify",identity);
				nameC.setMaxAge(60*60*24);			//设置一天Cookie
				passwdC.setMaxAge(60*60*24);
				identifyC.setMaxAge(60*60*24);
				response.addCookie(identifyC);
				response.addCookie(nameC);
				response.addCookie(passwdC);
			}						
			if(identity.equals("user")) {
				request.getRequestDispatcher("/views/index.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/admviews/index.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("MSG", "账号或者密码错误！");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}
	

}
