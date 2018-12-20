package com.zzu.StuManage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckLoginFilter implements Filter {

private String loginStrs;
	
	public void init(FilterConfig filterConfig) throws ServletException {

		loginStrs = filterConfig.getInitParameter("loginStrs");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		String path = hRequest.getRequestURI();
		Object userName = hRequest.getSession().getAttribute("userId");
		System.out.println("-------->username"+userName);
		if(userName != null || isLogin(path) ){				          
	            chain.doFilter(request, response);			  
		}else{			
			System.out.println("被拦截的路径："+path);
			((HttpServletResponse)response).sendRedirect("/StuManagement/views/login.jsp");
		}
		
	}

	/**
	 * 判断当前访问路径是否登陆路径
	 * @param path
	 * @return
	 */
	public boolean isLogin(String path){
		String[] loginPaths = loginStrs.split(",");
		boolean boo = false;
		for(String loginPath : loginPaths){
			if(loginPath.equals(path)){
				boo = true;
				break;
			}
		}
		return boo;
	}	
	public void destroy() {
		
	}

}
