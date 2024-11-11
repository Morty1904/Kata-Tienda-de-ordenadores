package com.example;

import java.util.ArrayList;
import java.util.List;

public class TiendaComputadores {
    private List<Computador> computadores;

    public TiendaComputadores(String nombreTienda, String propietario, String identificadorTributario) {
        this.computadores = new ArrayList<>();
    }

    public void agregarComputador(Computador computador) {
        computadores.add(computador);
    }

    public boolean eliminarComputador(String marca) {
        return computadores.removeIf(c -> c.getMarca().equalsIgnoreCase(marca));
    }

    public Computador buscarComputador(String marca) {
        for (Computador c : computadores) {
            if (c.getMarca().equalsIgnoreCase(marca)) {
                return c;
            }
        }
        return null;
    }

    public List<Computador> listarComputadores() {
        return new ArrayList<>(computadores);
    }
}