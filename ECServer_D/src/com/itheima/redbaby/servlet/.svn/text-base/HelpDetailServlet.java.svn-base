package com.itheima.redbaby.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.redbaby.config.Constant;
import com.itheima.redbaby.service.CommonUtil;
import com.itheima.redbaby.vo.HelpDetail;

/**
 * 帮助内容获取
 * GET	/help_detail
 * @author liu
 *
 */
public class HelpDetailServlet extends HttpServlet {

 
	private static final long serialVersionUID = -1088828512424487273L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "help_detail");
		List<HelpDetail> helps = new ArrayList<HelpDetail>();
		helps.add(new HelpDetail("怎么购买", "content"));
		helps.add(new HelpDetail("怎么配送？", "content"));
		outMap.put("help_detail ", helps);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
