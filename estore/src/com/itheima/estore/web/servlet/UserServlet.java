package com.itheima.estore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.estore.domain.User;
import com.itheima.estore.service.UserService;
import com.itheima.estore.utils.BaseServlet;
/**
 * 用户模块的Servlet:
 * @author jiangtao
 *
 */
public class UserServlet extends BaseServlet {
	
	/**
	 * 用户退出的方法:logout
	 * @throws IOException 
	 */
	public String logout(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		// 获得session
		HttpSession session = req.getSession();
		// 销毁session:过期: 非正常关闭服务器: 调用session.invalidate();
		session.invalidate();
		// 页面跳转:
		resp.sendRedirect(req.getContextPath()+"/jsps/main.jsp");
		return null;
	}
	
	/**
	 * 用户登录的方法：login
	 * @throws IOException 
	 */
	public String login(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		/**
		 * 1.接收参数:
		 * 2.封装参数:
		 * 3.调用service查询:
		 * 4.页面跳转
		 */
		// 1.接收参数:
		Map<String,String[]> map = req.getParameterMap();
		// 2.封装数据 ：
		User user = new User();
		try {
			BeanUtils.populate(user, map);
			// 3.调用业务层:
			UserService userService = new UserService();
			User existUser = userService.login(user);
			// 4.页面跳转:
			if(existUser == null){
				// 登录失败:
				req.setAttribute("msg", "用户名或密码错误！或者用户未激活！");
				return "/jsps/user/login.jsp";
			}else{
				// 登录成功:
				req.getSession().setAttribute("existUser", existUser);
				resp.sendRedirect(req.getContextPath()+"/jsps/main.jsp");
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 用户激活的方法:active
	 */
	public String active(HttpServletRequest req,HttpServletResponse resp){
		/**
		 * 接收激活码:
		 * 根据激活码查询用户:
		 * 	* 查询到:修改用户状态
		 * 	* 查询不到:跳转到其他的页面.
		 */
		// 接收参数
		String code = req.getParameter("code");
		// 根据激活码查询用户:
		UserService userService = new UserService();
		User user = userService.findByCode(code);
		// 判断用户是否存在:
		if(user == null){
			// 用户不存在:
			req.setAttribute("msg", "激活失败!重新激活!");
		}else{
			// 用户存在
			// 修改用户的状态:
			user.setState(1);
			user.setCode(null);
			userService.update(user);
			req.setAttribute("msg", "激活成功!请去登录!");
		}
		return "/jsps/msg.jsp";
	}
	
	/**
	 * 异步校验用户名是否存在的方法:checkUsername
	 * @throws IOException 
	 */
	public String checkUsername(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		/**
		 * 1.接收用户名.
		 * 2.去数据库进行查询
		 * 	* 存在：用户名已经存在.
		 * 	* 不存在:用户名可以使用.
		 */
		// 接收参数
		String username = req.getParameter("username");
		// 调用Service:
		UserService userService = new UserService();
		User user = userService.findByUsername(username);
		// 判断:
		if(user == null){
			// 用户不存在:用户名可以使用.
			resp.getWriter().println(1);
		}else{
			// 用户已经存在:用户名不可使用.
			resp.getWriter().println(2);
		}
		return null;
	}

	/**
	 * 注册用户执行的方法:regist
	 */
	public String regist(HttpServletRequest req,HttpServletResponse resp){
		/**
		 * 1.接收数据.
		 * 2.封装数据.
		 * 3.调用业务层代码.
		 * 4.页面跳转.
		 */
		// 1.接收参数:
		Map<String,String[]> map = req.getParameterMap();
		// 2.封装数据:
		User user = new User();
		try {
			BeanUtils.populate(user, map);
			// 3.调用业务层代码完成注册.
			UserService userService = new UserService();
			userService.regist(user);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		req.setAttribute("msg", "注册成功!请去邮箱激活!");
		return "/jsps/msg.jsp";
	}
}
