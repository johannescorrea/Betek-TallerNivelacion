package com.betek.nivelacion.reservas;

import java.util.Objects;

public abstract class Vehiculo implements Alquilable {

    private String matricula;
    private String marca;
    private String modelo;

    private boolean estaAlquilado;


    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }


    @Override
    public void alquilar() {
        if (!estaAlquilado){// false
            estaAlquilado = true;
            System.out.println("Vehiculo alquilado: " + getModelo());
        } else {
            System.out.println("El vehiculo ya esta alquilado.");
        }
    }

    @Override
    public void devolverVehiculo() {
        if (estaAlquilado){ //true
            estaAlquilado = false;
            System.out.println("Vehiculo devuelto: " + getModelo());
        } else {
            System.out.println("El vehiculo no estaba alquilado");
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo vehiculo)) return false;

        return Objects.equals(matricula, vehiculo.matricula) && Objects.equals(marca, vehiculo.marca) && Objects.equals(modelo, vehiculo.modelo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(matricula);
        result = 31 * result + Objects.hashCode(marca);
        result = 31 * result + Objects.hashCode(modelo);
        return result;
    }
}
