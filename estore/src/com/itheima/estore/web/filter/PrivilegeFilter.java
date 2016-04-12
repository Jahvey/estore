package com.itheima.estore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.itheima.estore.domain.User;

/**
 * 权限过滤器
 * @author jiangtao
 *
 */
public class PrivilegeFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/**
		 * 1.判断用户是否已经登录:
		 * 	* 已经登录:放行.
		 *  * 没有登录:页面跳转.
		 */
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("existUser");
		if(user != null){
			// 已经登录
			chain.doFilter(req, response);
		}else{
			// 没有登录
			req.setAttribute("msg", "亲！您还没有登录！没有权限访问！");
			req.getRequestDispatcher("/jsps/user/login.jsp").forward(req, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
