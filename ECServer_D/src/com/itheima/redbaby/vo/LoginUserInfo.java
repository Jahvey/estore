package com.itheima.redbaby.vo;

/**
 * 登录User信息 
 * @author liu
 *
 */
public class LoginUserInfo {
	private int userId;
	private String usersession;

	public LoginUserInfo() {
	}

	public LoginUserInfo(int userId, String usersession) {
		super();
		this.userId = userId;
		this.usersession = usersession;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsersession() {
		return usersession;
	}

	public void setUsersession(String usersession) {
		this.usersession = usersession;
	}

}
