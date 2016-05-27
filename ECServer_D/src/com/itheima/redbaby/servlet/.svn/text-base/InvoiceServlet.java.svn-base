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
import com.itheima.redbaby.vo.Invoice;

/**
 * 发票 
 * /invoice
 * @author liu
 * 
 */
public class InvoiceServlet extends HttpServlet {

	private static final long serialVersionUID = -926826439124944471L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "invoice");
		List<Invoice> invoices = new ArrayList<Invoice>();
		invoices.add(new Invoice(1, "图书"));
		invoices.add(new Invoice(1, "音响"));
		invoices.add(new Invoice(1, "游戏"));

		outMap.put("invoice", invoices);

		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
