package com.itheima.estore.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用的Servlet的编写
 * @author jiangtao
 *
 */
public class BaseServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		// 接收参数
		String methodName = req.getParameter("method");
		if(methodName == null){
			resp.getWriter().println("你没有传递method的参数!");
			return;
		}else{
			// 获得到子类的Class
			Class clazz = this.getClass();
			try {
				// 获得方法
				Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
				// 方法执行返回字符串
				String result = (String) method.invoke(this, req,resp);
				if(result != null){
					req.getRequestDispatcher(result).forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
}
