package com.itheima.redbaby.vo;

/**
 * 地址详细
 * 
 * @author liu
 * 
 */
public class AddressDetail implements Comparable<AddressDetail> {

	/** 地址簿ID */
	private int id;

	/** 收货人姓名 */
	private String name;

	/** 手机号码 */
	private String phonenumber;

	/** 固定电话 */
	private String fixedtel;
	/** 省ID */
	private int provinceid;

	/** 市ID */
	private int cityid;

	/** 地区ID */
	private int areaid;

	/** 订单地址 */
	private String areadetail;

	/** 邮编 */
	private String zipcode;

	public AddressDetail() {
	}

	public AddressDetail(int id, String name, String phonenumber, String fixedtel, int provinceid, int cityid,
			int areaid, String areadetail, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.fixedtel = fixedtel;
		this.provinceid = provinceid;
		this.cityid = cityid;
		this.areaid = areaid;
		this.areadetail = areadetail;
		this.zipcode = zipcode;
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFixedtel() {
		return fixedtel;
	}

	public void setFixedtel(String fixedtel) {
		this.fixedtel = fixedtel;
	}

	public int getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}

	public String getAreadetail() {
		return areadetail;
	}

	public void setAreadetail(String areadetail) {
		this.areadetail = areadetail;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "AddressDetail [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", fixedtel=" + fixedtel
				+ ", provinceid=" + provinceid + ", cityid=" + cityid + ", areaid=" + areaid + ", areadetail="
				+ areadetail + ", zipcode=" + zipcode + "]";
	}

	@Override
	public int compareTo(AddressDetail o) {
		return id < o.id ? 1 : -1 ;
	}
	
	
}
