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
import com.itheima.redbaby.vo.HomeBanner;

/**
 * 首页 home_banner
 * @author liu
 *
 */
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "home");
		List<HomeBanner> baners = new ArrayList<HomeBanner>();
		for (int i = 0; i < 5; i++) {
			HomeBanner vo = new HomeBanner(i, "活动", Constant.pic_url.concat("image" +(i + 1) + ".png"));
			baners.add(vo);
 		}
		outMap.put("home_banner", baners);
		CommonUtil.renderJson(resp, outMap);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	};
}
