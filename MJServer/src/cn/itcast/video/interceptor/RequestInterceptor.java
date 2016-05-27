package cn.itcast.video.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class RequestInterceptor extends AbstractInterceptor {//拦截器

	public String intercept(ActionInvocation invocation) throws Exception {
		checkUserAgent();
		return invocation.invoke();
	}
	
	private void checkUserAgent()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String method = request.getMethod();
		String ip = request.getRemoteHost();
		String agent = (String) request.getHeader("User-Agent");
		System.out.println("客户端信息：");
		System.out.println("请求方式:" + method + ", ip:" + ip + ", 环境:" + agent);
	}
}
