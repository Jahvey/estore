package com.itheima.redbaby.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.redbaby.config.Constant;
import com.itheima.redbaby.service.CommonUtil;
import com.itheima.redbaby.vo.LoginUserInfo;
import com.itheima.redbaby.vo.User;

/**
 * 登录
 * POST	/login
 * @author liu
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7813128092154329870L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username != null && password != null && RegisterServlet.contains(new User(username, password))) {
 				LoginUserInfo loginUserInfo = new LoginUserInfo(1, req.getSession().getId() + "");
				req.getSession().setAttribute("user", loginUserInfo);
				
				Map<String, Object> outMap = new HashMap<String, Object>();
				outMap.put(Constant.RESPONSE, "login");
				
				LoginUserInfo infos = new LoginUserInfo(1000, "sewfwefwfw3fw54fw654fw65f4w5f465");
				outMap.put("userinfo", infos);
				CommonUtil.renderJson(resp, outMap);
		} else {
			Map<String, Object> outMap = new HashMap<String, Object>();
			outMap.put(Constant.RESPONSE, "error");
			CommonUtil.renderJson(resp, outMap);
		}
 		 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
