package com.betek.nivelacion.reservas;

import com.betek.nivelacion.reservas.exceptions.MaxCapacityException;
import com.betek.nivelacion.reservas.exceptions.MaxCapacityRuntimeException;
import com.betek.nivelacion.reservas.model.Reserva;
import com.betek.nivelacion.reservas.model.Usuario;

public class SistemaReservasArray {


    private Reserva reserva;

    private Reserva[] reservas;
    private int contador;

    public SistemaReservasArray(int capacidad) {
        reservas = new Reserva[capacidad];
        contador = 0;
    }

    // Agregar una reserva
    public void agregarReserva(Reserva reserva) throws MaxCapacityException {
        if (contador < reservas.length) {
            reservas[contador++] = reserva;
        } else {
            System.out.println("Capacidad máxima alcanzada.");
            throw new MaxCapacityException("Capacidad máxima alcanzada.");
        }
    }

    public void agregarReservaRuntime(Reserva reserva) {
        if (contador < reservas.length) {
            reservas[contador++] = reserva;
        } else {
            System.out.println("Capacidad máxima alcanzada.");
            throw new MaxCapacityRuntimeException("Capacidad máxima alcanzada.");
        }
    }

    // Buscar una reserva por usuario
    public Reserva buscarReservaPorUsuario(Usuario usuario) {
        for (int i = 0; i < contador; i++) {
            if (reservas[i].getUsuario().equals(usuario)) {
                return reservas[i];
            }
        }
        return null;
    }

    // Eliminar una reserva (anulándola en el array)
    public void eliminarReserva(Reserva reserva) {
        for (int i = 0; i < contador; i++) {
            if (reservas[i].equals(reserva)) {
                reservas[i] = null;
                System.out.println("Reserva eliminada.");
                break;
            }
        }
    }

    // Mostrar todas las reservas
    public void mostrarReservas() {
        for (int i = 0; i < contador; i++) {
            if (reservas[i] != null) {
                System.out.println(reservas[i].toString());
            }
        }
    }

    public int getNumeroReservas() {
        return contador;
    }
}
