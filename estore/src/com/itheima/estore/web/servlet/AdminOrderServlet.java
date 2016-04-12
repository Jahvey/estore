package com.itheima.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.itheima.estore.domain.Order;
import com.itheima.estore.domain.OrderItem;
import com.itheima.estore.service.OrderService;
import com.itheima.estore.utils.BaseServlet;
/**
 * 后台订单管理的Servlet
 * @author jiangtao
 *
 */
public class AdminOrderServlet extends BaseServlet {
	/**
	 * 异步加载订单项的方法:
	 * @throws IOException 
	 */
	public String showDetail(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		// 1.接收oid:
		String oid = req.getParameter("oid");
		// 2.根据订单的ID查询订单项:
		OrderService orderService = new OrderService();
		List<OrderItem> list = orderService.findOrderItems(oid);
		// 3.输出JSON:--JSONLib.
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"itemid","order"});
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		System.out.println(jsonArray.toString());
		resp.getWriter().println(jsonArray.toString());
		return null;
	}
	
	/**
	 * 修改订单状态的方法:
	 */
	public String updateState(HttpServletRequest req,HttpServletResponse resp){
		// 1.接收oid:
		String oid = req.getParameter("oid");
		// 2.根据oid查询订单:
		OrderService orderService = new OrderService();
		Order order = orderService.findByOid(oid);
		order.setState(3);
		orderService.update(order);
		// 3.修改订单状态
		return findAll(req, resp);
	}
	
	/**
	 * 查询所有订单:
	 */
	public String findAll(HttpServletRequest req,HttpServletResponse resp){
		// 1.接收状态:
		String value = req.getParameter("state");
		OrderService orderService = new OrderService();
		List<Order> list = null;
		if(value== null){
			// 查询所有
			list = orderService.findAll();
		}else{
			// 按状态查询
			int state = Integer.parseInt(value);
			list = orderService.findByState(state);
		}
		req.setAttribute("list", list);
		return "/adminjsps/admin/order/order_list.jsp";
	}
}
