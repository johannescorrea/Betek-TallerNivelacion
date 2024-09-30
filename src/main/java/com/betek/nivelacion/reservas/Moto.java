package com.betek.nivelacion.reservas;

public class Moto extends Vehiculo implements Alquilable{

    private boolean estaAlquilada;

    public Moto(String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
        this.estaAlquilada = false;
    }



    @Override
    public void alquilar() {
        if (!estaAlquilada){// false
            estaAlquilada = true;
            System.out.println("Moto alquilada: " + getModelo());
        } else {
            System.out.println("La moto ya esta alquilada.");
        }
    }



    @Override
    public void devolverVehiculo() {
        if (estaAlquilada){ //true
            estaAlquilada = false;
            System.out.println("Moto devuelta: " + getModelo());
        } else {
            System.out.println("La moto no estaba alquilada");
        }
    }
}
