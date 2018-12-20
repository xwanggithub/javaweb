package com.zzu.StuManage.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logOut")
public class LogOutServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("userName");
		request.getSession().removeAttribute("userId");
		response.sendRedirect("/StuManagement/views/login.jsp");
	}
}
