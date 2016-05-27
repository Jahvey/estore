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
 * 新品推荐
 * 
 *GET /newproduct
 * @author liu
 *
 */
public class NewProductServlet extends HttpServlet {

	private static final long serialVersionUID = 7169438758035299407L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "newproduct");
		List<Product> productlist = new ArrayList<Product>();

		for (int i = 0; i < 10; i++) {
			Product vo = new Product(10000 + i, "雅培金装" + i, 1000.00 + i, 800.00, Constant.pic_url.concat("image10.png"));
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
