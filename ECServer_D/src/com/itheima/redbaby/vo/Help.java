package com.itheima.redbaby.vo;

/**
 * 帮助
 * @author liu
 *
 */
public class Help {
	private int id;
	private String title;
	/** 帮助信息URL地址*/
	private String detail_url;
	
	public Help() {
 
	}
	
	public Help(int id, String title, String detail_url) {
		super();
		this.id = id;
		this.title = title;
		this.detail_url = detail_url;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}
}
