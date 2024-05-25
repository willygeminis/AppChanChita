package pe.edu.pe.appchanchita.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.pe.appchanchita.modelo.*;
import pe.edu.pe.appchanchita.negocio.FondoDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FondoServlet", value = "/FondoServlet")
public class FondoServlet extends HttpServlet {

    private Fondo prototypeFondo;

    @Override
    public void init() throws ServletException {
        super.init();
        prototypeFondo = new Fondo();
        prototypeFondo.setNombre("Prototipo Fondo");
        prototypeFondo.setRecaudado(0);
        Rol rol = new Rol(1,"Administrador");
        Persona encargado= new Persona.Builder(0, "Prototipo", "Encargado", 0, "wiily@hotmail.com", "123456", rol).build();
        prototypeFondo.setEncargado(encargado);
        prototypeFondo.setCuentaAsociada(new Cuenta(0, "00000000000000000000"));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //clase DAO
        FondoDAO fondobase = new FondoDAO();
        List<Fondo> listaFondo = fondobase.listarfondos();
        // Clonar el prototipo
        Fondo newfondo = prototypeFondo.clone();
        Cuenta newcuenta = newfondo.getCuentaAsociada();
        Persona newpersona = newfondo.getEncargado();
        Rol newrol =newpersona.getRol();
        //para Validar
        List<String> errores = new ArrayList<>();

        try {
            // Obtener datos del formulario
            String nombreFondo = req.getParameter("nombre-f");
            String tarjetaAsociada = req.getParameter("tarjeta");
            String nombreEncargado = req.getParameter("nombre-r");
            String apellidoEncargado = req.getParameter("apellido-r");
            String dniStr = req.getParameter("dni-r");
            String notificacionesstar = req.getParameter("f-notificacion");
            String Correo =req.getParameter("Correo-r");
            String Contraseña =req.getParameter("password-r");


            //VAKIDAR DATOS INGRESADOS
            // Validar nombre del fondo
            if (nombreFondo == null || nombreFondo.trim().isEmpty() || nombreFondo.length() < 2) {
                errores.add("El nombre del fondo debe tener al menos 2 letras.");
            }
            // Validar tarjeta asociada
            if (tarjetaAsociada == null || !tarjetaAsociada.matches("\\d{20}")) {
                errores.add("El numero de cuenta  debe ser un interbancario que consta de 20 dígitos.");
            }
            // Validar nombre del encargado
            if (nombreEncargado == null || nombreEncargado.trim().isEmpty() || nombreEncargado.length() < 2 || nombreEncargado.length() > 20 || !nombreEncargado.matches("[a-zA-Z]+")) {
                errores.add("El nombre del encargado debe tener entre 2 y 20 letras y no contener números.");
            }
            // Validar apellido del encargado
            if (apellidoEncargado == null || apellidoEncargado.trim().isEmpty() || apellidoEncargado.length() < 2 || apellidoEncargado.length() > 20 || !apellidoEncargado.matches("[a-zA-Z]+")) {
                errores.add("El apellido del encargado debe tener entre 2 y 20 letras y no contener números.");
            }
            // Validar DNI
            if (dniStr == null || !dniStr.matches("\\d{8}")) {
                errores.add("El DNI debe ser un número de 8 dígitos.");
            }
            // Validar correo electrónico
            if (Correo == null || !Correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errores.add("El correo electrónico no es válido. Debe tener un formato como usuario@dominio.com.");
            }
            // Validar contraseña
            if (Contraseña == null || Contraseña.length() < 6) {
                errores.add("La contraseña debe tener al menos 6 caracteres.");
            }


            // Validar las notificaciones
            boolean notificaciones = notificacionesstar !=null && Boolean.parseBoolean(notificacionesstar);



            if (!errores.isEmpty()){
                //Encontramos errores
                String sectionx="s-fondo";
                String modalsection="s-error";
                req.setAttribute("listaF", listaFondo);
                req.setAttribute("modalerror",modalsection);
                req.setAttribute("errores",errores);
                req.setAttribute("exito",sectionx);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }else{
                // Actualizar las propiedades del clon
                int dni = Integer.parseInt(dniStr);
                newcuenta.setNumeroCuenta(tarjetaAsociada);
                if (notificaciones) {
                    newpersona = new Persona.Builder(0, nombreEncargado, apellidoEncargado, dni,Correo,Contraseña,newrol)
                            .withNotificaciones()
                            .build();
                } else {
                    newpersona = new Persona.Builder(0, nombreEncargado, apellidoEncargado, dni,Correo,Contraseña,newrol)
                            .build();
                }
                newfondo.setEncargado(newpersona);
                newfondo.setNombre(nombreFondo);
                newfondo.setRecaudado(0); // Inicialización de recaudado a 0

                // Guardar el nuevo fondo en la base de datos

                fondobase.IngresarFondo(newfondo);

                String sectionx="s-fondo";
                req.setAttribute("exito",sectionx);
                req.setAttribute("listaF", listaFondo);
                // Redirigir a la página de inicio
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }

        } catch (NumberFormatException e) {
            // Manejar posibles errores de formato de número
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
