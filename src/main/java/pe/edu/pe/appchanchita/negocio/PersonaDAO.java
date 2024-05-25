package pe.edu.pe.appchanchita.negocio;

import pe.edu.pe.appchanchita.axuliar.BaseDatosDAO;
import pe.edu.pe.appchanchita.axuliar.LogFile;
import pe.edu.pe.appchanchita.modelo.Fondo;
import pe.edu.pe.appchanchita.modelo.Persona;
import pe.edu.pe.appchanchita.modelo.Rol;
import pe.edu.pe.appchanchita.servicios.AppConfig;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PersonaDAO {
    BaseDatosDAO conexion = new BaseDatosDAO();

    Connection con=null;

    PreparedStatement pre=null;

    ResultSet re=null;
    public Persona is_validar(String user, String contra) throws IOException {
        Persona persona = new Persona();
        String sql ="call Validar(?,?);";
        try {

            LogFile.info("ejecutando el proceso almacenado : "+sql );
            con=conexion.conexion();
            pre=con.prepareStatement(sql);
            pre.setString(1, user);
            pre.setString(2, contra);
            re = pre.executeQuery();

            if (re.next()) {
                Rol rol = new Rol();
                persona.setID(re.getInt(1));
                persona.setNombre(re.getString(2));
                persona.setApellido(re.getString(3));
                persona.setDni(re.getInt(4));
                persona.setNotificaciones(re.getBoolean(5));
                persona.setCorreo(re.getString(6));
                rol.setID(re.getInt(7));
                persona.setRol(rol);

                LogFile.info("Usuario validado: " + user);
            } else {
                LogFile.warn("No se encontró el usuario: " + user);
            }

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            LogFile.info("ocurrio un error en la ejecucion de proceso almacenado "+ sql);
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

        return persona;
    }
}
