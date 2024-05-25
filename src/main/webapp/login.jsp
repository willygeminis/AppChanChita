<%--
  Created by IntelliJ IDEA.
  User: ASUS TUF
  Date: 23/05/2024
  Time: 19:37
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
    <title>AppChanchitaLogin</title>
    <link rel="stylesheet" href="CSS/login.css">
</head>
<body>
<section class="login">
    <figure class="contedor-img"></figure>
    <section class="login-credenciales mk-log">
        <form action="ValidarServlrt" method="post" >
            <div class="div-form-login">
                <label for="Correo" class="centrar-input-label">Correo</label>
                <input type="text" placeholder="Correo" id="Correo" class="centrar-input-label ff" name="correo" required/>
            </div>
            <div class="div-form-login">
                <label for="Contraseña" class="centrar-input-label">Contraseña</label>
                <input type="text" placeholder="Contraseña" id="Contraseña" class="centrar-input-label ff" name="password" required/>
            </div>
            <div class="div-form-login ">
                <input type="submit" value="Iniciar" name="accion"  id ="Iniciar" class="centrar-input-label envio-button" />
            </div>
        </form>
    </section>
</section>
</body>
</html>
