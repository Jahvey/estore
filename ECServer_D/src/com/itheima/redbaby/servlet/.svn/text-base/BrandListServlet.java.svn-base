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
import com.itheima.redbaby.vo.Product;

/**
 * 品牌商品列表
 * 
 * GET /brand/plist
 * 
 * @author liu
 * 
 */
public class BrandListServlet extends HttpServlet {

	private static final long serialVersionUID = 8088110485813123735L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "brand_productlist");
		List<Product> productlist = new ArrayList<Product>();

		for (int i = 0; i < 10; i++) {
			Product vo = new Product(10000 + i, "毛衣" + i, 1000.00 + i, 800.00, Constant.pic_url.concat(i + ".png"));
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
