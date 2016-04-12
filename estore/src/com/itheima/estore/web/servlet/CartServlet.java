package com.itheima.estore.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.estore.domain.Book;
import com.itheima.estore.domain.Cart;
import com.itheima.estore.domain.CartItem;
import com.itheima.estore.service.BookService;
import com.itheima.estore.utils.BaseServlet;

public class CartServlet extends BaseServlet {
	
	/**
	 * 从购物车中移除购物项的方法
	 */
	public String removeCart(HttpServletRequest req,HttpServletResponse resp){
		// 1.接收参数:
		String bid = req.getParameter("bid");
		// 2.获得购物车:
		Cart cart = getCart(req);
		// 3.调用 购物车中的方法:
		cart.removeCart(bid);
		// 页面跳转:
		return "/jsps/cart/list.jsp";
	}
	
	/**
	 * 清空购物车的方法:
	 */
	public String clearCart(HttpServletRequest req,HttpServletResponse resp){
		// 获得购物车:
		Cart cart = getCart(req);
		// 调用购物车中清空购物车的方法:
		cart.clearCart();
		// 页面跳转
		return "/jsps/cart/list.jsp";
	}
	
	/**
	 * 将购物项添加到购物车的方法:
	 * @return
	 */
	public String addCart(HttpServletRequest req,HttpServletResponse resp){
		// 接收参数:
		String bid = req.getParameter("bid");
		int count = Integer.parseInt(req.getParameter("count"));
		// 1.封装购物项CartItem
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		Book book = new BookService().findByBid(bid);
		cartItem.setBook(book);
		// 2.获得Cart对象
		Cart cart = getCart(req);
		cart.addCart(cartItem);
		// 3.页面跳转
		return "/jsps/cart/list.jsp";
	}

	// 获得购物车的方法:
	private Cart getCart(HttpServletRequest req) {
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			req.getSession().setAttribute("cart", cart);
		}
		return cart;
	}
}
