package com.itheima.redbaby.vo;

public class ProductList {

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

	/** 商品评论数 */
	private int comment_count;

	public ProductList() {

	}

	public ProductList(int id, String name, double marketprice, double price, String pic, int comment_count) {
		super();
		this.id = id;
		this.name = name;
		this.marketprice = marketprice;
		this.price = price;
		this.pic = pic;
		this.comment_count = comment_count;
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

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
}
