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
import com.itheima.redbaby.vo.Topic;

/**
 * 促销快报
 * 
 * @author liu
 * 
 */
public class TopicServlet extends HttpServlet {

	private static final long serialVersionUID = -2635949087300046169L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "topic");
		List<Topic> topics = new ArrayList<Topic>();
		for (int i = 0; i < 15; i++) {
			Topic vo = new Topic(10000 + i, "雅培金装" + i, Constant.pic_url.concat("image" + ((i%3) + 1) + ".png"));
			topics.add(vo);
		}
		outMap.put("topic", topics);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
