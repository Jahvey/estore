package com.itheima.redbaby.vo;

public class CartProduct {
	/** ID */
	public String id;

	/** 商品名称 */
	public String name;

	/** 会员价 */
	public String price;

	/** 图片 */
	public String pic;

	/** 商品数量 */
	public String prodNum;

	/** 商品金额小计 */
	public String subtotal;

	/** 商品库存数量，0为缺货或下架 */
	public String number;

	/** 商品购买数量上限 */
	public String uplimit;

	/** 是否赠品 */
	public boolean isgift;

	public CartProduct() {
	}

	public CartProduct(String id, String name, String price, String pic, String prodNum, String subtotal, String number,
			String uplimit, boolean isgift) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.prodNum = prodNum;
		this.subtotal = subtotal;
		this.number = number;
		this.uplimit = uplimit;
		this.isgift = isgift;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getProdNum() {
		return prodNum;
	}

	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUplimit() {
		return uplimit;
	}

	public void setUplimit(String uplimit) {
		this.uplimit = uplimit;
	}

	public boolean isIsgift() {
		return isgift;
	}

	public void setIsgift(boolean isgift) {
		this.isgift = isgift;
	}
	
	
	
	
}
