package cn.itcast.video.aciton;

import java.io.BufferedReader;

import org.apache.struts2.ServletActionContext;

import cn.itcast.video.service.OrderResultService;

@SuppressWarnings("serial")
public class OrderAction extends BaseAction <OrderResultService> {
	public OrderAction()
	{
		service = new OrderResultService();
	}
	
	/**
	 * 处理订单信息
	 */
	public void order() throws Exception 
	{
		BufferedReader reader = ServletActionContext.getRequest().getReader();
		String line = null;
		StringBuilder sb = new StringBuilder();
        while((line = reader.readLine()) != null) {
        	sb.append(line);
        }
        if (sb.length() > 0) {
        	service.setSuccess(true);
        	service.setMessage("成功接收到订单数据");
            System.out.println("订单数据：" + sb);
        } else {
        	service.setSuccess(false);
        	service.setMessage("没有收到订单数据");
        }

		write();
	}
}
