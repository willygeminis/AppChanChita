package pe.edu.pe.appchanchita.modelo;

import pe.edu.pe.appchanchita.negocio.FondoDAO;

import java.util.List;

public class pruebabase {
    public static void main(String[] args) {

        FondoDAO fondodao = new FondoDAO();
        List<Fondo> listado = fondodao.listarfondos(); // Suponiendo que tienes un método para obtener la lista de fondos

        for (Fondo fondo : listado) {
            System.out.println("Nombre: " + fondo.getNombre());
            System.out.println("ID: " + fondo.getId());
            System.out.println("Apellido: " + fondo.getEncargado().getApellido());
            System.out.println("DNI: " + fondo.getEncargado().getDni());
            System.out.println("numero de cuenta: " + fondo.getCuentaAsociada().getNumeroCuenta());
            System.out.println();
        }





    }
}
