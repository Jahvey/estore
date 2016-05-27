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
import com.itheima.redbaby.vo.Userinfo;

/**
 * 账户中心
 * GET	/userinfo
 * @author liu
 *
 */
public class UserinfoServlet extends HttpServlet {

	private static final long serialVersionUID = 296627778172127221L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "userinfo");
		Userinfo infos = new Userinfo(1000, 3002, "金卡", "dsdfsff234242424dd", 20, 12);
		outMap.put("userinfo", infos);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
