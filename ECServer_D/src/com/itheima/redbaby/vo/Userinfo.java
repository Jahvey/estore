package com.itheima.redbaby.vo;

/**
 * 账户中心 UserInfo
 * @author liu
 *
 */
public class Userinfo {
	
	/**会员ID*/
	private int userId;
	
	/** 会员积分*/
	private int bonus;
	
	/** 会员等级 */
	private String level;
	
	/** session MD5*/
	private String usersession;
	
	/** 所下订单数*/
	private int ordercount;
	
	/** 收藏总数 */
	private int favoritescount;
	
	public Userinfo() {
	}

	public Userinfo(int userId, int bonus, String level, String usersession, int ordercount, int favoritescount) {
		super();
		this.userId = userId;
		this.bonus = bonus;
		this.level = level;
		this.usersession = usersession;
		this.ordercount = ordercount;
		this.favoritescount = favoritescount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getUsersession() {
		return usersession;
	}

	public void setUsersession(String usersession) {
		this.usersession = usersession;
	}

	public int getOrdercount() {
		return ordercount;
	}

	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}

	public int getFavoritescount() {
		return favoritescount;
	}

	public void setFavoritescount(int favoritescount) {
		this.favoritescount = favoritescount;
	}
	
}
