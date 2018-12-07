package Modelo;

public class Telefono {

    private String numero;
    private int persona;

    public Telefono() {
    }

    public Telefono(String numero, int persona) {
        this.numero = numero;
        this.persona = persona;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    

}
