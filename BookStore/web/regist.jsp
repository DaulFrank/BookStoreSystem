<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content=" Master  Login Form Widget Tab Form,Login Forms,Sign up Forms,Registration Forms,News letter Forms,Elements"/>
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="//fonts.googleapis.com/css?family=Cormorant+SC:300,400,500,600,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
</head>

<body>
<div class="padding-all">
    <div class="header">
        <h1>Master  Login Form</h1>
    </div>

    <div class="design-w3l">
        <div class="mail-form-agile">
            <p style="color: red; font-weight: 900">${msg }</p>
            <form action="<c:url value='/UserServlet'/>" method="post">
                <input type="hidden" name="method" value="regist"/>
                <input type="text" name="username"  placeholder="User Name " value="${form.username}"/>	&nbsp;&nbsp;&nbsp;<span style="color: red; font-weight: 900">${errors.username }</span><br/>

                <input type="password" name="password" class="padding" placeholder="Password"  value="${form.password}"/>	&nbsp;&nbsp;&nbsp;<span style="color: red; font-weight: 900">${errors.password }</span><br/>

                <input type="text" name="email"placeholder="Email" value="${form.email}"/>	&nbsp;&nbsp;&nbsp;<span style="color: red; font-weight: 900">${errors.email }</span><br/>

                <input type="submit" value="SIGN UP"/>
            </form>
        </div>
        <div class="clear"> </div>
    </div>

</div>
</body>
</html>