package com.itheima.redbaby.vo;

/**
 * 分类
 * 
 * @author liu
 * 
 */
public class Category {
	private int id;
	/** 列表名称 */
	private String name;

	/** 父id */
	private int parent_id;

	/** 图片 */
	private String pic;

	/** 描叙 */
	private String tag;

	/** 是否是孩子节点 */
	private boolean isleafnode;

	public Category() {
	
	}

	public Category(int id, String name, int parent_id, String pic, String tag, boolean isleafnode) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.pic = pic;
		this.tag = tag;
		this.isleafnode = isleafnode;
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

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isIsleafnode() {
		return isleafnode;
	}

	public void setIsleafnode(boolean isleafnode) {
		this.isleafnode = isleafnode;
	}

}
