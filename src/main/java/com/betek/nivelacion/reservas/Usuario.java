package com.betek.nivelacion.reservas;

public class Usuario {

    //Encapsulamiento
    //public  == puede ser accedido por cualquier clase
    //private  == solo puede ser accedido por su misma clase o utilizando metodos para acceder a ellos
    //protected == herencia solo son accedidos por hijos o clases padre
    //default == por defecto

   private String nombre;
   private String email;

   //constructor
    public Usuario(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
    }

    //get == ver el contenido de la variable
    //set == modificar o asignar el contenido de la variable


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
}
