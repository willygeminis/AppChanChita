<%@ page import="pe.edu.pe.appchanchita.modelo.Fondo" %>
<%@ page import="pe.edu.pe.appchanchita.modelo.Persona" %>
<%@ page import="pe.edu.pe.appchanchita.modelo.Transaccion" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Lista de Fondos</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5bNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
</head>
<jsp:include page="/InicialServlet"/>
<body>

<div class="container mt-5">
    <h1>Lista de Fondos</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Nombre del Fondo</th>
            <th>Recaudado</th>
            <th>Nombre del Encargado</th>
            <th>Apellido del Encargado</th>
            <th>DNI del Encargado</th>
            <th>Cuenta Asociada</th>
        </tr>
        </thead>
        <tbody>
        <%
            Transaccion obbeto = (Transaccion) request.getAttribute("ob");
            if (obbeto != null) {
                Fondo fondo = obbeto.getFondoAsociado();
                Persona encargado = obbeto.getResponsable();
                Persona user =obbeto.getUsuarioAsociado();

        %>
        <tr>
            <td><%= fondo.getId() %></td>
            <td><%= obbeto.getFecha() %></td>
            <td><%= obbeto.getHora() %></td>
            <td><%= encargado.getNombre() %></td>
            <td><%= encargado.getApellido() %></td>
            <td><%= encargado.getDni() %></td>
            <td><%= user.getNombre() %></td>
            <td><%= user.getApellido() %></td>
            <td><%= user.getDni() %></td>
            <td><%= obbeto.getEvidencia() %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-w1nFQy7MgiCBZ/QPQaxerXcYl2c/b3w2/EXxUop/J7Pw5bB7ZVxGFxoRUdU8R19B" crossorigin="anonymous"></script>
</body>
</html>
