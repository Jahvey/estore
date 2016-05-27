package com.itheima.redbaby.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.redbaby.config.Constant;
import com.itheima.redbaby.service.CommonUtil;
import com.itheima.redbaby.vo.LoginUserInfo;
import com.itheima.redbaby.vo.User;

/**
 * 注册
 * POST	/register
 * @author liu
 *
 */
public class RegisterServlet extends HttpServlet {
 
	private static final long serialVersionUID = -476923938744786057L;

	private static Set<User> users = new HashSet<User>();
	static {
		users.add(new User("liu@qq.com", "123456"));
	}
	
	public static boolean contains (User user) {
		return users.contains(user);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User(username, password);
		users.add(user);
		LoginUserInfo loginUserInfo = new LoginUserInfo(1, username);
		req.getSession().setAttribute("user", loginUserInfo);
		
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "register");
		LoginUserInfo infos = new LoginUserInfo(1000, "sewfwefwfw3fw54fw654fw65f4w5f465");
		outMap.put("userinfo", infos);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
