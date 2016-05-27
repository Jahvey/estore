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
import com.itheima.redbaby.vo.Comment;


/**
 * 商品评论
 * GET	/product/comment
 * @author liu
 *
 */
public class CommentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1702975224403335826L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "product_comment");
		List<Comment> comments = new ArrayList<Comment>();
		
		
		for (int i = 0; i < 10; i++) {
			Comment vo = new Comment("东西不错", "东西不错", "张三", "2001-12-24 23:00:00");
			comments.add(vo);
		}
		outMap.put("comment", comments);
		outMap.put("list_count", comments.size());
		
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
