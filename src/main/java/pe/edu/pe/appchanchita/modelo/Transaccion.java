package pe.edu.pe.appchanchita.modelo;


public class Transaccion implements Prototype<Transaccion>{
    private int id_transaccion;
    private Persona usuarioAsociado;
    private Fondo fondoAsociado;
    private double monto;
    private String fecha;
    private String hora;
    private byte[] evidencia;
    private Persona responsable;

    public Transaccion() {

    }

    @Override
    public Transaccion clone() {
        try {
            Transaccion tranClone = (Transaccion) super.clone();
            tranClone.usuarioAsociado=usuarioAsociado.clone();
            tranClone.fondoAsociado=fondoAsociado.clone();
            tranClone.responsable=responsable.clone();
            return  tranClone;
        }catch (CloneNotSupportedException e){

           return  new Transaccion(this.id_transaccion,this.usuarioAsociado,this.fondoAsociado,this.monto,this.fecha,this.hora,this.evidencia,this.responsable);

        }
    }

    public Transaccion(int id_transaccion, Persona usuarioAsociado, Fondo fondoAsociado, double monto, String fecha, String hora, byte[] evidencia, Persona responsable) {
        this.id_transaccion = id_transaccion;
        this.usuarioAsociado = usuarioAsociado;
        this.fondoAsociado = fondoAsociado;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.evidencia = evidencia;
        this.responsable = responsable;
    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Persona getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Persona usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public Fondo getFondoAsociado() {
        return fondoAsociado;
    }

    public void setFondoAsociado(Fondo fondoAsociado) {
        this.fondoAsociado = fondoAsociado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public byte[] getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(byte[] evidencia) {
        this.evidencia = evidencia;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

}
