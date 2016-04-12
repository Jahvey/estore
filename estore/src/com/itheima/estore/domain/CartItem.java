package com.itheima.estore.domain;
/**
 * 购物项的实体:
 * @author jiangtao
 *
 */
public class CartItem {
	private Book book;
	private int count;
	private double subtotal;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return book.getPrice() * count;
	}
	/*public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}*/
	
}
