package pe.edu.pe.appchanchita.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.edu.pe.appchanchita.modelo.Fondo;
import pe.edu.pe.appchanchita.negocio.FondoDAO;
import pe.edu.pe.appchanchita.servicios.Auth;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ValidarServlrt", value = "/ValidarServlrt")
public class ValidarServlrt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user =req.getParameter("correo");
        String contra=req.getParameter("password");

        FondoDAO fondoB = new FondoDAO();
        List<Fondo> listaFondo = fondoB.listarfondos();


        try {

            Boolean ResultadoValidacion = Auth.isValidar(user,contra);

            if (ResultadoValidacion){

                HttpSession session = req.getSession();
                req.setAttribute("listaF", listaFondo);
                session.setAttribute("Inicioseccion",true);
                req.getRequestDispatcher("index.jsp").forward(req,resp);

            }else{
                resp.sendRedirect("error.jsp");
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
