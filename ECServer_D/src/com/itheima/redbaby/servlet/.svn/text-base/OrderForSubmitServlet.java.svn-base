package com.itheima.redbaby.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.redbaby.config.Constant;
import com.itheima.redbaby.service.CommonUtil;
import com.itheima.redbaby.vo.Cart;
import com.itheima.redbaby.vo.OrderForSubmit;

/**
 * Servlet implementation class OrderForSubmitServlet
 */
@WebServlet("/OrderForSubmitServlet")
public class OrderForSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "orderdetail");
		OrderForSubmit order = new OrderForSubmit();
		order.setOrderid("1112111111");
		order.setPaymenttype("1");
		order.setPrice("230");
		outMap.put("orderinfo", order);
		request.getSession().setAttribute("cart", new Cart());
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
