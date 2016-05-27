package com.itheima.redbaby.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.redbaby.config.Constant;
import com.itheima.redbaby.service.CommonUtil;
import com.itheima.redbaby.vo.Limitbuy;

/**
 * 限时抢购
 * GET	/limitbuy
 * @author liu
 * 
 */
public class LimitbuyServlet extends HttpServlet {

	public static  long time = 1335189632954L;
	
	
	private static final long serialVersionUID = 5971427830607130912L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "limitbuy");
		List<Limitbuy> productlist = new ArrayList<Limitbuy>();

		for (int i = 0; i < 10; i++) {
			Limitbuy vo = new Limitbuy(102, "雅培金装" + i, Constant.pic_url.concat("image10.png"), 1000.00, 800.00,
					time + i * 100000);
			productlist.add(vo);
		}
		outMap.put("productlist", productlist);
		outMap.put("list_count", productlist.size());
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
