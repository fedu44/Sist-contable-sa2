package Modelo;

public class Familia {

    private int idfamilia;
    private String nombre;

    public Familia() {
    }

    public Familia(int idfamilia, String nombre) {
        this.idfamilia = idfamilia;
        this.nombre = nombre;
    }

    public int getIdfamilia() {
        return idfamilia;
    }

    public void setIdfamilia(int idfamilia) {
        this.idfamilia = idfamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
