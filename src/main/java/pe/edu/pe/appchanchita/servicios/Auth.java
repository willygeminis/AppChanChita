package pe.edu.pe.appchanchita.servicios;

import pe.edu.pe.appchanchita.axuliar.LogFile;
import pe.edu.pe.appchanchita.modelo.Persona;
import pe.edu.pe.appchanchita.negocio.PersonaDAO;

import java.io.IOException;

public class Auth {

    public static Boolean isValidar(String user, String contra) {
        try {
            PersonaDAO personaDAO = new PersonaDAO();
            LogFile.info("Iniciando validación de usuario: " + user);

            Persona persona = personaDAO.is_validar(user, contra);
            if (persona != null && persona.getID() > 0) {
                LogFile.info("Usuario validado correctamente: " + user);
                return true;
            } else {
                LogFile.warn("Fallo en la validación del usuario: " + user);
                return false;
            }
        } catch (Exception e) {
            try {
                LogFile.error("Error al validar usuario: " + e.getMessage());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return false;
        }
    }
}
