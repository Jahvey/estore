package com.itheima.estore.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.itheima.estore.domain.Book;
import com.itheima.estore.domain.Order;
import com.itheima.estore.domain.OrderItem;
import com.itheima.estore.utils.JDBCUtils;

/**
 * 订单模块DAO的代码
 * 
 * @author jiangtao
 * 
 */
public class OrderDao {

	/**
	 * 保存订单
	 * 
	 * @param conn
	 * @param order
	 */
	public void save(Connection conn, Order order) {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into orders values (?,?,?,?,?,?)";
		Object[] params = { order.getOid(), order.getTotal(),
				order.getOrdertime(), order.getState(), order.getAddress(),
				order.getUser().getUid() };
		try {
			queryRunner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * 保存订单项
	 * 
	 * @param conn
	 * @param orderItem
	 */
	public void save(Connection conn, OrderItem orderItem) {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into orderitem values (?,?,?,?,?)";
		Object[] params = { orderItem.getItemid(), orderItem.getCount(),
				orderItem.getSubtotal(), orderItem.getBook().getBid(),
				orderItem.getOrder().getOid() };
		try {
			queryRunner.update(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * DAO根据用户的ID查询订单
	 * 
	 * @param uid
	 * @return
	 */
	public List<Order> findByUid(String uid) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from orders where uid = ? order by ordertime desc";
		List<Order> list;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Order>(
					Order.class), uid);
			// 遍历获得每个订单:
			for (Order order : list) {
				sql = "SELECT * FROM orderitem o,book b WHERE o.bid = b.bid AND o.oid = ?";
				List<Map<String, Object>> oList = queryRunner.query(sql,
						new MapListHandler(), order.getOid());
				// 遍历oList获得每个Map：每个Map代表每条记录.
				for (Map<String, Object> map : oList) {
					// 先封装Book对象:
					Book book = new Book();
					BeanUtils.populate(book, map);
					OrderItem orderItem = new OrderItem();
					BeanUtils.populate(orderItem, map);
					orderItem.setBook(book);
					// 将订单项封装到订单中:
					order.getOrderItems().add(orderItem);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}

	/**
	 * DAO中根据订单ID查询订单的方法:
	 * 
	 * @param oid
	 * @return
	 */
	public Order findByOid(String oid) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from orders where oid = ?";
		Order order;
		try {
			order = queryRunner.query(sql, new BeanHandler<Order>(Order.class),
					oid);
			sql = "select * from orderitem o,book b where o.bid=b.bid and o.oid = ?";
			List<Map<String, Object>> oList = queryRunner.query(sql,
					new MapListHandler(), oid);
			for (Map<String, Object> map : oList) {
				Book book = new Book();
				BeanUtils.populate(book, map);
				OrderItem orderItem = new OrderItem();
				BeanUtils.populate(orderItem, map);
				orderItem.setBook(book);

				order.getOrderItems().add(orderItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return order;
	}

	/**
	 * 修改订单的方法:
	 * 
	 * @param order
	 */
	public void update(Order order) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update orders set total = ?,ordertime = ? ,state = ?,address = ? where oid = ?";
		Object[] params = { order.getTotal(), order.getOrdertime(),
				order.getState(), order.getAddress(), order.getOid() };
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * DAO中查询所有订单的方法:
	 * @return
	 */
	public List<Order> findAll(){
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from orders order by ordertime desc";
		List<Order> list;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Order>(Order.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}
	/*public List<Order> findAll() {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from orders order by ordertime desc";
		List<Order> list;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Order>(Order.class));
			for (Order order : list) {
				sql = "select * from orderitem o,book b where o.bid = b.bid and o.oid = ?";
				List<Map<String,Object>> oList = queryRunner.query(sql, new MapListHandler(), order.getOid());
				for (Map<String, Object> map : oList) {
					Book book= new Book();
					BeanUtils.populate(book, map);
					
					OrderItem orderItem = new OrderItem();
					BeanUtils.populate(orderItem, map);
					orderItem.setBook(book);
					
					order.getOrderItems().add(orderItem);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}*/

	/**
	 * DAO中根据状态查询订单的方法:
	 * @param state
	 * @return
	 */
	public List<Order> findByState(int state) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from orders where state = ? order by ordertime desc";
		List<Order> list;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Order>(Order.class),state);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}
	/*public List<Order> findByState(int state) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from orders where state = ? order by ordertime desc";
		List<Order> list;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Order>(Order.class),state);
			for (Order order : list) {
				sql = "select * from orderitem o,book b where o.bid = b.bid and o.oid = ?";
				List<Map<String,Object>> oList = queryRunner.query(sql, new MapListHandler(), order.getOid());
				for (Map<String, Object> map : oList) {
					Book book= new Book();
					BeanUtils.populate(book, map);
					
					OrderItem orderItem = new OrderItem();
					BeanUtils.populate(orderItem, map);
					orderItem.setBook(book);
					
					order.getOrderItems().add(orderItem);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return list;
	}*/

	/**
	 * DAO中加载订单项的方法:
	 * @param oid
	 * @return
	 */
	public List<OrderItem> findOrderItems(String oid) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from orderitem o,book b where o.bid = b.bid and o.oid = ?";
		List<OrderItem> list = new ArrayList<OrderItem>();
		try {
			List<Map<String,Object>> oList = queryRunner.query(sql, new MapListHandler(), oid);
			for (Map<String, Object> map : oList) {
				Book book= new Book();
				BeanUtils.populate(book, map);
				
				OrderItem orderItem = new OrderItem();
				BeanUtils.populate(orderItem, map);
				orderItem.setBook(book);
				
				list.add(orderItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
