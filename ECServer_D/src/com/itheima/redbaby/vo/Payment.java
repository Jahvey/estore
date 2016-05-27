package com.itheima.redbaby.vo;

/**
 * 支付方式
 * 
 *  支付类型，1=>货到付款 2=>货到POS机    3=>支付宝(待定)

 * @author liu
 *
 */
public class Payment {
	private int type;

	public Payment() {
	}

	public Payment(int type) {
		super();
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
