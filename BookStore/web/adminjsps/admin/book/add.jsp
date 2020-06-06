<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {background: rgb(254,238,189);}
</style>
  </head>
  
  <body>
    <h1>添加图书</h1>
    <p style="font-weight: 900; color: red">${msg }</p>
    <form action="<c:url value='/AdminAddBookServlet' />" method="post" enctype="multipart/form-data">
    	图书名称：<input style="width: 150px; height: 20px;" type="text" name="bname"/><br/>
    	图书图片：<input style="width: 223px; height: 20px;" type="file" name="image"/><br/>
    	图书单价：<input style="width: 150px; height: 20px;" type="text" name="price"/><br/>
    	图书作者：<input style="width: 150px; height: 20px;" type="text" name="author"/><br/>
    	图书分类：<select style="width: 150px; height: 20px;" name="cid">
    	<c:forEach items="${categoryList}" var="c">
    		<option value="${c.cid}">${c.cname}</option>
		</c:forEach>

    	</select>
    	<br/>
    	<input type="submit" value="添加图书"/>
    </form>
  </body>
</html>
