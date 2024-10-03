package com.betek.nivelacion.reservas;

import java.util.*;
import java.util.stream.Collectors;

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

    //Buscar reserva por Vehiculo
    public Set<Reserva> buscarReservasPorVehiculo(Vehiculo vehiculo){
        return mapaReservas.values().stream()
                .flatMap(Set::stream)
                .filter(reserva -> reserva.getVehiculo().equals(vehiculo))
                .collect(Collectors.toSet());

    }

    //Buscar Usuarios con reservas activas
    public List<Usuario> buscarUsuariosConReservasActivas(){
        return mapaReservas.entrySet().stream()
                //filtrar usuarios que tienen alm menos una reserva activa
                .filter(entry -> entry.getValue().stream().anyMatch(reserva -> reserva.getFechaFin() == null))
                //Mappear cada entrada para obtener solo los usuarios
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    //Eliminar todas las reservas de un usuario
    public boolean eliminarReservasPorUsuario(Usuario usuario){
        return Optional.ofNullable(mapaReservas.remove(usuario)).isPresent();
    }

    //Obtener un resumen de reservaspor usuario
    public Map<String, Integer> obtenerResumenDeReservas(){
        //Convertir las entradas del mapa a un stream
        return mapaReservas.entrySet().stream()
                .collect(Collectors.toMap(
                       entry -> entry.getKey().getNombre(), // El nombre del usuario es la clave
                       entry -> entry.getValue().size()     //El numero de reservas es el valor

                ));
    }


    //Buscar usuarios sin reservas
    public List<Usuario> buscarUsuariosSinReservas(){
        return mapaReservas.entrySet().stream()
                .filter(entry -> entry.getValue().isEmpty())
                //Mapear solo los usuarios
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }


    //Conocer el numero total de reservas de todos los usuarios
    public long contarTotalReservas(){
        return mapaReservas.values().stream() //varios conjuntos de set
                .flatMap(Set::stream)         //uhn solo stream
                .count();
    }

    //Listar los usuarios con mas de 1 reserva activa
    public List<Usuario> listarUsuariosConMasDeUnaReservaActiva(){
        return mapaReservas.entrySet().stream()
                //Filtrar losusuarios con masde 1 reserva activa
                .filter(entry -> entry.getValue().stream()
                        .filter(reserva -> reserva.getFechaFin() == null)
                        .count() > 1)

                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }



    //Obtener la reserva mas antigua de un usuario(basada en la fecha de Inicio)
    public Optional<Reserva> obtenerReservaMasAntigua(Usuario usuario){
        return Optional.ofNullable(mapaReservas.get(usuario))
                .flatMap(reservas -> reservas.stream()
                        .min(Comparator.comparing(Reserva::getFechaInicio)));
    }



}
