package com.itheima.estore.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.itheima.estore.domain.Book;
import com.itheima.estore.service.BookService;
import com.itheima.estore.utils.UUIDUtils;
/**
 * 添加图书：文件上传的Servlet.
 * @author jiangtao
 *
 */
public class SaveBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.文件上传:
		// 1.1创建磁盘文件项工厂.
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// 1.2创建核心解析类:
		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		// 定义Map集合:封装普通项的数据.
		Map<String,String> map = new HashMap<String,String>();
		// 定义文件名 ：
		String fileName = null;
		// 1.3解析request返回一个List集合.
		try {
			List<FileItem> list = fileUpload.parseRequest(request);
			// 1.4获得每个文件项:
			for (FileItem fileItem : list) {
				// 1.5判断文件项是普通项还是文件上传项:
				if(fileItem.isFormField()){
					// 普通项:
					// 获得普通项名称:
					String name = fileItem.getFieldName();  // bname  price
					// 获得普通项的值:
					String value = fileItem.getString("UTF-8"); // 封神演义  39
					map.put(name, value);
					// System.out.println(map);
				}else{
					// 文件上传项:
					// 获得文件名:
					fileName = fileItem.getName();
					// 获得文件输入流:
					InputStream is = fileItem.getInputStream();
					// 文件上传:
					// 获得文件上传路径:
					String path = this.getServletContext().getRealPath("/book_img");
					OutputStream os = new FileOutputStream(path+"\\"+fileName);
					byte[] b = new byte[1024];
					int len = 0;
					while((len = is.read(b))!=-1){
						os.write(b, 0, len);
					}
					is.close();
					os.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		// 2.记录插入:调用业务层代码.
		Book book = new Book();
		try {
			BeanUtils.populate(book, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		book.setBid(UUIDUtils.getUUID());
		book.setIsdel(0);
		book.setImage("book_img/"+fileName);
		BookService bookService = new BookService();
		bookService.save(book);
		// 页面跳转:
		request.getRequestDispatcher("/adminBookServlet?method=findAll").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
