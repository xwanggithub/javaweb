package com.zzu.StuManage.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionListenerTest implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId() + "被创建----------------");
		
		
		ServletContext sc = session.getServletContext();
		Object num = sc.getAttribute("ONLINE_PEOPLE_NUM");
		int pNum = 1;
		if(num == null){
			sc.setAttribute("ONLINE_PEOPLE_NUM", 1);
		}else{
			pNum = (Integer)num;
			pNum++;
			sc.setAttribute("ONLINE_PEOPLE_NUM", pNum);
		}
		System.out.println("---------------当前访问网站人数-------------------"  + pNum);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId() + "被销毁----------------");
		
		ServletContext sc = session.getServletContext();
		Object num = sc.getAttribute("ONLINE_PEOPLE_NUM");
		
		int pNum = (Integer)num;
		pNum--;
		sc.setAttribute("ONLINE_PEOPLE_NUM", pNum);
		System.out.println("---------------当前网站还剩人数-------------------"  + pNum);
	}

}
