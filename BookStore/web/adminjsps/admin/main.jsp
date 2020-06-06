<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
		*{
			font-size:10pt;
		}
		body{
			text-align:center;
			margin: 0px;
		}
		.table{
			width:100%;
			height:100%;
			border:1px solid gray;/*固定边框,1像素*/
		    border-collapse: collapse;/*单线的列表边框*/
		}
		.table td{
			border:1px solid gray;/*固定边框,1像素*/
		}
		iframe {
			width: 100%;
			height: 100%;
		}
	</style>
  </head>
  
  <body>
<table class="table" align="center">
	<tr style="background: rgb(78,78,78); height: 120px; ">
		<td colspan="2" align="center">
			<iframe frameborder="0" src="<c:url value='/adminjsps/admin/top.jsp'/>" name="top"></iframe>
		</td>
	</tr>
	<tr>
		<td width="265" style="padding:5px;" align="center" valign="top">
			<iframe frameborder="0" width="120" src="<c:url value='/adminjsps/admin/left.jsp'/>" name="left"></iframe>
		</td>
		<td>
			<iframe frameborder="0" src="<c:url value='/adminjsps/admin/body.jsp'/>" name="body"></iframe>
		</td>
	</tr>
</table>
  </body>
</html>
