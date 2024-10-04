package com.betek.nivelacion.reservas.model;

public class VehiculoElectrico extends Vehiculo  {

    private int autonomiaBateria;
    private int capacidadBateria;

    public VehiculoElectrico(String matricula, String marca, String modelo, CategoriaVehiculo categoriaVehiculo, int autonomia, int capacidadBateria) {
        super(matricula, marca, modelo, categoriaVehiculo);
        this.autonomiaBateria = autonomia;
        this.capacidadBateria = capacidadBateria;
    }

    public int getAutonomiaBateria() {
        return autonomiaBateria;
    }

    public void setAutonomiaBateria(int autonomiaBateria) {
        this.autonomiaBateria = autonomiaBateria;
    }

    public int getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(int capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }
}
