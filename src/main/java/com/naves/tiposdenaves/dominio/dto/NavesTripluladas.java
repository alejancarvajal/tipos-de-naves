package com.naves.tiposdenaves.dominio.dto;

import com.naves.tiposdenaves.dominio.intefaces.NavegacionInterfaz;
import com.naves.tiposdenaves.dominio.intefaces.TripuladasInterfaz;

public class NavesTripluladas extends NaveEspacial implements TripuladasInterfaz, NavegacionInterfaz {
    public NavesTripluladas(String nombre, String pais, Integer altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible, Double orbita, Integer cantidadTripulacion) {
        super(nombre, pais, altura, empuje, cantidadCargaOrbita, estado, combustible, orbita, cantidadTripulacion);
    }

    @Override
    public void definirDestino() {
        System.out.println("Definiendo Destino");
    }

    @Override
    public void orbitar() {
        System.out.println("Iniciando orbitacion para regular sistema he iniciar luego el destino");
    }

    @Override
    public void transportePasajeros() {
        System.out.println("Iniciando abordaje");
        System.out.println("Terminando abordaje");
        System.out.println("Definiendo Destino o ruta ");
    }

    @Override
    public void despegar(String nombre) {
        super.despegar(nombre);
    }

    @Override
    public void aterrizar(String nombre) {
        super.aterrizar(nombre);
    }
}
