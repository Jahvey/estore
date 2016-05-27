package com.itheima.redbaby.vo;

public class ProductProperty {
	
	private String color;
	private String size;
	
	private boolean isGift;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public ProductProperty(String color, String size) {
		super();
		this.color = color;
		this.size = size;
	}
	public boolean isGift() {
		return isGift;
	}
	public void setGift(boolean isGift) {
		this.isGift = isGift;
	}
	public ProductProperty(String color, String size, boolean isGift) {
		super();
		this.color = color;
		this.size = size;
		this.isGift = isGift;
	}
	
	
	
}
