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
import com.itheima.redbaby.vo.OrderList;

/**
 * 订单列表
 * GET	/orderlist
 * @author liu
 *
 */
public class OrderListServlet extends HttpServlet {

	private static final long serialVersionUID = 1581244240721589320L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "orderlist");
		List<OrderList> orderLists = new ArrayList<OrderList>();

		OrderList orderList = new OrderList("412423145", "未处理", 1234.23, "2011/10/100 12:16:40", 1);
		OrderList orderList2 = new OrderList("412423146", "已处理", 200.23, "2011/10/100 12:18:40", 3);
		OrderList orderList3 = new OrderList("412423147", "交易成功", 1234.23, "2011/10/100 12:16:40", 3);
		OrderList orderList4 = new OrderList("412423148", "未处理", 1234.23, "2011/10/100 12:20:40", 1);

		OrderList orderList5 = new OrderList("412423149", "未处理", 1234.23, "2011/10/100 12:16:40", 1);
		OrderList orderList6 = new OrderList("412423150", "已处理", 200.23, "2011/10/100 12:18:40", 3);
		OrderList orderList7 = new OrderList("412423151", "交易成功", 1234.23, "2011/10/100 12:16:40", 3);
		OrderList orderList8 = new OrderList("412423152", "未处理", 1234.23, "2011/10/100 12:20:40", 1);
		OrderList orderList9 = new OrderList("412423153", "未处理", 1234.23, "2011/10/100 12:16:40", 1);
		OrderList orderList10 = new OrderList("412423154", "已处理", 200.23, "2011/10/100 12:18:40", 3);
		OrderList orderList11 = new OrderList("412423155", "已处理", 200.23, "2011/10/100 12:18:40", 3);
		OrderList orderList12 = new OrderList("412423156", "已处理", 200.23, "2011/10/100 12:18:40", 3);
		
		orderLists.add(orderList);
		orderLists.add(orderList2);
		orderLists.add(orderList3);
		orderLists.add(orderList4);
		
		orderLists.add(orderList5);
		orderLists.add(orderList6);
		orderLists.add(orderList7);
		orderLists.add(orderList8);
		orderLists.add(orderList9);
		orderLists.add(orderList10);
		orderLists.add(orderList11);
		orderLists.add(orderList12);
		outMap.put("orderlist", orderLists);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};

}
