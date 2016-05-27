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
import com.itheima.redbaby.vo.Logistics;

/**
 * 
 * 物流查询
 * GET	/logistics
 * @author liu
 *
 */
public class LogisticsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7219504481354858893L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "logistics");

		List<String> list = new ArrayList<String>();
		list.add("到北京");
 		list.add("已签收");
		Logistics logistics = new Logistics("快递", "KKLI2324342424242", "顺丰", list);
		outMap.put("logistics", logistics);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
