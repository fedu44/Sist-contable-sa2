package Modelo;

public class Asiento_cuenta {
    
    private int idasiento_cuenta;
    private double debe;
    private double haber;
    private int cuenta;
    private int asiento;
    private double saldo_parcial;

    public Asiento_cuenta() {
    }

    public int getIdasiento_cuenta() {
        return idasiento_cuenta;
    }

    public void setIdasiento_cuenta(int idasiento_cuenta) {
        this.idasiento_cuenta = idasiento_cuenta;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public double getSaldo_parcial() {
        return saldo_parcial;
    }

    public void setSaldo_parcial(double saldo_parcial) {
        this.saldo_parcial = saldo_parcial;
    }

    
    
}