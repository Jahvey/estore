<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bookdesc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
		background: rgb(254,238,189);
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
<script type="text/javascript">
	function updateBook(){
		
		document.getElementById("form").action="${ pageContext.request.contextPath }/updateBookServlet";
		document.getElementById("form").submit();
	
	}
	
	function pushDown(){
		
		document.getElementById("form").action="${ pageContext.request.contextPath }/adminBookServlet?method=pushDown";
		document.getElementById("form").enctype="application/x-www-form-urlencoded";
		document.getElementById("form").submit();
	}
</script>
  </head>
  
  <body>
  <div> 
    <img src="${ pageContext.request.contextPath }/${ book.image }" width="130" height="150" border="0"/>
  </div>
  <form style="margin:20px;" id="form" action="" method="post" enctype="multipart/form-data">
  	<input type="hidden" name="bid" value="${book.bid }">
  	<input type="hidden" name="isdel" value="${book.isdel }">
  	<input type="hidden" name="image" value="${book.image }">
  	图书名称：<input type="text" name="bname" value="${ book.bname }"/><br/>
  	图书图片:<input  type="file" name="image"/><br/>
  	图书单价：<input type="text" name="price" value="${ book.price }"/><br/>
  	图书作者：<input type="text" name="author" value="${book.author }"/><br/>
  	图书分类：<select style="width: 150px; height: 20px;" name="cid">
  		<c:forEach items="${ list }" var="c">
     		<option value="${ c.cid }" <c:if test="${ c.cid == book.cid }">selected</c:if>>${ c.cname }</option>
    	</c:forEach>
    	</select><br/>
  	<input type="button"  value="下架" onclick="pushDown()"/>
  	<input type="button"  value="修改" onclick="updateBook()"/>
  </form>
  </body>
</html>
