package Modelo;

public class Cuenta {

    private int idcuenta;
    private String tipo;
    private String nombre;
    private int empresa;
    private String codigo;
    private Boolean recibeSaldo;

    public Cuenta() {
    }

    public Cuenta(int idcuenta,String tipo, String nombre, int empresa, String codigo, Boolean recibeSaldo) {
        this.idcuenta = idcuenta;
        this.tipo = tipo;
        this.nombre = nombre;
        this.empresa = empresa;
        this.codigo = codigo;
        this.recibeSaldo = recibeSaldo;
    }
    
    

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getRecibeSaldo() {
        return recibeSaldo;
    }

    public void setRecibeSaldo(Boolean recibeSaldo) {
        this.recibeSaldo = recibeSaldo;
    }

    

}
