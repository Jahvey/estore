package com.itheima.estore.domain;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车的实体:
 * @author jiangtao
 *
 */
public class Cart {
	// 属性:购物项集合的属性Map  Map的key是图书的ID  Map的value是购物项.
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	// 总计属性:
	private double total;
	/*public Map<String, CartItem> getMap() {
		return map;
	}*/
	
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	public double getTotal() {
		return total;
	}
	
	// 功能:
	/**
	 * 将购物项添加到购物车:
	 */
	public void addCart(CartItem cartItem){
		// 判断购物项是否在购物车的map中.
		String bid = cartItem.getBook().getBid();
		if(map.containsKey(bid)){
			// 购物项已经在购物车中
			// 获得原有数量:
			CartItem _cartItem = map.get(bid);
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			// 购物项没有在购物车中
			map.put(bid, cartItem);
		}
		// 总计+=新添加购物项的小计:
		total += cartItem.getSubtotal();
	}
	
	/**
	 * 将购物项从购物车中移除:
	 */
	public void removeCart(String bid){
		// 从map中移除购物项
		CartItem cartItem = map.remove(bid);
		// 总计 -= 移除购物项的小计.
		total -= cartItem.getSubtotal();
	}
	
	/**
	 * 清空购物车
	 */
	public void clearCart(){
		// map清空
		map.clear();
		// 总计为0
		total = 0;
	}
}
