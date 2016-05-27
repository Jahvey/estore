package cn.itcast.video.aciton;

import cn.itcast.video.service.BaseResultService;
import cn.itcast.video.tool.ResponseTool;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction <T extends BaseResultService> extends ActionSupport {
	protected String type = "JSON";
	protected T service;
	public void setType(String type) {
		this.type = type;
	}
	
	public void write() throws Exception  
	{
		if ("XML".equals(type)) {
			ResponseTool.writeXML(service.xmlResult());
		} else {
			ResponseTool.writeJSON(service.jsonResult());
		}
	}
}
