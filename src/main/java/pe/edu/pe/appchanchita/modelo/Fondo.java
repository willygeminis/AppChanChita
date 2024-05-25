package pe.edu.pe.appchanchita.modelo;

public class Fondo implements Prototype<Fondo> {
    private int id;
    private String nombre;
    private double recaudado;
    private Persona encargado;
    private  Cuenta cuentaAsociada;

    @Override
    public Fondo clone() {
       try{
           Fondo fondoClon =(Fondo) super.clone();
           fondoClon.cuentaAsociada =cuentaAsociada.clone();
           fondoClon.encargado= encargado.clone();
           return  fondoClon;
       }catch (CloneNotSupportedException e){
            return new Fondo(this.id,this.nombre,this.recaudado,this.encargado,this.cuentaAsociada);
       }
    }

    public Fondo() {
        this.cuentaAsociada = new Cuenta();
    }
    public Fondo(int id, String nombre, double recaudado, Persona encargado, Cuenta cuentaAsociada) {
        this.id = id;
        this.nombre = nombre;
        this.recaudado = recaudado;
        this.encargado = encargado;
        this.cuentaAsociada = cuentaAsociada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(double recaudado) {
        this.recaudado = recaudado;
    }

    public Persona getEncargado() {
        return encargado;
    }

    public void setEncargado(Persona encargado) {
        this.encargado = encargado;
    }

    public Cuenta getCuentaAsociada() {
        return cuentaAsociada;
    }

    public void setCuentaAsociada(Cuenta cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }
}
