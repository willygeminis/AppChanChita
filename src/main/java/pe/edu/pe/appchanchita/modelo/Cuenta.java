package pe.edu.pe.appchanchita.modelo;

public class Cuenta implements Prototype<Cuenta> {
    private int id_cuenta;
    private String NumeroCuenta;


    @Override
    public Cuenta clone() {
        try {
            return (Cuenta) super.clone();
        }catch (CloneNotSupportedException e){
            return new Cuenta(this.id_cuenta,this.NumeroCuenta);
        }

    }
    public Cuenta() {

    }

    public Cuenta(int id_cuenta, String numeroCuenta) {
        this.id_cuenta = id_cuenta;
        this.NumeroCuenta = numeroCuenta;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        NumeroCuenta = numeroCuenta;
    }

}
