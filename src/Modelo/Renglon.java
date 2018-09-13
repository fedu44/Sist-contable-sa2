package Modelo;

public class Renglon {

    private double debe = 0;
    private double haber = 0;
    private String cuenta = "";
    private String fecha;

    public Renglon( String cuenta, double debe, double haber) {
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
    }
    
    public Renglon( String fecha, String cuenta, double debe, double haber) {
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
        this.fecha = fecha;
    }

    public Renglon() {

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getDebe() {
        return debe;
    }

    public double getHaber() {
        return haber;
    }

    public String getCuenta() {
        return cuenta;
    }

    private String relleno(int n) {
        String rel = "";
        for (int i = 0; i < n; i++) {
            rel += " ";
        }
        return rel;
    }

    public String toString() {
        //String espCuenta=cuenta.substring(0, 3);
        String espCuenta = cuenta + relleno(50 - cuenta.length());

        //String strDebe= String.valueOf(debe);
        // String espDebe=strDebe.substring(0, 15)+ relleno(15-strDebe.length());
        return espCuenta + haber;
    }

}
