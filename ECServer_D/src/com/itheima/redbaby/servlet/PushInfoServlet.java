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
public class PushInfoServlet extends HttpServlet {

	private static final long serialVersionUID = -2635949087300046169L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "topic");
		List<Topic> topics = new ArrayList<Topic>();
		
		Topic vo = new Topic(10000, "想和我约会吗？" , Constant.pic_url.concat("e.png"));
		topics.add(vo);
		
		Topic vo1 = new Topic(10000, "想和我约会吗？" , Constant.pic_url.concat("f.png"));
		topics.add(vo1);
		
		Topic vo2 = new Topic(10000, "想和我约会吗？" , Constant.pic_url.concat("g.png"));
		topics.add(vo2);
		
		outMap.put("topic", topics);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
