<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF
  Date: 18/05/2024
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>error</title>
</head>
<body>
<% String error= String.valueOf(request.getAttribute("modalerror"));%>
<h1><%= error %></h1>
</body>
</html>