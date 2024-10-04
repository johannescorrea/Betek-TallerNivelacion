package com.betek.nivelacion.reservas.model;

import java.time.LocalDate;

public class Factura {
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Vehiculo vehiculo;
    private double precioFinal;

    public Factura(Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin, Vehiculo vehiculo, double precioFinal) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vehiculo = vehiculo;
        this.precioFinal = precioFinal;
    }

    // Getters and setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}