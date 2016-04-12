package com.itheima.estore.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送的工具类:
 * @author jiangtao
 *
 */
public class MailUtils {
	
	public static void sendMail(String to,String code){
		/**
		 * 1.创建一个Session对象.
		 * 
		 * 2.创建一个代表邮件的对象Message.
		 * 
		 * 3.Transport对象中send方法发送邮件
		 */
		// 1.与服务器连接上.
		Properties props = new Properties();
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("service@estore.com", "111");
			}
			
		});
		// 2.编写一个邮件:
		Message message = new MimeMessage(session);
		// 设置发件人:
		try {
			message.setFrom(new InternetAddress("service@estore.com"));
			// 设置收件人:
			// TO:收件人	  CC:抄送        BCC:密送
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			// 设置主题:
			message.setSubject("ESTORE购物天堂官方发送的激活邮件");
			// 设置正文:
			message.setContent("<h1>来自ESTORE购物天堂激活邮件:激活请点击以下链接</h1><h3><a href='http://192.168.16.39:8080/estore/userServlet?method=active&code="+code+"'>http://192.168.16.39:8080/estore/userServlet?method=active&code="+code+"</a></h3>", "text/html;charset=UTF-8");
		// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
