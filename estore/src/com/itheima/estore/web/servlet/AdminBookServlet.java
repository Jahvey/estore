package com.itheima.estore.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.estore.domain.Book;
import com.itheima.estore.domain.Category;
import com.itheima.estore.service.BookService;
import com.itheima.estore.service.CategoryService;
import com.itheima.estore.utils.BaseServlet;

public class AdminBookServlet extends BaseServlet {
	
	/**
	 * 图书上架的方法
	 */
	public String pushUp(HttpServletRequest req,HttpServletResponse resp){
		// 接收图书ID
		String bid = req.getParameter("bid");
		// 根据图书的ID查询图书
		BookService bookService = new BookService();
		Book book = bookService.findByBid(bid);
		book.setIsdel(0);
		bookService.update(book);
		// 修改图书状态
		return findAll(req, resp);
	}
	
	/**
	 * 查询已经下架的图书
	 */
	public String findByState(HttpServletRequest req,HttpServletResponse resp){
		BookService bookService = new BookService();
		List<Book> list= bookService.findByState();
		req.setAttribute("list", list);
		return "/adminjsps/admin/book/pushDown_list.jsp";
	}
	
	/**
	 * 图书下架的方法:
	 */
	public String pushDown(HttpServletRequest req,HttpServletResponse resp){
		// 接收bid:
		String bid = req.getParameter("bid");
		// 根据图书的ID查询图书:
		BookService bookService =new BookService();
		Book book = bookService.findByBid(bid);
		book.setIsdel(1);
		bookService.update(book);
		return findAll(req,resp);
	}
	
	/**
	 * 根据图书ID查询图书的方法:跳转到修改页面的方法
	 */
	public String findByBid(HttpServletRequest req,HttpServletResponse resp){
		// 接收图书的ID:
		String bid = req.getParameter("bid");
		// 根据图书ID查询图书:
		BookService bookService = new BookService();
		Book book = bookService.findByBid(bid);
		// 查询所有分类:
		CategoryService categoryService = new CategoryService();
		List<Category> list = categoryService.findAll();
		req.setAttribute("book", book);
		req.setAttribute("list", list);
		return "/adminjsps/admin/book/desc.jsp";
	}
	
	/**
	 * 跳转到添加页面的方法:
	 */
	public String saveUI(HttpServletRequest req,HttpServletResponse resp){
		// 查询所有分类:
		CategoryService categoryService = new CategoryService();
		List<Category> list = categoryService.findAll();
		// 页面跳转:
		req.setAttribute("list", list);
		return "/adminjsps/admin/book/add.jsp";
	}
	
	/**
	 * 查询所有图书的方法:
	 */
	public String findAll(HttpServletRequest req,HttpServletResponse resp){
		// 调用业务层代码:
		BookService bookService = new BookService();
		List<Book> list = bookService.findAll();
		req.setAttribute("list", list);
		// 页面跳转:
		return "/adminjsps/admin/book/list.jsp";
	}
}
