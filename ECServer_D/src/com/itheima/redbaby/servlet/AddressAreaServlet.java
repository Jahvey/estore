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
import com.itheima.redbaby.vo.Area;

/**
 * 地址三级列表 GET /addressarea
 * 
 * @author liu
 * 
 */
public class AddressAreaServlet extends HttpServlet {

	private static final long serialVersionUID = 11557290469579093L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "brand_productlist");
		List<Area> areas = new ArrayList<Area>();
		
		List<Area> sub_area = new ArrayList<Area>();
		sub_area.add(new Area(3, "海淀", null));
		sub_area.add(new Area(4, "朝阳", null));
		sub_area.add(new Area(5, "东城区", null));
 
		List<Area> sub1 = new ArrayList<Area>();
		sub1.add(new Area(2, "北京市", sub_area));
		Area a1 = new Area(1, "北京", sub1);
		areas.add(a1);
		
		outMap.put("arealist", areas);
		outMap.put("version", 13);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
