package com.itheima.redbaby.vo;


/**
 * 限时抢购 商品
 * @author liu
 *
 */
public class Limitbuy {
	private int id;
	/** 商品名称 */
	private String name;
	
	/** 商品图片*/
	private String pic;
	
	/** 会员价 */
	private double price;
	
	/**限时特价  */
	private double limitprice;
	
	/** 剩余时间，单位为秒*/
	private long lefttime;
	
	public Limitbuy() {
		// TODO Auto-generated constructor stub
	}
	
	public Limitbuy(int id, String name, String pic, double price, double limitprice, long lefttime) {
		super();
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.price = price;
		this.limitprice = limitprice;
		this.lefttime = lefttime;
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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getLimitprice() {
		return limitprice;
	}

	public void setLimitprice(double limitprice) {
		this.limitprice = limitprice;
	}

	public long getLefttime() {
		return lefttime;
	}

	public void setLefttime(long lefttime) {
		this.lefttime = lefttime;
	}
	
}
