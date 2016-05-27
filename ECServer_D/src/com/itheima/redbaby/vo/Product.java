package com.itheima.redbaby.vo;

/**
 * 商品实体
 * 
 * @author liu
 * 
 */
public class Product {

	/** ID */
	private int id;

	/** 商品名称 */
	private String name;

	/** 市场价 */
	private double marketprice;

	/** 会员价 */
	private double price;

	/** 图片 */
	private String pic;

	public Product() {

	}

	public Product(int id, String name, double marketprice, double price, String pic) {
		super();
		this.id = id;
		this.name = name;
		this.marketprice = marketprice;
		this.price = price;
		this.pic = pic;
	}
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(double marketprice) {
		this.marketprice = marketprice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
}
