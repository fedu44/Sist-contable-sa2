package Modelo;

public class Asiento {

    private int idasiento;
    private int numAsiento;
    private String fecha;
    private String descripcion;
    private int usuario;

    public Asiento() {

    }

    public int getIdasiento() {
        return idasiento;
    }

    public void setIdasiento(int idasiento) {
        this.idasiento = idasiento;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

}
