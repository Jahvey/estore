package com.jason;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class MyJson
 */

public class MyJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet init complete!");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String str=request.getParameter("jsonStr");
		//java.net.URLEncoder.encode(str, "UTF-8");
		List<Student> list = new ArrayList<Student>();
		Gson gson = new Gson();
	    list= gson.fromJson(str,new TypeToken<ArrayList<Student>>() {
			}.getType());
	    for(Student stu:list){
	    	System.out.println(stu.getName()+":"+stu.getAge()+":"+stu.getSex());
	    	out.write("receive");
	    	out.close();
	    }
		
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
