package Modelo;

public class Renglon {

    private double debe = 0;
    private double haber = 0;
    private String cuenta = "";
    private String fecha;
    private double saldo_parcial;
    private String descripcion;
    private String nombre;
    private String cuit_cuil;
    private String situacion_crediticia;
    private String fecha_alta;
    private String limite_credito;
    private int total;
    private int disponibles;

    public Renglon(String cuenta, double debe, double haber) {
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
    }

    public Renglon(String nombre, String cuit_cuil, String situacion_crediticia, String limite_credito, String fecha_alta) {
        this.nombre = nombre;
        this.cuit_cuil = cuit_cuil;
        this.situacion_crediticia = situacion_crediticia;
        this.fecha_alta = fecha_alta.substring(0,19);
        this.limite_credito = limite_credito;
    }

    public Renglon(String fecha, String cuenta, double debe, double haber, double saldo_parcial) {
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
        this.fecha = fecha;
        this.saldo_parcial = saldo_parcial;
    }

    public Renglon(String fecha, String cuenta, double debe, double haber, String descripcion) {
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Renglon(String fecha, String cuenta, double debe, double haber, double saldo_parcial, String descripcion) {
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
        this.fecha = fecha;
        this.saldo_parcial = saldo_parcial;
        this.descripcion = descripcion;
    }
    
    public Renglon(String nombre, int disponibles, String descripcion, int total) {
        this.nombre = nombre;
        this.disponibles = disponibles;
        this.descripcion = descripcion;
        this.total = total;
        
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Renglon(String fecha, String cuenta, double debe, double haber) {
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
        this.fecha = fecha;
    }

    public Renglon() {

    }

    public double getSaldo_parcial() {
        return saldo_parcial;
    }

    public void setSaldo_parcial(double saldo_parcial) {
        this.saldo_parcial = saldo_parcial;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit_cuil() {
        return cuit_cuil;
    }

    public void setCuit_cuil(String cuit_cuil) {
        this.cuit_cuil = cuit_cuil;
    }

    public String getSituacion_crediticia() {
        return situacion_crediticia;
    }

    public void setSituacion_crediticia(String situacion_crediticia) {
        this.situacion_crediticia = situacion_crediticia;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(String limite_credito) {
        this.limite_credito = limite_credito;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
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
