<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
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
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px rgb(78,78,78);
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body style="background: rgb(254,238,189);">
<h1>我的订单</h1>

<table border="1" width="100%" cellspacing="0" background="black">
	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			订单：8691b4150a0641e7a8729fd5e668820c　成交时间：2013-06-04 15:56:53　金额：<font color="red"><b>126.4</b></font>	已收货（完成）
		</td>
	</tr>
	<tr bordercolor="rgb(78,78,78)" align="center">
		<td width="15%">
			<div><img src="<c:url value='/book_img/20385925-1_l.jpg'/>" height="75"/></div>
		</td>
		<td>书名：Struts2深入详解</td>
		<td>单价：63.2元</td>
		<td>作者：孙鑫</td>
		<td>数量：2</td>
		<td>小计：126.4元</td>
	</tr>
  
 


	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			订单：153839427aa94f359fe51932d9f9e383　成交时间：2013-06-04 15:02:31　金额：<font color="red"><b>63.2</b></font>　
				   <a href="javascript:alert('发货成功！')">发货</a>
		</td>
	</tr>
	<tr bordercolor="rgb(78,78,78)" align="center">
		<td width="15%">
			<div><img src="<c:url value='/book_img/20029394-1_l.jpg'/>" height="75"/></div>
		</td>
		<td>书名：精通Spring2.x</td>
		<td>单价：63.2元</td>
		<td>作者：陈华雄</td>
		<td>数量：1</td>
		<td>小计：63.2元</td>
	</tr>
  


 
	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			订单：d1b85bfc71564b18bf7802582a9fd934　成交时间：2013-06-04 15:01:01　金额：<font color="red"><b>137.0</b></font>	已收货（完成）
		</td>
	</tr>
	<tr bordercolor="rgb(78,78,78)" align="center">
		<td width="15%">
			<div><img src="<c:url value='/book_img/20285763-1_l.jpg'/>" height="75"/></div>
		</td>
		<td>书名：Java核心技术卷1</td>
		<td>单价：68.5元</td>
		<td>作者：qdmmy6</td>
		<td>数量：2</td>
		<td>小计：137.0元</td>
	</tr>
  


	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			订单：o1　成交时间：2013-06-04 12:47:41　金额：<font color="red"><b>100.0</b></font>　未付款
		</td>
	</tr>
	<tr bordercolor="rgb(78,78,78)" align="center">
		<td width="15%">
			<div><img src="<c:url value='/book_img/9317290-1_l.jpg'/>" height="75"/></div>
		</td>
		<td>书名：Java编程思想（第4版）</td>
		<td>单价：75.6元</td>
		<td>作者：qdmmy6</td>
		<td>数量：2</td>
		<td>小计：300.0元</td>
	</tr>
	<tr bordercolor="rgb(78,78,78)" align="center">
		<td width="15%">
			<div><img src="<c:url value='/book_img/20285763-1_l.jpg'/>" height="75"/></div>
		</td>
		<td>书名：Java核心技术卷1</td>
		<td>单价：68.5元</td>
		<td>作者：qdmmy6</td>
		<td>数量：3</td>
		<td>小计：500.0元</td>
	</tr>
</table>
  </body>
</html>
