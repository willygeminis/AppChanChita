<%@ page import="java.util.List" %>
<%@ page import="pe.edu.pe.appchanchita.modelo.Fondo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%
    HttpSession ses = request.getSession();
    Boolean Inicio_Session = false;
    if (ses.getAttribute("Inicioseccion")!=null){
          Inicio_Session= (Boolean) ses.getAttribute("Inicioseccion");
    }else{
          Inicio_Session = false;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>AppChanchita</title>
  <link rel="stylesheet" href="CSS/estilo.css" />
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous"
  />

  <% String  sect= String.valueOf(request.getAttribute("exito"));%>
  <% String  key= String.valueOf(request.getAttribute("modalerror"));%>
</head>

<%  if (Inicio_Session) {%>

<body>
<nav class="navbar bg-body-tertiary menu">
  <div class="container-fluid">
    <a class="navbar-brand logo" href="index.jsp">
      <img
              src="IMG/iconodepagina.png"
              alt="Logo"
              width="60"
              height="60"
              class="d-inline-block align-text-top"
      />
      <h1>AppChanchita</h1>
    </a>
    <div class="barra-navegacion">
      <ul class="nav nav-underline">
        <li class="nav-item">
          <a class="nav-link iniciooo" aria-current="page" href="#"
          >Inicio</a
          >
        </li>
        <li class="nav-item">
          <a class="nav-link fondooo" href="#">Fondo</a>
        </li>
        <li class="nav-item">
          <a class="nav-link tranferenciaaa" href="#">Tranferencia</a>
        </li>
        <li class="nav-item">
          <a class="nav-link manual" href="#">Manual</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<main>
  <section class="s-inicio sec" id="s-inicio">
    <div class="img-inico div-imag"></div>
    <div class="contenido-inicio">
      <h2>¡Bienvenido a "ChanchitaApp"!</h2>
      <p>¡Hola!</p>
      <p>
        Gracias por unirte a "ChanchitaApp", tu nueva herramienta para
        administrar fondos comunes de manera fácil y eficiente. Con nuestra
        aplicación, podrás crear chanchitas con tus amigos, familiares o
        compañeros de trabajo para ahorrar juntos y alcanzar vuestros
        objetivos financieros más rápido que nunca.
      </p>
      <p>
        Con "ChanchitaApp", podrás realizar un seguimiento de tus ahorros,
        hacer contribuciones periódicas, establecer metas de ahorro, y mucho
        más. Nuestra plataforma segura y fácil de usar te brindará todas las
        herramientas que necesitas para mantener tus finanzas en orden y
        alcanzar tus sueños financieros.
      </p>
      <p>
        ¡Empieza hoy mismo a gestionar tus fondos comunes de manera
        inteligente con "ChanchitaApp"!
      </p>
      <cite style="display: block">El equipo de "ChanchitaApp"</cite>
      <button type="button" class="btn btn-primary">Guia de uso</button>
    </div>
  </section>
  <section class="s-fondo sec" id="s-fondo">
    <div class="formulario-fondo">
      <form action="FondoServlet" method="post">
        <div class="datos-fondo">
          <h2>DATOS DEL FONDO</h2>
          <div class="form-group">
            <label for="nombre-f">Nombre:</label>
            <input
                    type="text"
                    class="form-control"
                    id="nombre-f"
                    name="nombre-f"
                    required
            />
          </div>
          <div class="form-group">
            <label for="tarjeta">Tarjeta Asociada:</label>
            <input
                    type="text"
                    class="form-control"
                    id="tarjeta"
                    name="tarjeta"
                    required
            />
          </div>
        </div>

        <div class="encargado-fondo">
          <h2>DATOS DEL RESPONSABLE</h2>
          <div class="form-group">
            <label for="nombre-r">Nombre:</label>
            <input
                    type="text"
                    class="form-control"
                    id="nombre-r"
                    name="nombre-r"
                    required
            />
          </div>
          <div class="form-group">
            <label for="apellido-r">Apellido:</label>
            <input
                    type="text"
                    class="form-control"
                    id="apellido-r"
                    name="apellido-r"
                    required
            />
          </div>
          <div class="form-group">
            <label for="dni-r">DNI:</label>
            <input
                    type="text"
                    class="form-control"
                    id="dni-r"
                    name="dni-r"
                    required
            />
          </div>
          <div class="form-group">
            <label for="Correo-r">Correo:</label>
            <input
                    type="text"
                    class="form-control"
                    id="Correo-r"
                    name="Correo-r"
                    required
            />
          </div>
          <div class="form-group">
            <label for="password-r">Password:</label>
            <input
                    type="text"
                    class="form-control"
                    id="password-r"
                    name="password-r"
                    required
            />
          </div>
          <div class="form-check">
            <input class="form-check-input" type="checkbox"  id="f-notificacion" name="f-notificacion" value=1>
            <label class="form-check-label" for="f-notificacion">
              Deseas Recibir Notificaciones
            </label>
          </div>
        </div>
        <button type="submit" class="btn btn-primary envio-fondo">
          Registrar
        </button>
      </form>
    </div>
    <div class="imagen-fondo div-imag"></div>
  </section>
  <section class="s-transaccion sec" id="s-transaccion">
    <form action="TransacionServlet" method="post" enctype="multipart/form-data">
      <div class="div-transaccion">
        <div class="form-fondo-t">
          <h2>Fondo</h2>
          <select id="select-fondo-T" class="form-select" aria-label="Disabled" name="select-tran">
            <option selected>Selecciona el fondo</option>
            <%
              List<Fondo> lista = (List<Fondo>) request.getAttribute("listaF");
              if (lista != null) {
                for (Fondo fondo : lista) {
            %>
            <option value="<%= fondo.getId() %>"
                    data-encargado-nombre="<%= fondo.getEncargado().getNombre() %>"
                    data-encargado-apellido="<%= fondo.getEncargado().getApellido() %>"
                    data-encargado-dni="<%= fondo.getEncargado().getDni() %>">
              <%= fondo.getNombre() %>
            </option>
            <%
                }
              }
            %>
          </select>
          <div class="contenido-fondo-t">
            <h4>Abvertencia</h4>
            <p>
              "Si no encuentra lo que busca, es posible que aún no esté
              registrado o haya ocurrido un error en el registro. Por favor,
              diríjase al menú de la opción 'Fondo' para registrar el fondo
              adecuadamente.
            </p>
            <p>¡Gracias!</p>
          </div>
        </div>
        <div class="form-detalle-t">
          <h2>Cliente</h2>
          <div class="form-group">
            <label for="nombre-cl-t">Nombre:</label>
            <input
                    type="text"
                    class="form-control"
                    id="nombre-cl-t"
                    name="nombre-cl-t"
                    required
            />
          </div>
          <div class="form-group">
            <label for="apellido-cl-t">Apellido:</label>
            <input
                    type="text"
                    class="form-control"
                    id="apellido-cl-t"
                    name="apellido-cl-t"
                    required
            />
          </div>

          <div class="form-group">
            <label for="dni-cl-t">DNI:</label>
            <input
                    type="text"
                    class="form-control"
                    id="dni-cl-t"
                    name="dni-cl-t"
                    required
            />
          </div>
        </div>
        <div class="form-Cliente-t">
          <h2>Detalle</h2>
          <div class="form-group">
            <label for="Monto-t">Monto:</label>
            <input
                    type="text"
                    class="form-control"
                    id="Monto-t"
                    name="Monto-t"
                    required
            />
          </div>
          <div class="mb-3">
            <label for="imagen-p" class="form-label">Subir Imagen</label>
            <input
                    class="form-control"
                    type="file"
                    id="imagen-p"
                    name="imagen-p"
            />
          </div>
        </div>
        <div class="form-encargadoevio-t">
          <h2>Encargado</h2>
          <div class="form-group">
            <label for="nombre-en-t">Nombre:</label>
            <input
                    type="text"
                    class="form-control"
                    id="nombre-en-t"
                    name="nombre-en-t"
                    required
            />
          </div>
          <div class="form-group">
            <label for="apellido-en-t">Apellido:</label>
            <input
                    type="text"
                    class="form-control"
                    id="apellido-en-t"
                    name="apellido-en-t"
                    required
            />
          </div>

          <div class="form-group">
            <label for="dni-en-t">DNI:</label>
            <input
                    type="text"
                    class="form-control"
                    id="dni-en-t"
                    name="dni-en-t"
                    required
            />
          </div>
        </div>
      </div>
      <div class="col-12">
        <button class="btn btn-primary sube" type="submit">
          Registrar Deposito
        </button>
      </div>
    </form>
  </section>
  <section class="s-manual sec" id="s-manual">
    <div class="media">
      <video src="#" controls></video>
    </div>
  </section>
  <section class="s-error" id="s-error">
    <!-- Modal -->
    <div
            class="modal fade show"
            id="exampleModal"
            tabindex="-1"
            aria-labelledby="exampleModalLabel"
            aria-modal="true"
            role="dialog"
            style="display: block"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">
              Errores Detectados
            </h1>
          </div>
          <div class="modal-body">
            <ul>
              <%
                List<String> errores = (List<String>) request.getAttribute("errores");
                if (errores != null && !errores.isEmpty()) {
                  for (String error : errores) {
              %>
              <li><%= error %></li>
              <%
                  }
                }
              %>
            </ul>
          </div>
          <div class="modal-footer">
            <button
                    type="button"
                    class="btn btn-primary"
                    id="cerrar-modal-error"
            >
              Aceptar
            </button>
          </div>
        </div>
      </div>
    </div>
  </section>
</main>
<script>
  document.addEventListener("DOMContentLoaded", function() {
    function mantener(sect) {
      const grupo = document.querySelectorAll(".sec");

      if (sect != null) {
        let elemento = document.getElementById(sect);

        if (elemento) {
          grupo.forEach((value) => {
            value.style.display = "none";
          });
          elemento.style.display = "grid";
        } else {
          console.error(`El elemento con ID '${sect}' no se encontró.`);
        }
      } else {
        console.error("No hay peticiones");
      }
    }

    function MostrarModal(key){
      if (key != null) {
        let elmento =document.getElementById(key);
        if (elmento) {
          elmento.style.display = "block";
        } else {
          console.error(`El elemento con ID '${key}' no se encontró.`);
        }
      } else {
        console.error("No hay errores");
      }

    }
    mantener("<%= sect %>");
    MostrarModal("<%= key %>");
  });
</script>
</body>
<script src="JS/script.js" type="module"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"
></script>
</html>

<%  } else {%>
        <%  response.sendRedirect("login.jsp"); %>
<% }%>