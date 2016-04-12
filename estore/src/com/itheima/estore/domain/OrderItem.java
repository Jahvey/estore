package com.itheima.estore.domain;
/**
 * 订单项的实体
 * @author jiangtao
 *
 */
// Hibernate:ORM Object Relation Mapping:对象关系映射.
// 数据库：Relational  开发语言:Object
public class OrderItem {
	private String itemid;
	private int count;
	private double subtotal;
	private Book book;
	private Order order;
	// session.save(user);
	// session.update(user);
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
