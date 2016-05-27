package cn.itcast.video.aciton;

import org.apache.struts2.ServletActionContext;

import cn.itcast.video.service.LoginResultService;

@SuppressWarnings("serial")
public class LoginAction  extends BaseAction <LoginResultService> {
	// 用户名
	static final String USERNAME = "123";
	// 密码
	static final String PWD = "123";
	private String username;
	private String pwd;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public LoginAction()
	{
		service = new LoginResultService();
	}
	
	/**
	 * 处理登录
	 */
	public void login() throws Exception {
		String method = ServletActionContext.getRequest().getMethod();
		if ("GET".equals(method)) { // GET需要对请求参数进行转码
			// 哈哈 --UTF-8转码--> %E%%DD --tomcat-ISO8859-1--> 乱码
			if(username != null) {
				byte[] bytes = username.getBytes("ISO8859-1");
				username = new String(bytes, "UTF-8");
			}
			
			if(pwd != null) {
				byte[] bytes = pwd.getBytes("ISO8859-1");
				pwd = new String(bytes, "UTF-8");
			}
		}
		System.out.println("用户名="+username+", 密码="+pwd);
		
		// 处理数据
		if (!USERNAME.equals(username)) { // 用户名不存在
			service.setSuccess(false);
			service.setMessage("用户名不存在");
		} else if (!PWD.equals(pwd)) { // 密码不正确
			service.setSuccess(false);
			service.setMessage("密码不正确");
		} else { // 用户名、密码正确
			service.setSuccess(true);
			service.setMessage("登录成功");
		}
		
		// 输出数据
		write();
	}
}
