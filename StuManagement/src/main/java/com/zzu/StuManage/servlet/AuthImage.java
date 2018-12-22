package com.zzu.StuManage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zzu.StuManage.util.Constance;
import com.zzu.StuManage.util.VerifyCodeUtils;



/**
 * @Description:TODO
 * @Company  郑州兴唐IT教育
 * @author 王滔
 * @email 675475017@qq.com
 * @date：2017年5月31日下午6:39:42
 */
@WebServlet("/authImage")
public class AuthImage extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5117792479757903258L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        response.setContentType("image/jpeg"); 
           
        //生成随机字串 
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
        //存入会话session 
        HttpSession session = request.getSession(true); 
        //删除以前的
        session.removeAttribute(Constance.VER_CODE);
        session.setAttribute(Constance.VER_CODE, verifyCode.toLowerCase()); 
        //生成图片 
        int w = 106, h = 35; 
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode); 
   
    }  
}
