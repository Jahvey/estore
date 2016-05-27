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
import com.itheima.redbaby.vo.Address;
import com.itheima.redbaby.vo.CartProduct;
import com.itheima.redbaby.vo.CheckOut;
import com.itheima.redbaby.vo.CheckoutAddup;
import com.itheima.redbaby.vo.Delivery;
import com.itheima.redbaby.vo.InvoiceInfo;
import com.itheima.redbaby.vo.OrderDetail;
import com.itheima.redbaby.vo.OrderInfo;
import com.itheima.redbaby.vo.Payment;

/**
 * 订单详情
 * GET	/orderdetail
 * @author liu
 *
 */
public class OrderDetailServlet extends HttpServlet {

	private static final long serialVersionUID = -7214362164707492245L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "orderdetail");

		Address address_info = new Address(1001, "肖文", "北京市海淀区", "闵庄路3号");

		Payment payment_info = new Payment(1);
		Delivery delivery_info = new Delivery(1);
		InvoiceInfo invoice_info = new InvoiceInfo(132, "红孩子信息有限公司", "办公用品");
		List<OrderDetail> productlist = new ArrayList<OrderDetail>();
 		OrderDetail cp = new OrderDetail(1001, "雅培金装", 100.00, Constant.pic_url.concat(1 + ".png"), 1, 100.00, 10, 10,
				false);
		OrderDetail cp1 = new OrderDetail(1002, "雅培金装", 200.00, Constant.pic_url.concat(2 + ".png"), 1, 200.00, 10, 10,
				false);
		OrderDetail cp2 = new OrderDetail(1003, "雅培金装", 300.00, Constant.pic_url.concat(3 + ".png"), 1, 300.00, 10, 10,
				false);
		productlist.add(cp);
		productlist.add(cp1);
		productlist.add(cp2);
		;

		List<String> checkout_prom = new ArrayList<String>();
		checkout_prom.add("促销信息一");
		checkout_prom.add("促销信息二");
		;

		CheckoutAddup checkout_addup = new CheckoutAddup(3, 610.00, 0, 10, 0);
		CheckOut checkOut = new CheckOut(address_info, payment_info, delivery_info, invoice_info, productlist,
				checkout_prom, checkout_addup);
		OrderInfo ords = new OrderInfo("2324244", "已完成", "2011/10/100 12:16:40", 1);
		
		
		outMap.put("order_info", ords);
		outMap.put("address_info", checkOut.getAddress_info());
		outMap.put("payment_info", checkOut.getPayment_info());
		outMap.put("delivery_info", checkOut.getDelivery_info());
		outMap.put("invoice_info", checkOut.getInvoice_info());
		outMap.put("productlist", checkOut.getProductlist());
		outMap.put("checkout_prom", checkOut.getCheckout_prom());
		outMap.put("checkout _addup", checkOut.getCheckout_addup());

 		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};

}
