package com.betek.nivelacion.reservas.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Promocion {

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private CategoriaVehiculo categoriaVehiculo;
    private TipoUsuario tipoUsuario;
    private double descuento;

    public Promocion(LocalDate fechaInicio, LocalDate fechaFin, CategoriaVehiculo categoriaVehiculo, TipoUsuario tipoUsuario) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.categoriaVehiculo = categoriaVehiculo;
        this.tipoUsuario = tipoUsuario;
    }

}