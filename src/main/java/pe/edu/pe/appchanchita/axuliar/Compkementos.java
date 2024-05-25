package pe.edu.pe.appchanchita.axuliar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compkementos {
    public static List<String> FechaHora(){
        List<String> tiempo = new ArrayList<>();

        SimpleDateFormat FormatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat FormatoHora = new SimpleDateFormat("HH:mm:ss");

        Date ElAhora = new Date();

        String Fecha = FormatoFecha.format(ElAhora);
        String Hora = FormatoHora.format(ElAhora);

        tiempo.add(Fecha);
        tiempo.add(Hora);

        return tiempo;
    }

    public static List<String> ValidarTransaccion(List<String> parametros){
        List<String> Errores = new ArrayList<>();
        if (parametros.get(0) == null || parametros.get(0).trim().isEmpty() || parametros.get(0).length() < 2 || parametros.get(0).length() > 20 || !parametros.get(0).matches("[a-zA-Z]+")) {
            Errores.add("El nombre del cliente debe tener entre 2 y 20 letras y no contener números.");
        }

        if (parametros.get(1) == null || parametros.get(1).trim().isEmpty() || parametros.get(1).length() < 2 || parametros.get(1).length() > 20 || !parametros.get(1).matches("[a-zA-Z]+")) {
            Errores.add("El apellido del cliente debe tener entre 2 y 20 letras y no contener números.");
        }

        if (parametros.get(2) == null || parametros.get(2).trim().isEmpty() || !parametros.get(2).matches("\\d{8}")) {
            Errores.add("El DNI del cliente debe ser un número válido.");
        }

        if (parametros.get(3) == null || parametros.get(3).trim().isEmpty() || !parametros.get(3).matches("\\d+(\\.\\d{1,2})?")) {
            Errores.add("El monto debe ser un número válido con hasta dos decimales.");
        }

        if (parametros.get(4) == null || parametros.get(4).trim().isEmpty() || parametros.get(4).length() < 2 || parametros.get(4).length() > 20 || !parametros.get(4).matches("[a-zA-Z]+")) {
            Errores.add("El nombre del encargado debe tener entre 2 y 20 letras y no contener números.");
        }

        if (parametros.get(5) == null || parametros.get(5).trim().isEmpty() || parametros.get(5).length() < 2 || parametros.get(5).length() > 20 || !parametros.get(5).matches("[a-zA-Z]+")) {
            Errores.add("El apellido del encargado debe tener entre 2 y 20 letras y no contener números.");
        }

        if (parametros.get(6) == null || parametros.get(6).trim().isEmpty() || !parametros.get(6).matches("\\d{8}")) {
            Errores.add("El DNI del encargado debe ser un número válido.");
        }

        if (parametros.get(7) == null || parametros.get(7).trim().isEmpty() || !parametros.get(7).matches("\\d+")) {
            Errores.add("Tienes que seleccionar un Fondo.");
        }

        return  Errores;
    }

}
