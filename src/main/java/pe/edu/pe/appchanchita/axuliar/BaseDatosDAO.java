package pe.edu.pe.appchanchita.axuliar;

import pe.edu.pe.appchanchita.servicios.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatosDAO {
    public Connection con;

    public  Connection conexion (){
        try {
            Class.forName(AppConfig.getDriver());
            con = DriverManager.getConnection(AppConfig.getDatasource(),AppConfig.getUsername(),AppConfig.getPassword());
        } catch (Exception e){
            System.out.println(e);
        }
        return con;
    }

}
