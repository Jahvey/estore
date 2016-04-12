package com.itheima.estore.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.estore.domain.Category;
import com.itheima.estore.service.CategoryService;
import com.itheima.estore.utils.BaseServlet;
import com.itheima.estore.utils.UUIDUtils;
/**
 * 后台分类管理的Servlet
 * @author jiangtao
 *
 */
public class AdminCategoryServlet extends BaseServlet {
	/**
	 * 后台删除分类的方法:
	 */
	public String delete(HttpServletRequest req,HttpServletResponse resp){
		// 接收cid:
		String cid = req.getParameter("cid");
		// 调用业务层
		CategoryService categoryService = new CategoryService();
		categoryService.delete(cid);
		return findAll(req, resp);
	}
	
	/**
	 * 后台修改分类的方法:
	 */
	public String update(HttpServletRequest req,HttpServletResponse resp){
		// 接收数据:
		String cid = req.getParameter("cid");
		String cname = req.getParameter("cname");
		// 封装数据:
		Category category = new Category();
		category.setCid(cid);
		category.setCname(cname);
		// 调用业务层代码:
		CategoryService categoryService = new CategoryService();
		categoryService.update(category);
		// 页面跳转：
		return findAll(req, resp);
	}
	/**
	 * 后台修改分类页面跳转到修改页面方法:
	 */
	public String updateUI(HttpServletRequest req,HttpServletResponse resp){
		// 接收参数:
		String cid = req.getParameter("cid");
		// 调用业务层的代码:
		CategoryService categoryService = new CategoryService();
		Category category = categoryService.findByCid(cid);
		// 页面跳转:
		req.setAttribute("category", category);
		return "/adminjsps/admin/category/mod.jsp";
	}
	
	/**
	 * 后台完成保存分类的操作:
	 */
	public String save(HttpServletRequest req,HttpServletResponse resp){
		// 接收参数：
		String cname = req.getParameter("cname");
		// 封装对象:
		Category category = new Category();
		category.setCid(UUIDUtils.getUUID());
		category.setCname(cname);
		// 调用业务层:
		CategoryService categoryService = new CategoryService();
		categoryService.save(category);
		
		// 页面跳转:
		return findAll(req,resp);
	}
	
	/**
	 * 后后台跳转到添加页面的方法:
	 */
	public String saveUI(HttpServletRequest req,HttpServletResponse resp){
		return "/adminjsps/admin/category/add.jsp";
	}
	
	
	/**
	 * 后台查询所有分类的方法:
	 */
	public String findAll(HttpServletRequest req,HttpServletResponse resp){
		// 调用业务层代码:
		CategoryService categoryService = new CategoryService();
		List<Category> list = categoryService.findAll();
		// 页面跳转:
		req.setAttribute("list", list);
		return "/adminjsps/admin/category/list.jsp";
	}
}
