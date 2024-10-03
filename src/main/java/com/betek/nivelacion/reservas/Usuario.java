package com.betek.nivelacion.reservas;

public class Usuario {

    //Encapsulamiento
    //public  == puede ser accedido por cualquier clase
    //private  == solo puede ser accedido por su misma clase o utilizando metodos para acceder a ellos
    //protected == herencia solo son accedidos por hijos o clases padre
    //default == por defecto

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String email;

    //constructor
    public Usuario(String tipoDocumento, String numeroDocumento, String nombre, String email) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.email = email;
    }

    //get == ver el contenido de la variable
    //set == modificar o asignar el contenido de la variable


    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true; //Compara si el objeto o es la misma instancia, la misma referencia del objeto actual
        if (!(o instanceof Usuario usuario)) return false;

        return tipoDocumento.equals(usuario.tipoDocumento) && numeroDocumento.equals(usuario.numeroDocumento);
    }

    @Override
    public int hashCode() {
        int result = tipoDocumento.hashCode();
        result = 31 * result + numeroDocumento.hashCode();
        return result;
    }
}
