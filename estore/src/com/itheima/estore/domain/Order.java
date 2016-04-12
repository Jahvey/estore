package com.itheima.estore.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单的实体:
 * @author jiangtao
 *
 */
public class Order {
	private String oid;
	private double total;
	private Date ordertime;
	private int state;
	private String address;
	private User user;
	
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
