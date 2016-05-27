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

/**
 * 激活接口
 * GET	/active
 * @author liu
 *
 */
public class ActiveServlet extends HttpServlet {

	private static final long serialVersionUID = -3523419191502630036L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "active");
		outMap.put("unique", "32bitMD5");
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
