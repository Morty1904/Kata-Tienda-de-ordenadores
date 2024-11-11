package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TiendaComputadoresTest {
    private TiendaComputadores tienda;
    private Computador computador1;
    private Computador computador2;

    @BeforeEach
    public void setUp() {
        tienda = new TiendaComputadores("Tienda Tech", "Morty", "12345XYZ");
        computador1 = new Computador("HP", 16, "Intel i7", "Windows 10", 1200.0);
        computador2 = new Computador("Dell", 8, "Intel i5", "Windows 10", 800.0);
        tienda.agregarComputador(computador1);
        tienda.agregarComputador(computador2);
    }

    @Test
    public void testAgregarComputador() {
        Computador computador3 = new Computador("Apple", 16, "M1", "macOS", 1500.0);
        tienda.agregarComputador(computador3);
        assertEquals(3, tienda.listarComputadores().size());
    }

    @Test
    public void testEliminarComputador() {
        boolean eliminado = tienda.eliminarComputador("HP");
        assertTrue(eliminado);
        assertEquals(1, tienda.listarComputadores().size());
    }

    @Test
    public void testEliminarComputadorNoExistente() {
        boolean eliminado = tienda.eliminarComputador("Lenovo");
        assertFalse(eliminado);
        assertEquals(2, tienda.listarComputadores().size());
    }

    @Test
    public void testBuscarComputadorExistente() {
        Computador encontrado = tienda.buscarComputador("HP");
        assertNotNull(encontrado);
        assertEquals("HP", encontrado.getMarca());
    }

    @Test
    public void testBuscarComputadorNoExistente() {
        Computador encontrado = tienda.buscarComputador("Acer");
        assertNull(encontrado);
    }

    @Test
    public void testListarComputadores() {
        assertEquals(2, tienda.listarComputadores().size());
    }
}