package com.itheima.estore.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.estore.domain.Book;
import com.itheima.estore.domain.PageBean;
import com.itheima.estore.service.BookService;
import com.itheima.estore.utils.BaseServlet;
/**
 * 图书模块的Servlet
 * @author jiangtao
 *
 */
public class BookServlet extends BaseServlet {
	/**
	 * 根据图书的ID查询图书:findByBid
	 */
	public String findByBid(HttpServletRequest req,HttpServletResponse resp){
		// 1.接收bid:
		String bid = req.getParameter("bid");
		// 2.调用业务层
		BookService bookService = new BookService();
		Book book = bookService.findByBid(bid);
		// 3.页面跳转
		req.setAttribute("book", book);
		return "/jsps/book/desc.jsp";
	}
	/**
	 * 根据分类查询图书的方法:findByCid
	 */
	public String findByCid(HttpServletRequest req,HttpServletResponse resp){
		// 1.接收分类ID;
		String cid = req.getParameter("cid");
		// 2.调用业务层代码 ：
		BookService bookService = new BookService();
		List<Book> list = bookService.findByCid(cid);
		// 3.页面跳转:
		req.setAttribute("list", list);
		return "/jsps/book/list.jsp";
	}
	
	/**
	 * 分页查询所有图书的方法:findByPage
	 */
	public String findByPage(HttpServletRequest req,HttpServletResponse resp){
		// 1.接收参数:
		int currPage = Integer.parseInt(req.getParameter("currPage"));
		// 2.调用业务层代码:
		BookService bookService = new BookService();
		PageBean<Book> pageBean = bookService.findByPage(currPage);
		// 3.页面跳转:
		req.setAttribute("pageBean", pageBean);
		return "/jsps/book/book_list.jsp";
	}
}
