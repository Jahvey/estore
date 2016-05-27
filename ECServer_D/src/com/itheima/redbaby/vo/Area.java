package com.itheima.redbaby.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 地区
 * 
 * @author liu
 * 
 */
public class Area {
	/** ID */
	private int id;

	/** 名称 */
	private String value;

	/** 下一级地址 */
	private List<Area> sub_area = new ArrayList<Area>();

	public Area() {
	}

	public Area(int id, String value, List<Area> sub_area) {
		super();
		this.id = id;
		this.value = value;
		this.sub_area = sub_area;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Area> getSub_area() {
		return sub_area;
	}

	public void setSub_area(List<Area> sub_area) {
		this.sub_area = sub_area;
	}

}
