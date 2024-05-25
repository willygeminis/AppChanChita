package pe.edu.pe.appchanchita.modelo;

public class Persona implements  Prototype<Persona>{
    private int ID;
    private String nombre;
    private String apellido;
    private int dni;
    private boolean notificaciones;
    private String correo;
    private String password;
    private Rol rol;

//##############################################################################
//metodo para clonar objeto persona

    @Override
    public Persona clone() {
        try {
            Persona Clonepersona = (Persona) super.clone();
            Clonepersona.rol=rol.clone();
            return Clonepersona;
        }catch (CloneNotSupportedException e){
            return  new Persona();
        }
    }

//##############################################################################
//innerclass para el builder
    public static class Builder{
        private int ID;
        private String nombre;
        private String apellido;
        private int dni;
        private boolean notificaciones;
        private String correo;
        private String password;
        private Rol rol;

        public Builder(int ID, String nombre, String apellido, int dni,String correo,String password,Rol rol) {
            this.ID = ID;
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.correo=correo;
            this.password=password;
            this.rol=rol;
            this.notificaciones=false;
        }

        public  Builder withNotificaciones(){
            this.notificaciones=true;
            return this ;
        }

        public Persona build(){
            return new Persona(this);
        }
    }

//##############################################################################
//contructor implementado el builder
    public Persona(Builder builder) {
        this.ID = builder.ID;
        this.nombre =  builder.nombre;
        this.apellido = builder.apellido;
        this.dni = builder.dni;
        this.notificaciones= builder.notificaciones;
        this.correo=builder.correo;
        this.password=builder.password;
        this.rol=builder.rol;
    }

    public Persona() {
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(boolean notificaciones) {
        this.notificaciones = notificaciones;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
