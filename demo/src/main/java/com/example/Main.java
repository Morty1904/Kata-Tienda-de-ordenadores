package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TiendaComputadores tienda = new TiendaComputadores("Rick's Garage", "Morty", "12345XYZ");

        Computador computador1 = new Computador("HP", 16, "Intel i7", "Windows 10", 1200.0);
        Computador computador2 = new Computador("ASUS", 8, "Intel i5", "Windows 10", 800.0);

        tienda.agregarComputador(computador1);
        tienda.agregarComputador(computador2);

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Mostrar las opciones
            System.out.println("Elija una opción:");
            System.out.println("1. Agregar un computador");
            System.out.println("2. Eliminar un computador");
            System.out.println("3. Listar los computadores actuales");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Agregar un computador
                    System.out.println("Ingrese la marca del computador:");
                    String marca = scanner.nextLine();

                    System.out.println("Ingrese la cantidad de memoria (GB):");
                    int memoria = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea

                    System.out.println("Ingrese el procesador:");
                    String procesador = scanner.nextLine();

                    System.out.println("Ingrese el sistema operativo:");
                    String sistemaOperativo = scanner.nextLine();

                    System.out.println("Ingrese el precio:");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();  // Consumir la nueva línea

                    Computador nuevoComputador = new Computador(marca, memoria, procesador, sistemaOperativo, precio);
                    tienda.agregarComputador(nuevoComputador);
                    System.out.println("Computador agregado con éxito.");
                    break;

                case 2:
                    // Eliminar un computador
                    System.out.println("Ingrese la marca del computador a eliminar:");
                    String marcaEliminar = scanner.nextLine();

                    boolean eliminado = tienda.eliminarComputador(marcaEliminar);
                    if (eliminado) {
                        System.out.println("Computador eliminado.");
                    } else {
                        System.out.println("No se encontró un computador con esa marca.");
                    }
                    break;

                case 3:
                    // Listar los computadores actuales
                    System.out.println("Lista de Computadores:");
                    for (Computador c : tienda.listarComputadores()) {
                        System.out.println(c);
                    }
                    break;

                case 4:
                    // Salir
                    System.out.println("¡Hasta luego!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}