package com.itheima.estore.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.estore.domain.Category;
import com.itheima.estore.service.CategoryService;
import com.itheima.estore.utils.BaseServlet;
/**
 * 分类模块的Servlet
 * @author jiangtao
 *
 */
public class CategoryServlet extends BaseServlet {

	/**
	 * 查询所有分类的执行的方法:findAll
	 */
	public String findAll(HttpServletRequest req,HttpServletResponse resp){
		// 调用业务层代码:
		CategoryService categoryService = new CategoryService();
		List<Category> list = categoryService.findAll();
		// 页面跳转
		req.setAttribute("list", list);
		return  "/jsps/left.jsp";
	}
}
