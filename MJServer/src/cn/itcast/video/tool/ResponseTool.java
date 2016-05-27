package cn.itcast.video.tool;

import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class ResponseTool {
	public static final String CONTENT_TYPE_XML = "text/xml;charset=UTF-8";
	public static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";
	public static final String CONTENT_TYPE_PLAIN = "text/plain;charset=UTF-8";
	public static final int ERROR_CODE_INVALID = HttpServletResponse.SC_BAD_REQUEST;
	public static final int ERROR_CODE_NOT_FOUND = HttpServletResponse.SC_NOT_FOUND;
	public static final int ERROR_CODE_INTERNAL = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
	public static final String ERROR_MESSAGE_INVALID = "请求有问题";
	public static final String ERROR_MESSAGE_NOT_FOUND = "找不到资源";
	public static final String ERROR_MESSAGE_INTERNAL = "服务器内部错误";
	/**
	 * 写数据给客户端
	 * @param content 内容
	 * @param contentType 内容类型
	 */
	public static void write(String content, String contentType) throws Exception  {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置编码和数据格式
		response.setContentType(contentType);
		Writer writer = response.getWriter();
		writer.write(content);
		writer.flush();
		writer.close();
	}
	public static void writeXML(String content) throws Exception  {
		write(content, CONTENT_TYPE_XML);
	}	
	public static void writeJSON(String content) throws Exception  {
		write(content, CONTENT_TYPE_JSON);
	}
	
	/**
	 * 写数据给客户端
	 * @param content 内容
	 * @param contentType 内容类型
	 * @param erroCode 错误码
	 * @param errorMsg 错误信息
	 */
	public static void writeError(String content, String contentType, int erroCode, String errorMsg) throws Exception  {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendError(erroCode, errorMsg);
		// 设置编码和数据格式
		write(content, contentType);
	}
	public static void writeErrorXML(String content, int erroCode, String errorMsg) throws Exception  {
		writeError(content, CONTENT_TYPE_XML, erroCode, errorMsg);
	}	
	public static void writeErrorJSON(String content, int erroCode, String errorMsg) throws Exception  {
		writeError(content, CONTENT_TYPE_JSON, erroCode, errorMsg);
	}
}
