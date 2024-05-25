<%@ page import="pe.edu.pe.appchanchita.modelo.Fondo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS TUF
  Date: 22/05/2024
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Fondo> lista = (List<Fondo>) request.getAttribute("listaF");
    if (lista != null) {
        for (Fondo fondo : lista) {
%>
<tr>
    <td><%= fondo.getNombre() %></td>
    <td><%= fondo.getRecaudado() %></td>
    <td><%= fondo.getEncargado().getNombre() %></td>
    <td><%= fondo.getEncargado().getApellido() %></td>
    <td><%= fondo.getEncargado().getDni() %></td>
    <td><%= fondo.getCuentaAsociada().getNumeroCuenta() %></td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="6">No hay fondos disponibles.</td>
</tr>
<%
    }
%>
</body>
</html>
