package com.itheima.redbaby.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.redbaby.config.Constant;
import com.itheima.redbaby.service.CommonUtil;
import com.itheima.redbaby.vo.Addup;
import com.itheima.redbaby.vo.Cart;
import com.itheima.redbaby.vo.CartProduct;
import com.itheima.redbaby.vo.OrderDetail;
import com.itheima.redbaby.vo.Product;
import com.itheima.redbaby.vo.ProductDetail;

public class CartDataSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	public  static Map<String, Product> prouducts = new HashMap<String, Product>();
	static {
		prouducts.put("101", new Product(101, "奶粉", 100.00, 200.00, Constant.pic_url.concat("image1.png")));
		prouducts.put("102", new Product(102, "衣服", 110.00, 210.00, Constant.pic_url.concat("image2.png")));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idGet = req.getParameter("id");
		String count = req.getParameter("count");
 		Cart cart = (Cart) req.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			req.getSession().setAttribute("cart", cart);
		}
		Product product = prouducts.get(idGet);
		if (product == null)
			product = prouducts.get(101);
		OrderDetail cp = new OrderDetail(1001, product.getName(), product.getPrice(), product.getPic(), Integer.parseInt(count), Integer.parseInt(count) * product.getPrice(), 10, 10,
				false);
		cart.getProductlist().add(cp);


		List<String> cart_prom = new ArrayList<String>();
		cart_prom.add("促销信息一");
		cart_prom.add("促销信息二");
 		
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "success");
		CommonUtil.renderJson(resp, outMap);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
