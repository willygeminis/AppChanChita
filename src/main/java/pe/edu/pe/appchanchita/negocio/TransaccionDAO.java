package pe.edu.pe.appchanchita.negocio;

import pe.edu.pe.appchanchita.axuliar.BaseDatosDAO;
import pe.edu.pe.appchanchita.modelo.Transaccion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransaccionDAO {
    BaseDatosDAO conexion = new BaseDatosDAO();

    Connection con=null;

    PreparedStatement pre=null;

    ResultSet re=null;
    public void IngresarTransaccion(Transaccion transaccion){

        String sql = "CALL IngresarTransCompleto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            con = conexion.conexion();
            pre= con.prepareStatement(sql);
            pre.setInt(1,transaccion.getFondoAsociado().getId());
            pre.setString(2,transaccion.getUsuarioAsociado().getNombre());
            pre.setString(3,transaccion.getUsuarioAsociado().getApellido());
            pre.setInt(4,transaccion.getUsuarioAsociado().getDni());
            pre.setInt(5,transaccion.getUsuarioAsociado().isNotificaciones()==true ? 1 : 0);
            pre.setString(6,transaccion.getUsuarioAsociado().getCorreo());
            pre.setString(7,transaccion.getUsuarioAsociado().getPassword());
            pre.setInt(8,transaccion.getUsuarioAsociado().getRol().getID());
            pre.setString(9,transaccion.getResponsable().getNombre());
            pre.setString(10,transaccion.getResponsable().getApellido());
            pre.setInt(11,transaccion.getResponsable().getDni());
            pre.setInt(12,transaccion.getResponsable().isNotificaciones()==true ? 1 : 0);
            pre.setString(13,transaccion.getResponsable().getCorreo());
            pre.setString(14,transaccion.getResponsable().getPassword());
            pre.setInt(15,transaccion.getResponsable().getRol().getID());
            pre.setDouble(16,transaccion.getMonto());
            pre.setString(17,transaccion.getFecha());
            pre.setString(18,transaccion.getHora());
            pre.setBytes(19, transaccion.getEvidencia());
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
