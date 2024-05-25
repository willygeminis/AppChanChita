package pe.edu.pe.appchanchita.modelo;

public class Rol implements Prototype<Rol> {
    private int ID;
    private String Nombre;

    @Override
    public Rol clone() {
        try {
            return (Rol) super.clone();
        }catch (CloneNotSupportedException e){
            return new Rol(this.ID,this.Nombre);
        }
    }

    public Rol() {
    }

    public Rol(int ID, String nombre) {
        this.ID = ID;
        Nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
