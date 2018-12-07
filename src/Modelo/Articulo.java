package Modelo;

public class Articulo {

    private int idarticulo;
    private String nombre;
    private String codigo;
    private String descripcion;
    private int madera;
    private int costo;

    public Articulo() {
    }

    public Articulo(int idarticulo, String nombre, String codigo, String descripcion, int madera, int costo) {
        this.idarticulo = idarticulo;
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.madera = madera;
        this.costo = costo;
    }

    public int getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMadera() {
        return madera;
    }

    public void setMadera(int madera) {
        this.madera = madera;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

}
