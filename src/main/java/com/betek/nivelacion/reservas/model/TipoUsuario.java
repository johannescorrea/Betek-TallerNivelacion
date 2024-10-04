package com.betek.nivelacion.reservas.model;

public class TipoUsuario {
    private String nombre;
    private String descripcion;
    private double descuentoBase;

    public TipoUsuario(String nombre, String descripcion, double descuentoBase) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuentoBase = descuentoBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuentoBase() {
        return descuentoBase;
    }

    public void setDescuentoBase(double descuentoBase) {
        this.descuentoBase = descuentoBase;
    }
}