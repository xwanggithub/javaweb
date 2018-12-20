package com.zzu.StuManage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzu.StuManage.dao.CheckDao;


public class AutoLoginFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse = (HttpServletResponse) response;
		String rPaht = hRequest.getRequestURI();
		if(rPaht.indexOf("login.jsp")>0){
			System.out.println("----------路径："+rPaht);
			Cookie[] cs = hRequest.getCookies();
			String userName = null;
			String userId = null;
			String passwd = null;
			String identify = null;
			if(cs != null){
				for(Cookie cook : cs){
					if("userId".equals(cook.getName())){
						userId = cook.getValue();
					}
					if("passwd".equals(cook.getName())){
						passwd = cook.getValue();
					}
					if("identify".equals(cook.getName())){
						identify = cook.getValue();
					}
					
				}
				System.out.println("Cookie信息："+userId+"||"+passwd+"||"+identify);
				
				
				
				/**
				if((userId!=null) && (passwd!=null) && (identify!=null)){					
					CheckDao cd = new  CheckDao();
					if("user".equals(identify)) {
						userName = cd.checkUser(userId,passwd);
					}else {
						userName = cd.checkAdmin(userId, passwd);
					}
					if(userName!=null){
						hRequest.getSession().setAttribute("userId", userId);
						hRequest.getSession().setAttribute("userName", userName);
						System.out.println("自动登录！");
						hResponse.sendRedirect("/StuManagement/views/index.jsp");
					}else{
						System.out.println("cookie需要更新了");
						hResponse.sendRedirect("/StuManagement/views/login.jsp");
					}
				}
				
				*/
				
				hRequest.setAttribute("userId", userId);
				hRequest.setAttribute("passwd", passwd);								
			}	
		}
		hRequest.getRequestDispatcher("/StuManagement/views/login.jsp");
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
