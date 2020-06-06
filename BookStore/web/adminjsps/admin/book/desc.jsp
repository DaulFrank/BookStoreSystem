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
		  function setMethod(method) {
			var  ele = document.getElementById("method");
			ele.value = method;
		  }
	  </script>

  </head>
  
  <body>
  <div>
    <img src="<c:url value='/${book.image}'/>" border="0"/>
  </div>
  <form style="margin:20px;" id="form" action="<c:url value='/AdminBookServlet'/> " method="post">
	  <input type="hidden" name="method" value="" id = "method">
	  <input type="hidden" name="bid" value="${book.bid}">
	  <input type="hidden" name="image" value="${book.image}">
  	图书名称：<input type="text" name="bname" value="${book.bname}"/><br/>
  	图书单价：<input type="text" name="price" value="${book.price}"/>元<br/>
  	图书作者：<input type="text" name="author" value="${book.author}"/><br/>
  	图书分类：<select style="width: 150px; height: 20px;" name="cid">

	  <c:forEach items="${category}" var="c" >
		<%--	selected ?	  --%>
		  <option value="${c.cid}" <c:if test="${c.cid eq book.category.cid}">selected="selected"</c:if> >${c.cname}</option>
	  </c:forEach>


    	</select><br/>
  	<input type="submit" name="method" value="del" onclick="setMethod('delete')"/>
  	<input type="submit" name="method" value="mod" onclick="setMethod('edit')"/>
  </form>
  </body>
</html>
