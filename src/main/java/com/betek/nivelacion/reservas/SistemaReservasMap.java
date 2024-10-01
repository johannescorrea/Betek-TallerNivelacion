package com.betek.nivelacion.reservas;

import java.time.LocalDate;
import java.util.HashMap;

public class SistemaReservasMap {

    private HashMap<String, Reserva> mapaReservas;

    public SistemaReservasMap() {
        mapaReservas = new HashMap<>();
    }

    // Agregar una reserva al mapa, usando el nombre del usuario como clave
    public void agregarReserva(Usuario usuario, Reserva reserva) {
        mapaReservas.put(usuario.getNombre(), reserva);
    }

    // Buscar una reserva por nombre de usuario
    public Reserva buscarReservaPorUsuario(String nombreUsuario) {
        return mapaReservas.get(nombreUsuario);
    }

    // Eliminar una reserva por nombre de usuario
    public void eliminarReserva(String nombreUsuario) {
        Reserva reserva = mapaReservas.remove(nombreUsuario);
        if (reserva != null) {
            System.out.println("Reserva eliminada.");
        } else {
            System.out.println("No se encontró la reserva.");
        }
    }

    // Mostrar todas las reservas
    public void mostrarReservas() {
        for (String nombreUsuario : mapaReservas.keySet()) {
            System.out.println("Usuario: " + nombreUsuario + ", " + mapaReservas.get(nombreUsuario).toString());
        }
    }
}
