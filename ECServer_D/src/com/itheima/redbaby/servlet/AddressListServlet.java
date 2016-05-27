package com.itheima.redbaby.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
 * 地址列表 GET /addresslist
 * 
 * @author liu
 * 
 */
public class AddressListServlet extends HttpServlet {
	private static int i = 3;
	private static List<AddressDetail> addresslist;
	static {
		addresslist = new ArrayList<AddressDetail>();
		addresslist.add(new AddressDetail(0, "张三", "18601010000", "010-87654321", 110000, 110100, 110101, "长安街150号", "1000000"));
		addresslist.add(new AddressDetail(1, "李四", "18601010000", "010-87654320", 110000, 110100, 110107, "东北旺50号", "1000000"));
		Collections.sort(addresslist);
	}

	public static void addAddress(AddressDetail detail) {

		detail.setId(i++);
		addresslist.add(detail);
		Collections.sort(addresslist);
	}

	public static void EditAddress(AddressDetail detail) {
		DeleteAddress(detail.getId());

		addresslist.add(detail);
		Collections.sort(addresslist);
	}

	public static void DeleteAddress(int id) {
		AddressDetail d = null;
		for (AddressDetail add : addresslist) {
			if (add.getId() == id) {
				d = add;
			}
		}
		if (d != null) {
			addresslist.remove(d);
		}
		Collections.sort(addresslist);
	}

	public static List<AddressDetail> getAddresslist() {
		return addresslist;
	}

	private static final long serialVersionUID = 4767345235316181247L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "addresslist");
		outMap.put("addresslist", addresslist);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
