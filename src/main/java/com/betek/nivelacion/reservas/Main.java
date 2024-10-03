package com.betek.nivelacion.reservas;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("CC", "12345678A", "Pepe Perez", "email@to.com");
        Vehiculo v1 = new Coche("1234ABC", "Seat", "Ibiza");

        Reserva reserva1 = new Reserva(usuario1, v1);

        SistemaReservas sistemaReservas = new SistemaReservas();
        sistemaReservas.agregarReserva(reserva1);
        sistemaReservas.agregarReserva(reserva1);

        sistemaReservas.mostrarReservas();

        colecciones();
    }

    private static void colecciones() {
        List<Integer> lista = List.of(1, 1, 1, 1, 1, 4, 5);
        Set<Integer> set = new HashSet<>(lista);

        System.out.println(lista.size());
        System.out.println(set.size());
    }
}
