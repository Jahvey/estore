package com.itheima.redbaby.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 * @author liu
 *
 */
public class Cart {
	/** 商品列表 */
	public List<OrderDetail> productlist = new ArrayList<OrderDetail>();
	
	/** 享受促销信息 */
	public List<String> cart_prom = new ArrayList<String>();
	
	/** 购物车总计*/
	public Addup cart_addup = new Addup();

	public Cart() {

	}
	
	public Cart(List<OrderDetail> productlist, List<String> cart_prom, Addup cart_addup) {
		super();
		this.productlist = productlist;
		this.cart_prom = cart_prom;
		this.cart_addup = cart_addup;
	}



	public List<OrderDetail> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<OrderDetail> productlist) {
		this.productlist = productlist;
	}

	public List<String> getCart_prom() {
		return cart_prom;
	}

	public void setCart_prom(List<String> cart_prom) {
		this.cart_prom = cart_prom;
	}

	public Addup getCart_addup() {
		int total_count = 0;
		int total_price = 0;
		for (OrderDetail detail : productlist) {
			total_count +=  detail.getProdNum();
			total_price += detail.getSubtotal();
		}
		cart_addup.setTotal_count(total_count);
		cart_addup.setTotal_price(total_price);
		
		return cart_addup;
	}

	public void setCart_addup(Addup cart_addup) {
		this.cart_addup = cart_addup;
	}

	 
}
