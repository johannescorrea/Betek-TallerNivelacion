package com.betek.nivelacion.reservas;

import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaReservasArrayList {

    private ArrayList<Reserva> listaReservas;

    public SistemaReservasArrayList() {
        listaReservas = new ArrayList<>();
    }

    // Agregar una reserva a la lista
    public void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }

    // Buscar una reserva por usuario
    public Reserva buscarReservaPorUsuario(Usuario usuario) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getUsuario().equals(usuario)) {
                return reserva;
            }
        }
        return null;
    }

    // Eliminar una reserva
    public boolean eliminarReserva(Reserva reserva) {
        return listaReservas.remove(reserva);
    }

    // Mostrar todas las reservas
    public void mostrarReservas() {
        for (Reserva reserva : listaReservas) {
            System.out.println(reserva.toString());
        }
    }
}
