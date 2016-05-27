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
import com.itheima.redbaby.vo.AddressDetail;

/**
 * 保存地址 POST /addresssave
 * 
 * @author liu
 * 
 */
public class AaddressSaveServlet extends HttpServlet {

	private static final long serialVersionUID = -6993477605633133236L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int aid = 0;
		if (id != null) {
			aid = Integer.parseInt(id);
		}
		String name = req.getParameter("name");
		String phonenumber = req.getParameter("phonenumber");
		String fixedtel = req.getParameter("fixedtel");
		String[] areaids = req.getParameter("areaid").split(",");
		String areadetail = req.getParameter("areadetail");
		String zipcode = req.getParameter("zipcode");

		int provinceid = Integer.parseInt(areaids[0]);
		int cityid = Integer.parseInt(areaids[1]);
		int areaid = Integer.parseInt(areaids[2]);
		AddressDetail detail = new AddressDetail(0, name, phonenumber, fixedtel, provinceid, cityid, areaid,
				areadetail, zipcode);
		System.out.println(detail);
		if (aid > 0) {
			detail.setId(aid);
			AddressListServlet.EditAddress(detail);
		} else {
			AddressListServlet.addAddress(detail);
		}
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "addresssave");
		outMap.put("addresslist", AddressListServlet.getAddresslist());
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
