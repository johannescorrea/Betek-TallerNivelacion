package com.betek.nivelacion.reservas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SistemaReservas {

    private Map<Usuario, Set<Reserva>> mapaReservas;

    public SistemaReservas() {
        mapaReservas = new HashMap<>();
    }

    public Usuario registrarUsuario(String tipoDocumento, String documento, String nombre, String email) {
        Usuario usuario = new Usuario(tipoDocumento, documento, nombre, email);
        registrarUsuario(usuario);
        return usuario;
    }

    public void registrarUsuario(Usuario usuario) {
        if (!mapaReservas.containsKey(usuario)) {
            mapaReservas.put(usuario, new HashSet<>());
        }
    }

    // Agregar una reserva al mapa, usando el nombre del usuario como clave
    public void agregarReserva(Reserva reserva) {
        Usuario usuario = reserva.getUsuario();
        if (!mapaReservas.containsKey(usuario)) {
            registrarUsuario(usuario);
        }
        mapaReservas.get(usuario).add(reserva);
    }

    // Buscar una reserva por nombre de usuario
    public Set<Reserva> buscarReservasPorUsuario(Usuario usuario) {
        return mapaReservas.get(usuario);
    }

    // Eliminar una reserva por nombre de usuario
    public boolean eliminarReserva(Reserva reserva) {
        boolean eliminado = false;
        Usuario usuario = reserva.getUsuario();
        if (mapaReservas.containsKey(usuario)) {
            eliminado = mapaReservas.get(usuario).remove(reserva);
        }
        return eliminado;
    }

    // Mostrar todas las reservas
    public void mostrarReservas() {
        for (Usuario nombreUsuario : mapaReservas.keySet()) {
            System.out.println("Usuario: " + nombreUsuario.getNombre() + ", " + mapaReservas.get(nombreUsuario).size());
        }
    }
}
