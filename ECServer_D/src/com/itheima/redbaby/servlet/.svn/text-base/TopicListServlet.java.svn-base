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
import com.itheima.redbaby.vo.Limitbuy;
import com.itheima.redbaby.vo.Product;
import com.itheima.redbaby.vo.ProductList;

/**
 * 
 * 专题商品列表
 * GET	/topic/plist
 * @author liu
 *
 */
public class TopicListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3198560226235822752L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "topic_productlist");
		List<ProductList> productlist = new ArrayList<ProductList>();

		for (int i = 0; i < 2; i++) {
			//			ProductList vo = new ProductList(10000+i, "奶粉" + i, 1000.12, 800.12, Constant.pic_url.concat("product_05.jpg"), 30 + i);

			ProductList vo = new ProductList(101, "奶粉" + i, 1000.12, 800.12, Constant.pic_url.concat("product_05.jpg"), 30 + i);
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
