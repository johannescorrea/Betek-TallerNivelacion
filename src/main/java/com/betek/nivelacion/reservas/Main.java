package com.betek.nivelacion.reservas;

public class Main {

    public static void main(String[] args) {
        int a = 4;
        int b = 5;

        System.out.println(a == b);

        Vehiculo v1 = new Coche("1234ABC", "Ford", "Focus");
        Vehiculo v2 = new Coche("1234ABC", "Ford", "Focus");

        System.out.println(v1.equals(v2));
    }
}
