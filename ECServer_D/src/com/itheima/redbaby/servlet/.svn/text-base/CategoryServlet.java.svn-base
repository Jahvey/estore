package com.itheima.redbaby.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.redbaby.config.Constant;
import com.itheima.redbaby.service.CommonUtil;
import com.itheima.redbaby.vo.Category;

/**
 * 分类及详情
 * 
 * GET /category
 * 
 * @author liu
 */
public class CategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 3215914888952550001L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "category");

		List<Category> productlist = new ArrayList<Category>();
		Category c1 = new Category(101, "孕妈专区", 0, Constant.pic_url.concat(1 + ".png"), "孕产营养品/奶粉", false);
		productlist.add(c1);

		Category c2 = new Category(102, "营养食品", 0, Constant.pic_url.concat(1 + ".png"), "奶粉", false);
		productlist.add(c2);

		Category c3 = new Category(103, "成长用品", 0, Constant.pic_url.concat(1 + ".png"), "尿裤/纸巾  婴幼儿洗浴护肤", true);
		productlist.add(c3);

		Category c4 = new Category(104, "玩具童车", 0, Constant.pic_url.concat(1 + ".png"), "启智玩具  婴儿车", true);
		productlist.add(c4);

		Category c5 = new Category(105, "宝宝靓装", 0, Constant.pic_url.concat(1 + ".png"), "男童服饰  女童服饰", true);
		productlist.add(c5);
		Category c6 = new Category(106, "图书", 0, Constant.pic_url.concat(1 + ".png"), "孕产妈妈  育儿/亲子", true);
		productlist.add(c6);

		Category c7 = new Category(10101, "孕产营养品/奶粉", 101, "", "孕产妈妈  育儿/亲子", false);
		Category c8 = new Category(10102, "防辐射", 101, "", "孕产妈妈  育儿/亲子", false);
		productlist.add(c7);
		productlist.add(c8);

		Category c9 = new Category(10101, "奶粉", 102, "", "", false);
		Category c10 = new Category(10102, "辅食", 102, "", "", false);
		productlist.add(c9);
		productlist.add(c10);

		Category c11 = new Category(1010101, "妈妈营养品", 10101, "", "", true);
		Category c12 = new Category(1010102, "妈妈奶粉", 10101, "", "", true);
		productlist.add(c11);
		productlist.add(c12);

		Category c13 = new Category(1010201, "防辐射服", 10102, "", "", true);
		Category c14 = new Category(1010202, "防辐射眼镜", 10102, "", "", true);
		
		productlist.add(c13);
		productlist.add(c14);

		outMap.put("category", productlist);
		outMap.put("version", "2");
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
