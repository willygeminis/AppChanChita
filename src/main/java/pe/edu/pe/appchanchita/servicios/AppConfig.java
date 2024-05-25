package pe.edu.pe.appchanchita.servicios;

import java.util.ResourceBundle;

public class AppConfig {
    static ResourceBundle rb = ResourceBundle.getBundle("app");
    public static String getDatasource(){
        return rb.getString("datasource");
    }

    public  static String getErrorLogFile(){
        return rb.getString("errorLog");
    }


    public static String getUsername() {
        return rb.getString("db.username");
    }

    public static String getPassword() {
        return rb.getString("db.password");
    }

    public static String getDriver() {
        return rb.getString("db.driver");
    }
    public static String getRutaimg(){
        return rb.getString("rutaimg");
    }
}
