package com.betek.nivelacion.reservas;

import com.betek.nivelacion.reservas.exceptions.MaxCapacityException;
import com.betek.nivelacion.reservas.exceptions.MaxCapacityRuntimeException;
import com.betek.nivelacion.reservas.model.Coche;
import com.betek.nivelacion.reservas.model.Reserva;
import com.betek.nivelacion.reservas.model.Usuario;
import com.betek.nivelacion.reservas.model.Vehiculo;

public class MainArray {

    public static void main(String[] args)  {
        SistemaReservasArray sistemaReservas = new SistemaReservasArray(2);

        Usuario usuario1 = new Usuario("CC", "12345678A", "Pepe Perez", "email@to.com");
        Vehiculo v1 = new Coche("1234ABC", "Seat", "Ibiza");

        Reserva reserva1 = new Reserva(usuario1, v1);
        try {
            //ejecuto mi logica
            sistemaReservas.agregarReservaRuntime(reserva1);
            sistemaReservas.agregarReserva(reserva1);

        } catch (MaxCapacityException | MaxCapacityRuntimeException exception) {
            //Manejo la excepcion
            System.out.println(exception.getMessage());
        } finally {
            //Siempre se ejecuta
            System.out.println("Entrando al finally");
            sistemaReservas.mostrarReservas();
        }


    }
}
