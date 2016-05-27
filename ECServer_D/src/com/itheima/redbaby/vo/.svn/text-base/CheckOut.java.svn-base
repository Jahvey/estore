package com.itheima.redbaby.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 结算中心信息
 * 
 * @author liu
 * 
 */
public class CheckOut {

	/** 地址信息 */
	private Address address_info;

	/** 支付方式 */
	private Payment payment_info;

	/** 送货时间 */
	private Delivery delivery_info;

	/** 发票信息 */
	private InvoiceInfo invoice_info;

	/** 商品列表 */
	private List<OrderDetail> productlist = new ArrayList<OrderDetail>();

	/** 享受促销信息 */
	private List<String> checkout_prom = new ArrayList<String>();

	/** 总计 */
	private CheckoutAddup checkout_addup;

	public CheckOut() {
	}

	public CheckOut(Address address_info, Payment payment_info, Delivery delivery_info, InvoiceInfo invoice_info,
			List<OrderDetail> productlist, List<String> checkout_prom, CheckoutAddup checkout_addup) {
		super();
		this.address_info = address_info;
		this.payment_info = payment_info;
		this.delivery_info = delivery_info;
		this.invoice_info = invoice_info;
		this.productlist = productlist;
		this.checkout_prom = checkout_prom;
		this.checkout_addup = checkout_addup;
	}

	public Address getAddress_info() {
		return address_info;
	}

	public void setAddress_info(Address address_info) {
		this.address_info = address_info;
	}

	public Payment getPayment_info() {
		return payment_info;
	}

	public void setPayment_info(Payment payment_info) {
		this.payment_info = payment_info;
	}

	public Delivery getDelivery_info() {
		return delivery_info;
	}

	public void setDelivery_info(Delivery delivery_info) {
		this.delivery_info = delivery_info;
	}

	public InvoiceInfo getInvoice_info() {
		return invoice_info;
	}

	public void setInvoice_info(InvoiceInfo invoice_info) {
		this.invoice_info = invoice_info;
	}

	public List<OrderDetail> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<OrderDetail> productlist) {
		this.productlist = productlist;
	}

	public List<String> getCheckout_prom() {
		return checkout_prom;
	}

	public void setCheckout_prom(List<String> checkout_prom) {
		this.checkout_prom = checkout_prom;
	}

	public CheckoutAddup getCheckout_addup() {
		return checkout_addup;
	}

	public void setCheckout_addup(CheckoutAddup checkout_addup) {
		this.checkout_addup = checkout_addup;
	}

}
