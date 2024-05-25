package pe.edu.pe.appchanchita.controlador;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import pe.edu.pe.appchanchita.axuliar.Compkementos;

import pe.edu.pe.appchanchita.axuliar.ControlArchivos;
import pe.edu.pe.appchanchita.modelo.*;
import pe.edu.pe.appchanchita.negocio.FondoDAO;
import pe.edu.pe.appchanchita.negocio.TransaccionDAO;
import pe.edu.pe.appchanchita.servicios.AppConfig;


import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "TransacionServlet", value = "/TransacionServlet")
@MultipartConfig
public class TransacionServlet extends HttpServlet {
    private Transaccion prototypeTrans;

    @Override
    public void init() throws ServletException {
        super.init();
        prototypeTrans = new Transaccion();
        prototypeTrans.setId_transaccion(0);
        Rol rolR = new Rol(2, "Cliente");
        Persona responsable = new Persona.Builder(0, "Prototipo", "Encargado", 0, "wiily@hotmail.com", "123456", rolR).build();
        prototypeTrans.setResponsable(responsable);
        Persona cliente = new Persona.Builder(0, "Prototipo", "Encargado", 0, "wiily@hotmail.com", "123456", rolR).build();
        prototypeTrans.setUsuarioAsociado(cliente);
        prototypeTrans.setFondoAsociado(new Fondo());
        prototypeTrans.setMonto(0.0);
        prototypeTrans.setFecha("2024-01-01");
        prototypeTrans.setHora("00:00:00");
        prototypeTrans.setEvidencia(new byte[0]);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Clase DAO
        TransaccionDAO transaccionDAO = new TransaccionDAO();
        FondoDAO fondao = new FondoDAO();
        List<Fondo> listaFondo = fondao .listarfondos();
        //Listas para validaciones
        List<String> Errores = new ArrayList<>();

        // Clonación
        Transaccion newTransaccion = prototypeTrans.clone();
        Persona newCliente = newTransaccion.getUsuarioAsociado();
        Persona newEncargado = newTransaccion.getResponsable();
        Rol newRol = newEncargado.getRol();
        Fondo newFondo = newTransaccion.getFondoAsociado();

        // Fecha y Hora
        List<String> elAhora = Compkementos.FechaHora();

            // LLamado de parametros del jsp
            String clienteNombre = req.getParameter("nombre-cl-t");
            String clienteApellido = req.getParameter("apellido-cl-t");
            String clienteDNI = req.getParameter("dni-cl-t");
            String monto = req.getParameter("Monto-t");
            String encargadoNombre = req.getParameter("nombre-en-t");
            String encargadoApellido = req.getParameter("apellido-en-t");
            String encargadoDNI = req.getParameter("dni-en-t");
            Part partesImg = req.getPart("imagen-p");
            String fondoSelect = req.getParameter("select-tran");

            //Validar
            List<String> parametros = new ArrayList<>(Arrays.asList(
                clienteNombre,
                clienteApellido,
                clienteDNI,
                monto,
                encargadoNombre,
                encargadoApellido,
                encargadoDNI,
                fondoSelect
             ));

            Errores=Compkementos.ValidarTransaccion(parametros);

            if (!Errores.isEmpty()){
                String modalsection="s-error";
                String sectionx="s-transaccion";
                req.setAttribute("modalerror",modalsection);
                req.setAttribute("errores",Errores);
                req.setAttribute("exito",sectionx);
                req.setAttribute("listaF", listaFondo);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }else{
                //convertir
                int dniUsr= Integer.parseInt(clienteDNI);
                int dniClin= Integer.parseInt(encargadoDNI);
                //Guardar Imagen
                String RutaR=ControlArchivos.GuardarArchivo(AppConfig.getRutaimg(),partesImg);
                newTransaccion.setEvidencia(RutaR.getBytes(StandardCharsets.UTF_8));
                // Actualizar datos del cliente y encargado
                newCliente = new Persona.Builder(0, clienteNombre, clienteApellido, dniUsr, "temporal", "temporal", newRol).build();
                newEncargado = new Persona.Builder(0, encargadoNombre, encargadoApellido,dniClin, "temporal", "temporal", newRol).build();

                newFondo.setId(Integer.parseInt(fondoSelect));

                newTransaccion.setFondoAsociado(newFondo);
                newTransaccion.setResponsable(newEncargado);
                newTransaccion.setUsuarioAsociado(newCliente);
                newTransaccion.setFecha(elAhora.get(0));
                newTransaccion.setHora(elAhora.get(1));
                newTransaccion.setMonto(Double.parseDouble(monto));

                // Ingresar transacción
                transaccionDAO.IngresarTransaccion(newTransaccion);


                //redireccion al QR
                req.setAttribute("parametros",parametros);
                req.getRequestDispatcher("mostrar_Qr.jsp").forward(req,resp);


            }




    }
}
