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
import com.itheima.redbaby.vo.Addup;
import com.itheima.redbaby.vo.Cart;
import com.itheima.redbaby.vo.CartProduct;

/**
 * 进入购物车 
 * GET	/cart
 * 
 * @author liu
 *
 */
public class CartServlet extends HttpServlet {
 
	private static final long serialVersionUID = -6051980893463549109L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			req.getSession().setAttribute("cart", cart);
		}
		System.out.println(cart.productlist.size());
		outMap.put(Constant.RESPONSE, "cart");
		outMap.put("cart", cart);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
