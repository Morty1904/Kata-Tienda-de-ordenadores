package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputadorTest {
    @Test
    public void testComputadorAttributes() {
        Computador computador = new Computador("Asus", 32, "AMD Ryzen 9", "Windows 11", 2000.0);

        assertEquals("Asus", computador.getMarca());
        assertEquals(32, computador.getMemoria());
        assertEquals("AMD Ryzen 9", computador.getProcesador());
        assertEquals("Windows 11", computador.getSistemaOperativo());
        assertEquals(2000.0, computador.getPrecio());
    }

    @Test
    public void testToString() {
        Computador computador = new Computador("Asus", 32, "AMD Ryzen 9", "Windows 11", 2000.0);
        String expected = "Computador [Marca: Asus, Memoria: 32GB, Procesador: AMD Ryzen 9, Sistema Operativo: Windows 11, Precio: $2000.0]";
        assertEquals(expected, computador.toString());
    }
}