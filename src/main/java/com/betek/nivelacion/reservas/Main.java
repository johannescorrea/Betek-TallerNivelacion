package com.betek.nivelacion.reservas;

import com.betek.nivelacion.reservas.model.CategoriaVehiculo;
import com.betek.nivelacion.reservas.model.Coche;
import com.betek.nivelacion.reservas.model.Factura;
import com.betek.nivelacion.reservas.model.Promocion;
import com.betek.nivelacion.reservas.model.Reserva;
import com.betek.nivelacion.reservas.model.TipoUsuario;
import com.betek.nivelacion.reservas.model.Usuario;
import com.betek.nivelacion.reservas.model.Vehiculo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Create SistemaReservas instance
        SistemaReservas sistemaReservas = new SistemaReservas();

        // Create TipoUsuario
        TipoUsuario tipoUsuario = new TipoUsuario("Regular", "Regular users", 0.1); // 10% discount
        sistemaReservas.agregarTipoUsuario(tipoUsuario);

        // Create CategoriaVehiculo
        CategoriaVehiculo categoriaVehiculo = new CategoriaVehiculo("SUV", "Suburvan Vehiculo", 100.0); // Base price 100
        sistemaReservas.agregarCategoriaVehiculo(categoriaVehiculo);

        // Create Usuario
        Usuario usuario = new Usuario("DNI", "12345678", "John Doe", "john.doe@example.com");
        sistemaReservas.registrarUsuario(usuario);

        // Create Coche
        Coche coche = new Coche("ABC123", "Toyota", "RAV4", categoriaVehiculo);

        // Create Promocion
        Promocion promocion = new Promocion(LocalDate.now().minusDays(1), LocalDate.now().plusDays(10), categoriaVehiculo, tipoUsuario); // 20% discount
        sistemaReservas.agregarPromocion(promocion);

        // Create Reserva
        Reserva reserva = new Reserva(usuario, coche, LocalDate.now(), LocalDate.now().plusDays(5));
        sistemaReservas.agregarReserva(reserva);

        // Finalize Reserva and get Factura
        Factura factura = sistemaReservas.finalizarReserva(reserva);

        // Print Factura details
        System.out.println("Factura:");
        System.out.println("Usuario: " + factura.getUsuario().getNombre());
        System.out.println("Fecha Inicio: " + factura.getFechaInicio());
        System.out.println("Fecha Fin: " + factura.getFechaFin());
        System.out.println("Vehiculo: " + factura.getVehiculo().getMatricula());
        System.out.println("Precio Final: " + factura.getPrecioFinal());
    }

    private static void colecciones() {
        List<Integer> lista = List.of(1, 1, 1, 1, 1, 4, 5);
        Set<Integer> set = new HashSet<>(lista);

        System.out.println(lista.size());
        System.out.println(set.size());
    }
}
