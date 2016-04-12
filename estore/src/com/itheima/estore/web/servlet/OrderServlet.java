package com.itheima.estore.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.estore.domain.Cart;
import com.itheima.estore.domain.CartItem;
import com.itheima.estore.domain.Order;
import com.itheima.estore.domain.OrderItem;
import com.itheima.estore.domain.User;
import com.itheima.estore.service.OrderService;
import com.itheima.estore.utils.BaseServlet;
import com.itheima.estore.utils.PaymentUtils;
import com.itheima.estore.utils.UUIDUtils;

/**
 * 订单模块的Servlet
 * 
 * @author jiangtao
 * 
 */
public class OrderServlet extends BaseServlet {
	/**
	 * 前台修改订单状态的方法
	 */
	public String updateState(HttpServletRequest request,
			HttpServletResponse response){
		// 1.接收oid:
		String oid = request.getParameter("oid");
		// 2.根据OID查询订单:
		OrderService orderService = new OrderService();
		Order order = orderService.findByOid(oid);
		order.setState(4);
		orderService.update(order);
		return findByUid(request, response);
	}
	
	/**
	 * 支付成功后执行的方法:callBack
	 */
	public String callBack(HttpServletRequest request,
			HttpServletResponse response) {
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");

		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac = request.getParameter("hmac");

		boolean flag = PaymentUtils.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId,
				r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType,
				keyValue);
		if(flag){
			if("1".equals(r9_BType)){
				// 修改订单状态:
				OrderService orderService = new OrderService();
				Order order = orderService.findByOid(r6_Order);
				order.setState(2); // 2:已付款.
				orderService.update(order);
			}
		}
		// 页面跳转:
		request.setAttribute("msg", "订单支付成功！订单号:"+r6_Order+" 支付金额为:"+r3_Amt);
		return "/jsps/msg.jsp";
	}

	/**
	 * 订单付款的方法:payOrder
	 * 
	 * @throws IOException
	 */
	public String payOrder(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// 接收参数:
		String oid = req.getParameter("oid");
		String address = req.getParameter("address");
		String pd_FrpId = req.getParameter("pd_FrpId");

		// 修改订单地址:
		OrderService orderService = new OrderService();
		Order order = orderService.findByOid(oid);
		order.setAddress(address);
		orderService.update(order);

		// 为订单付款:
		// 准备向易宝提交参数:
		String p0_Cmd = "Buy"; // 业务类型.
		String p1_MerId = "10001126856"; // 商户编号.
		String p2_Order = oid; // 订单编号.
		String p3_Amt = "0.01"; // 支付金额
		String p4_Cur = "CNY"; // 交易币种
		String p5_Pid = "";// 商品名称.
		String p6_Pcat = "";// 商品种类
		String p7_Pdesc = "";// 商品描述
		String p8_Url = "http://192.168.17.49:8080/estore/orderServlet?method=callBack";// 支付成功后跳转路径
		String p9_SAF = ""; // 送货地址.
		String pa_MP = ""; // 扩展信息.
		String pr_NeedResponse = "1"; // 应答机制.
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac = PaymentUtils.buildHmac(p0_Cmd, p1_MerId, p2_Order,
				p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF,
				pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		// 使用重定向向易宝发送数据:
		StringBuffer buffer = new StringBuffer(
				"https://www.yeepay.com/app-merchant-proxy/node?");
		buffer.append("p0_Cmd=").append(p0_Cmd).append("&");
		buffer.append("p1_MerId=").append(p1_MerId).append("&");
		buffer.append("p2_Order=").append(p2_Order).append("&");
		buffer.append("p3_Amt=").append(p3_Amt).append("&");
		buffer.append("p4_Cur=").append(p4_Cur).append("&");
		buffer.append("p5_Pid=").append(p5_Pid).append("&");
		buffer.append("p6_Pcat=").append(p6_Pcat).append("&");
		buffer.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		buffer.append("p8_Url=").append(p8_Url).append("&");
		buffer.append("p9_SAF=").append(p9_SAF).append("&");
		buffer.append("pa_MP=").append(pa_MP).append("&");
		buffer.append("pd_FrpId=").append(pd_FrpId).append("&");
		buffer.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		buffer.append("hmac=").append(hmac);
		// System.out.println(buffer.toString());
		resp.sendRedirect(buffer.toString());
		return null;
	}

	/**
	 * 根据订单ID查询订单:
	 */
	public String findByOid(HttpServletRequest req, HttpServletResponse resp) {
		// 接收oid:
		String oid = req.getParameter("oid");
		// 调用业务层代码:
		OrderService orderService = new OrderService();
		Order order = orderService.findByOid(oid);
		req.setAttribute("order", order);
		// 页面跳转
		return "/jsps/order/desc.jsp";
	}

	/**
	 * 我的订单:根据用户的ID查询订单方法:
	 */
	public String findByUid(HttpServletRequest req, HttpServletResponse resp) {
		// 获得用户的ID:
		User user = (User) req.getSession().getAttribute("existUser");
		// 调用业务层的代码:
		OrderService orderService = new OrderService();
		List<Order> list = orderService.findByUid(user.getUid());
		req.setAttribute("list", list);
		// 页面跳转
		return "/jsps/order/list.jsp";
	}

	/**
	 * 生成订单的方法:
	 */
	public String saveOrder(HttpServletRequest req, HttpServletResponse resp) {
		// 封装一个Order对象:
		Order order = new Order();
		order.setOid(UUIDUtils.getUUID());
		order.setOrdertime(new Date());
		order.setAddress(null);
		order.setState(1);// 1:未付款 2:已付款,未发货 3:已发货,未确认收货 4:已经确认收货订单结束
		// 总金额从购物车中获得.
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		if (cart == null) {
			req.setAttribute("msg", "购物车为空！不能生成订单!");
			return "/jsps/msg.jsp";
		}
		order.setTotal(cart.getTotal());
		// 用户的信息从登陆中获得.
		User user = (User) req.getSession().getAttribute("existUser");
		if (user == null) {
			req.setAttribute("msg", "您还没有登录！请先去登录！");
			return "/jsps/user/login.jsp";
		}
		order.setUser(user);
		// 订单项的集合:
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemid(UUIDUtils.getUUID());
			orderItem.setBook(cartItem.getBook());
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrder(order);

			order.getOrderItems().add(orderItem);
		}
		// 调用业务层代码完成操作:
		OrderService orderService = new OrderService();
		orderService.save(order);
		// 页面跳转
		cart.clearCart();
		req.setAttribute("order", order);
		return "/jsps/order/desc.jsp";
	}
}
