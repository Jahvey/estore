package com.itheima.estore.service;

import java.util.List;

import com.itheima.estore.dao.BookDao;
import com.itheima.estore.domain.Book;
import com.itheima.estore.domain.PageBean;

/**
 * 图书模块的业务层代码
 * @author jiangtao
 *
 */
public class BookService {

	/**
	 * 业务层分页查询的方法
	 * @param currPage
	 * @return
	 */
	public PageBean<Book> findByPage(int currPage) {
		PageBean<Book> pageBean = new PageBean<Book>();
		// 设置当前页数:
		pageBean.setCurrPage(currPage);
		// 设置每页显示记录数:
		int pageSize = PageBean.PAGESIZE;
		pageBean.setPageSize(pageSize);
		// 设置总记录数:
		BookDao bookDao = new BookDao();
		int totalCount = bookDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 每页显示数据集合:
		int begin = (currPage - 1) * pageSize;
		List<Book> list = bookDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 业务层的根据分类的ID查询图书
	 * @param cid
	 * @return
	 */
	public List<Book> findByCid(String cid) {
		BookDao bookDao = new BookDao();
		return bookDao.findByCid(cid);
	}

	/**
	 * 业务层根据图书的ID查询图书的方法
	 * @param bid
	 * @return
	 */
	public Book findByBid(String bid) {
		BookDao bookDao = new BookDao();
		return bookDao.findByBid(bid);
	}

	/**
	 * 业务层查询所有图书的方法
	 * @return
	 */
	public List<Book> findAll() {
		BookDao bookDao = new BookDao();
		return bookDao.findAll();
	}

	/**
	 * 业务层保存图书的方法:
	 * @param book
	 */
	public void save(Book book) {
		BookDao bookDao = new BookDao();
		bookDao.save(book);
	}

	/**
	 * 业务层修改图书的方法:
	 * @param book
	 */
	public void update(Book book) {
		BookDao bookDao = new BookDao();
		bookDao.update(book);
	}

	/**
	 * 业务层查询已经下架的图书
	 * @return
	 */
	public List<Book> findByState() {
		BookDao bookDao = new BookDao();
		return bookDao.findByState();
	}

}
