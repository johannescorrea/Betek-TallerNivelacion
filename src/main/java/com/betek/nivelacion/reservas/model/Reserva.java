package com.betek.nivelacion.reservas.model;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva {

    private Usuario usuario;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Constructor para una reserva inmediata
    public Reserva(Usuario usuario, Vehiculo vehiculo) {
        this.usuario = usuario;
        this.vehiculo = vehiculo;
    }

    //Constructor para una reserva con fechas concretas sin vehiculo asignado
    public Reserva(Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Reserva(Usuario usuario, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vehiculo = vehiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate  getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    //Metodo para iniciar una reserva con un vehiculo asignado en la fecha actual.
    public void iniciarReserva() {
        if(vehiculo != null) {
            this.fechaInicio = LocalDate.now();
            vehiculo.alquilar();
        } else {
            System.out.println("El vehiculo no se puede alquilar");
        }
    }

    //Sobrecarga del metodo iniciarReserva para poder asignar un vehiculo
    public void iniciarReserva(Vehiculo vehiculo) {
        if(vehiculo != null) {
            this.vehiculo = vehiculo;
            iniciarReserva();
        }
    }

    //Metodo para finalizar una reserva
    public void finalizarReserva() {
        if(vehiculo != null && fechaInicio != null) {
            vehiculo.devolverVehiculo();
            if(fechaFin == null) {
                fechaFin = LocalDate.now();
            }
        } else {
            System.out.println("No se puede finalizar la reserva");
        }
    }

    public double calcularPrecio() {
        if(vehiculo != null && fechaInicio != null && fechaFin != null) {
            if (vehiculo instanceof Moto) {
                return 10 * fechaInicio.until(fechaFin).getDays();
            } if (vehiculo instanceof VehiculoElectrico) {
                return 30 * fechaInicio.until(fechaFin).getDays();
            } else {
                return 20 * fechaInicio.until(fechaFin).getDays();
            }
        } else {
            return 0;
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva reserva)) return false;

        return usuario.equals(reserva.usuario) && vehiculo.equals(reserva.vehiculo) &&
                Objects.equals(fechaInicio, reserva.fechaInicio) && Objects.equals(fechaFin, reserva.fechaFin);
    }

    @Override
    public int hashCode() {
        int result = usuario.hashCode();
        result = 31 * result + vehiculo.hashCode();
        if (fechaInicio != null) {
            result = 31 * result + fechaInicio.hashCode();
        }
        if (fechaFin != null) {
            result = 31 * result + Objects.hashCode(fechaFin);
        }
        return result;
    }

}
