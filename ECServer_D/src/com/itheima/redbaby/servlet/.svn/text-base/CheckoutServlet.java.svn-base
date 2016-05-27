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
import com.itheima.redbaby.vo.Addup;
import com.itheima.redbaby.vo.Cart;
import com.itheima.redbaby.vo.CartProduct;
import com.itheima.redbaby.vo.CheckOut;
import com.itheima.redbaby.vo.CheckoutAddup;
import com.itheima.redbaby.vo.Delivery;
import com.itheima.redbaby.vo.InvoiceInfo;
import com.itheima.redbaby.vo.OrderDetail;
import com.itheima.redbaby.vo.Payment;

/**
 * 结算中心信息
 * POST	/checkout
 * @author liu
 * 
 */
public class CheckoutServlet extends HttpServlet {

	private static final long serialVersionUID = -347298763156672679L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "checkout");
		
		Address address_info = new Address(1001, "肖文", "北京市海淀区", "闵庄路3号");
		
		Payment payment_info = new Payment(1);
		Delivery delivery_info = new Delivery(1);
		InvoiceInfo invoice_info = new InvoiceInfo(132, "红孩子信息有限公司", "办公用品");
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		List<OrderDetail> productlist = cart.getProductlist();
		
		List<String> checkout_prom = new ArrayList<String>();
		checkout_prom.add("促销信息一");
		checkout_prom.add("促销信息二");;
		
		Addup cart_addup = cart.getCart_addup();
		CheckoutAddup checkout_addup = new CheckoutAddup(cart_addup.getTotal_count(), cart_addup.getTotal_price(), cart_addup.getTotal_point(), 10, 0);
		CheckOut checkOut = new CheckOut(address_info, payment_info, delivery_info, invoice_info, productlist, checkout_prom, checkout_addup);
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
	}
}
