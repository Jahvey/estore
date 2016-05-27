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
import com.itheima.redbaby.vo.ProductList;

/**
 * 搜索列表
 * @author liu
 *
 */
public class Search extends HttpServlet {
	 	
	private static final long serialVersionUID = 5167478275475516683L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "search");
		List<ProductList> productlist = new ArrayList<ProductList>();
		
		for (int i = 0; i < 50; i++) {
			ProductList vo = new ProductList(10000 + i , "雅培金装" + i, 1000.00 + 1, 800.00 + 2, Constant.pic_url.concat("search1.png"), 100 + i);
			productlist.add(vo);
 		}
		outMap.put("productlist", productlist);
		outMap.put("list_count", productlist.size());
		CommonUtil.renderJson(resp, outMap);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	};
}
