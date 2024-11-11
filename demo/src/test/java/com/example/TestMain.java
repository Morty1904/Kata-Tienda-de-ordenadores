package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class TestMain {
    private TiendaComputadores tienda;

    @BeforeEach
    public void setUp() {
        tienda = new TiendaComputadores("Rick's Garage", "Morty", "12345XYZ");
        tienda.agregarComputador(new Computador("HP", 16, "Intel i7", "Windows 10", 1200.0));
        tienda.agregarComputador(new Computador("ASUS", 8, "Intel i5", "Windows 10", 800.0));
    }

    @Test
    public void testEliminarComputadorNoExistente() {
        String input = "2\nLenovo\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("No se encontró un computador con esa marca."));
    }

    @Test
    public void testListarComputadores() {
        String input = "3\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("HP"));
        assertTrue(output.contains("ASUS"));
    }

    @Test
    public void testSalir() {
        String input = "4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("¡Hasta luego!"));
    }
}