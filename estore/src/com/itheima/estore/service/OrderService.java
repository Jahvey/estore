package com.itheima.estore.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.itheima.estore.dao.OrderDao;
import com.itheima.estore.domain.Order;
import com.itheima.estore.domain.OrderItem;
import com.itheima.estore.utils.JDBCUtils;

/**
 * 订单模块业务层代码
 * @author jiangtao
 *
 */
public class OrderService {

	/**
	 * 保存订单的方法:
	 * @param order
	 */
	public void save(Order order) {
		// 获得连接:
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			OrderDao orderDao = new OrderDao();
			// 插入订单表:
			orderDao.save(conn,order);
			// 插入订单项表:
			for (OrderItem orderItem : order.getOrderItems()) {
				orderDao.save(conn,orderItem);
			}
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 业务层根据用户的ID查询订单
	 * @param uid
	 * @return
	 */
	public List<Order> findByUid(String uid) {
		OrderDao orderDao = new OrderDao();
		return orderDao.findByUid(uid);
	}

	/**
	 * 业务层根据订单ID查询订单的方法
	 * @param oid
	 * @return
	 */
	public Order findByOid(String oid) {
		OrderDao orderDao = new OrderDao();
		return orderDao.findByOid(oid);
	}

	/**
	 * 业务层修改订单的方法:
	 * @param order
	 */
	public void update(Order order) {
		OrderDao orderDao = new OrderDao();
		orderDao.update(order);
	}

	/**
	 * 业务层查询所有订单的方法
	 * @return
	 */
	public List<Order> findAll() {
		OrderDao orderDao = new OrderDao();
		return orderDao.findAll();
	}

	/**
	 * 业务层根据订单状态查询订单的方法
	 * @param state
	 * @return
	 */
	public List<Order> findByState(int state) {
		OrderDao orderDao = new OrderDao();
		return orderDao.findByState(state);
	}

	/**
	 * 业务层查询订单项的方法:
	 * @param oid
	 * @return
	 */
	public List<OrderItem> findOrderItems(String oid) {
		OrderDao orderDao = new OrderDao();
		return orderDao.findOrderItems(oid);
	}

}
