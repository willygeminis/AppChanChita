package pe.edu.pe.appchanchita.negocio;

import pe.edu.pe.appchanchita.axuliar.BaseDatosDAO;
import pe.edu.pe.appchanchita.axuliar.LogFile;
import pe.edu.pe.appchanchita.modelo.Cuenta;
import pe.edu.pe.appchanchita.modelo.Fondo;
import pe.edu.pe.appchanchita.modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FondoDAO {

    BaseDatosDAO conexion = new BaseDatosDAO();

    Connection con=null;

    PreparedStatement pre=null;

    ResultSet re=null;

    int ingresoFondo;

    public List<Fondo> listarfondos(){

        List<Fondo> Fondos = new ArrayList<>();
        String sql ="CALL ListarFondo()";

        try {

            con = conexion.conexion();
            pre= con.prepareStatement(sql);
            re=pre.executeQuery();
            while (re.next()){
                Fondo fondo = new Fondo();
                Cuenta cuenta = new Cuenta();
                Persona persona = new Persona();
                LogFile.info("inico poceso");
                fondo.setId(re.getInt(1));
                fondo.setRecaudado(re.getDouble(2));
                fondo.setNombre(re.getString(3));

                persona.setNombre(re.getString(4));
                persona.setApellido(re.getString(5));
                persona.setDni(re.getInt(6));
                persona.setNotificaciones(re.getBoolean(7));

                fondo.setEncargado(persona);

                cuenta.setNumeroCuenta(re.getString(8));

                fondo.setCuentaAsociada(cuenta);

                Fondos.add(fondo);
            }

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            // Cierra los recursos
            try {
                if (re != null) re.close();
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
        return Fondos;
    }

    public void IngresarFondo(Fondo fondo){
        String sql ="CALL IngresarFondoCompletor(?,?,?,?,?,?,?,?,?)";
        try {

            con = conexion.conexion();
            pre= con.prepareStatement(sql);
            pre.setString(1,fondo.getCuentaAsociada().getNumeroCuenta());
            pre.setString(2,fondo.getNombre());
            pre.setString(3,fondo.getEncargado().getNombre());
            pre.setString(4,fondo.getEncargado().getApellido());
            pre.setInt(5,fondo.getEncargado().getDni());
            pre.setInt(6, fondo.getEncargado().isNotificaciones() == true ? 1 : 0);
            pre.setString(7,fondo.getEncargado().getCorreo());
            pre.setString(8,fondo.getEncargado().getPassword());
            pre.setInt(9,fondo.getEncargado().getRol().getID());
            re=pre.executeQuery();


        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            // Cierra los recursos
            try {
                if (re != null) re.close();
                if (pre != null) pre.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}
