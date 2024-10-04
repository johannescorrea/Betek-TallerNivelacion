package com.betek.nivelacion.reservas;

import com.betek.nivelacion.reservas.exceptions.MaxCapacityException;
import com.betek.nivelacion.reservas.model.Reserva;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SistemaReservasArrayTest {

    private SistemaReservasArray sistemaReservasArray;
    private static List<Reserva> reservas;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Antes de todos los test");
        Reserva reserva1 = new Reserva(null, null);
        Reserva reserva2 = new Reserva(null, null);

        reservas = List.of(reserva1, reserva2);
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Después de todos los test");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Antes de test");
        sistemaReservasArray = new SistemaReservasArray(3);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Después de test");
    }

    @Test
    void agregarReserva_deberiaAgregarReserva_cuandoTieneCapacidad() throws MaxCapacityException {
        sistemaReservasArray.agregarReserva(reservas.get(0));
        assertEquals(1, sistemaReservasArray.getNumeroReservas());
    }

    @Test
    void agregarReserva_deberiaLanzarExcepcion_cuandoNoTieneCapacidad() {
        sistemaReservasArray = new SistemaReservasArray(0);
        MaxCapacityException ex = assertThrows(MaxCapacityException.class, () -> sistemaReservasArray.agregarReserva(reservas.get(0)));
        assertEquals("Capacidad máxima alcanzada.", ex.getMessage());
    }

}