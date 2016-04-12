package com.itheima.estore.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
 * 修改图书的Servlet:
 * 
 * @author jiangtao
 * 
 */
public class UpdateBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文件上传:
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(
				diskFileItemFactory);
		Map<String, String> map = new HashMap<String, String>();
		String path = this.getServletContext().getRealPath("/book_img");
		Book book = new Book();
		String fileName = null;
		String uuidFileName = null;
		try {
			List<FileItem> list = fileUpload.parseRequest(request);
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					// 是普通项:
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					map.put(name, value);
					System.out.println(map);
				} else {
					// 文件上传项:
					fileName = fileItem.getName();
					if(fileName != null && !"".equals(fileName)){
						// 删除原有文件:
						String image = map.get("image");
						int idx = image.lastIndexOf("/");
						String name = image.substring(idx + 1);
						File file = new File(path + "\\" + name);
						if (file.exists()) {
							file.delete();
						}
						
						InputStream is = fileItem.getInputStream();
						uuidFileName = UUIDUtils.getUUID() + "_" + fileName;
						OutputStream os = new FileOutputStream(path + "//"
								+ uuidFileName);
						byte[] b = new byte[1024];
						int len = 0;
						while ((len = is.read(b)) != -1) {
							os.write(b, 0, len);
						}
						is.close();
						os.close();
					}
					
				}
			}
			

			BeanUtils.populate(book, map);
			if(fileName != null && !"".equals(fileName)){
				book.setImage("book_img/" + uuidFileName);
			}
			// 修改数据到数据库:
			BookService bookService = new BookService();
			bookService.update(book);
			// 页面跳转
			request.getRequestDispatcher("/adminBookServlet?method=findAll")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
