package Modelo;

public class Usuario {

    private int idusuario;
    private String nombre;
    private String contrasena;
    private int tipoUsuario;
    private String nombreTipo;
    private int editor;
    private int empresa;

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombre_tipo) {
        this.nombreTipo = nombre_tipo;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEditor() {
        return editor;
    }

    public void setEditor(int editor) {
        this.editor = editor;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
    
    
    
    

}
