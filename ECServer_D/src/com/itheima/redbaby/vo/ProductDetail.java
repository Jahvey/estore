package com.itheima.redbaby.vo;

import java.util.List;

/**
 * 商品详细
 * @author liu
 *
 */
public class ProductDetail {
	
	/** ID */
	private int id;

	/** 商品名称 */
	private String name;

	/** 市场价 */
	private double marketprice;

	/** 会员价 */
	private double price;

	/** 限时抢购价*/
	private double limitPrice;

	/** 剩余时间，单位为秒*/
	private long leftTime;
	
	/** 商品评论数 */
	private int comment_count;
	
	/** 评分 */
	private String score;

	/** yes/no 是否可售*/
	private String available;
	
	/** 单品购买上限 */
	private int buyLimit;
	
	/** 相关促销信息展示 */
	private List<String> product_prom;
	
	/** 配货说明 */
	private String inventory_area;
	
	/** 图片 */
	private List<String> pic;

	/** 大图片 */
	private List<String> bigPic;

	public ProductDetail() {
	}
	
	public ProductDetail(int id, String name, double marketprice, double price, double limitPrice, long leftTime,
			int comment_count, String score, String available, int buyLimit, List<String> product_prom,
			String inventory_area, List<String> pic, List<String> bigPic) {
		super();
		this.id = id;
		this.name = name;
		this.marketprice = marketprice;
		this.price = price;
		this.limitPrice = limitPrice;
		this.leftTime = leftTime;
		this.comment_count = comment_count;
		this.score = score;
		this.available = available;
		this.buyLimit = buyLimit;
		this.product_prom = product_prom;
		this.inventory_area = inventory_area;
		this.pic = pic;
		this.bigPic = bigPic;
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

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public long getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(long leftTime) {
		this.leftTime = leftTime;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public int getBuyLimit() {
		return buyLimit;
	}

	public void setBuyLimit(int buyLimit) {
		this.buyLimit = buyLimit;
	}

	public List<String> getProduct_prom() {
		return product_prom;
	}

	public void setProduct_prom(List<String> product_prom) {
		this.product_prom = product_prom;
	}

	public String getInventory_area() {
		return inventory_area;
	}

	public void setInventory_area(String inventory_area) {
		this.inventory_area = inventory_area;
	}

	public List<String> getPic() {
		return pic;
	}

	public void setPic(List<String> pic) {
		this.pic = pic;
	}

	public List<String> getBigPic() {
		return bigPic;
	}

	public void setBigPic(List<String> bigPic) {
		this.bigPic = bigPic;
	}
	
	 
}
	