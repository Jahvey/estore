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
import com.itheima.redbaby.vo.ProductDetail;

/**
 * 商品详情
 * GET	/product
 * @author liu
 *
 */
public class ProductServlet extends HttpServlet {

	 
	private static final long serialVersionUID = -5171023354363648380L;

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "product");
		List<String> product_prom = new ArrayList<String>();
		product_prom.add("促销信息1");
		product_prom.add("促销信息2");
		
		List<String> pic = new ArrayList<String>();
		pic.add(Constant.pic_url.concat("image1.png"));
		pic.add(Constant.pic_url.concat("image2.png"));
		
		List<String> bigPic = new ArrayList<String>();
		bigPic.add(Constant.pic_url.concat("image3.png"));
		bigPic.add(Constant.pic_url.concat("image4.png"));
		String id  = req.getParameter("id");
		System.out.println(id);
		Map<String, Product> prouducts = CartDataSessionServlet.prouducts;
		System.out.println(prouducts.size());
		Product product = prouducts.get(id);
		if (product == null) {
			product = prouducts.get("101");
		}
 		ProductDetail productDetail = new ProductDetail(product.getId(), product.getName(), product.getMarketprice(), product.getPrice(), 0, 0, 100, "一般", "YES", 10, product_prom, "快递", pic, bigPic);
		outMap.put("product", productDetail);
		CommonUtil.renderJson(resp, outMap);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	};
}
