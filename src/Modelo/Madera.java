package Modelo;

public class Madera {

    private int idmadera;
    private String nombre;
    private String color;

    public Madera() {
    }

    public Madera(int idmadera, String nombre, String color) {
        this.idmadera = idmadera;
        this.nombre = nombre;
        this.color = color;
    }

    public int getIdmadera() {
        return idmadera;
    }

    public void setIdmadera(int idmadera) {
        this.idmadera = idmadera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
