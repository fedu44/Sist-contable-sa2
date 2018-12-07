package Modelo;

public class Cliente {

    private int id;
    private String nombre_nombreFiscal;
    private String cuit_cuil;
    private String calle;
    private int numeroCasa;
    private String piso;
    private String depto;
    private int situacionCrediticia;
    private boolean bloqueado;
    private int tipoCliente;
    private String periodoValidez;
    private double limiteCredito;
    private String ultimaOperacion;
    private String fechaAlta;
    private int categoriaIva;
    private String nota;
    private String contacto;

    public Cliente() {
    }

    public Cliente(int id, String nombre_nombreFiscal, String cuit_cuil, String calle, int numeroCasa, String piso, String depto, int situacionCrediticia, boolean bloqueado, int tipoCliente, String periodoValidez, double limiteCredito, String ultimaOperacion, String fechaAlta, int categoriaIva, int telefono, String nota, String contacto) {
        this.id = id;
        this.nombre_nombreFiscal = nombre_nombreFiscal;
        this.cuit_cuil = cuit_cuil;
        this.calle = calle;
        this.numeroCasa = numeroCasa;
        this.piso = piso;
        this.depto = depto;
        this.situacionCrediticia = situacionCrediticia;
        this.bloqueado = bloqueado;
        this.tipoCliente = tipoCliente;
        this.periodoValidez = periodoValidez;
        this.limiteCredito = limiteCredito;
        this.ultimaOperacion = ultimaOperacion;
        this.fechaAlta = fechaAlta;
        this.categoriaIva = categoriaIva;
        this.nota = nota;
        this.contacto = contacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_nombreFiscal() {
        return nombre_nombreFiscal;
    }

    public void setNombre_nombreFiscal(String nombre_nombreFiscal) {
        this.nombre_nombreFiscal = nombre_nombreFiscal;
    }

    public String getCuit_cuil() {
        return cuit_cuil;
    }

    public void setCuit_cuil(String cuit_cuil) {
        this.cuit_cuil = cuit_cuil;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public int getSituacionCrediticia() {
        return situacionCrediticia;
    }

    public void setSituacionCrediticia(int situacionCrediticia) {
        this.situacionCrediticia = situacionCrediticia;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getPeriodoValidez() {
        return periodoValidez;
    }

    public void setPeriodoValidez(String periodoValidez) {
        this.periodoValidez = periodoValidez;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getUltimaOperacion() {
        return ultimaOperacion;
    }

    public void setUltimaOperacion(String ultimaOperacion) {
        this.ultimaOperacion = ultimaOperacion;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getCategoriaIva() {
        return categoriaIva;
    }

    public void setCategoriaIva(int categoriaIva) {
        this.categoriaIva = categoriaIva;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

}
