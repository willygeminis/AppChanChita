package pe.edu.pe.appchanchita.axuliar;

import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlArchivos {


    public static String GuardarArchivo(String Ruta, Part ParteFile) throws IOException {
        try {
            // Crear el objeto File que representa el directorio de subida
            File Directorio = new File(Ruta);

            // Si el directorio no existe, crearlo
            if (!Directorio.exists()) {
                Directorio.mkdirs();
            }


            String OriginalNombreFile = getNombreArchivo(ParteFile);

            String fileExtension = getExtencionArchivo(OriginalNombreFile);

            String nuevoNombreFile = generarNombreUnico(fileExtension,OriginalNombreFile);


            ParteFile.write(Ruta + File.separator + nuevoNombreFile);


            return Ruta + "/" + nuevoNombreFile;
        } catch (Exception e) {

            System.out.println("Error al guardar el archivo: " + e.getMessage());
            throw new IOException("No se pudo guardar el archivo", e);
        }
    }

    // Método para obtener el nombre del archivo desde el header de la parte (Part)
    private static String getNombreArchivo(Part part) {

        String Encabezado = part.getHeader("content-disposition");

        for (String ParteCabeza : Encabezado.split(";")) {

            if (ParteCabeza.trim().startsWith("filename")) {

                return ParteCabeza.substring(ParteCabeza.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        return null;
    }

    // Método para obtener la extensión del archivo
    private static String getExtencionArchivo(String NombreArvhivo) {
        if (NombreArvhivo != null && NombreArvhivo.contains(".")) {
            return NombreArvhivo.substring(NombreArvhivo.lastIndexOf("."));
        }
        return "";
    }

    // Método para generar un nombre de archivo único usando la fecha y la hora actuales
    private static String generarNombreUnico(String ExtencionArchivo,String Nombre) {
        String nombreArchivo=null;
        if (Nombre != null && Nombre.contains(".")){
            nombreArchivo = Nombre.substring(0,Nombre.lastIndexOf("."));
        }
        String tiempo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return nombreArchivo + tiempo + ExtencionArchivo;
    }
}
