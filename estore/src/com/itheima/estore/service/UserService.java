package com.itheima.estore.service;

import com.itheima.estore.dao.UserDao;
import com.itheima.estore.domain.User;
import com.itheima.estore.utils.MailUtils;
import com.itheima.estore.utils.UUIDUtils;
/**
 * 用户模块业务层的类
 * @author jiangtao
 *
 */
public class UserService {

	/**
	 * 业务层注册用户执行的方法;
	 * @param user
	 */
	public void regist(User user) {
		// 插入数据库.
		UserDao userDao = new UserDao();
		user.setUid(UUIDUtils.getUUID());
		user.setState(0);// 0 :未激活		1:已激活.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		// 发送激活邮件.
		MailUtils.sendMail(user.getEmail(),code);
	}

	/**
	 * 业务层的根据用户查询用户的方法:
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		UserDao userDao = new UserDao();
		return userDao.findByUsername(username);
	}

	/**
	 * 业务层根据激活码查询用户的方法
	 * @param code
	 * @return
	 */
	public User findByCode(String code) {
		UserDao userDao = new UserDao();
		return userDao.findByCode(code);
	}

	/**
	 * 修改用户的方法
	 * @param user
	 */
	public void update(User user) {
		UserDao userDao = new UserDao();
		userDao.update(user);
	}

	/**
	 * 业务层的登录的方法
	 * @param user
	 * @return
	 */
	public User login(User user) {
		UserDao userDao = new UserDao();
		return userDao.findUsernameAndPassword(user);
	}

}
