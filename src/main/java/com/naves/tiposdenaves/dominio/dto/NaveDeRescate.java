package com.naves.tiposdenaves.dominio.dto;

import com.naves.tiposdenaves.dominio.intefaces.DeRescateInterfaz;
import com.naves.tiposdenaves.dominio.intefaces.NavegacionInterfaz;
import com.naves.tiposdenaves.dominio.intefaces.TripuladasInterfaz;

public class NaveDeRescate extends NaveEspacial implements TripuladasInterfaz, NavegacionInterfaz, DeRescateInterfaz {

    public NaveDeRescate(String nombre, String pais, Integer altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible, Double orbita, Integer cantidadTripulacion) {
        super(nombre, pais, altura, empuje, cantidadCargaOrbita, estado, combustible, orbita, cantidadTripulacion);
    }

    @Override
    public void despegar(String nombre) {
        super.despegar(nombre);
    }

    @Override
    public void aterrizar(String nombre) {
        super.aterrizar(nombre);
    }

    @Override
    public void definirDestino() {
        System.out.println("Definiendo centro Hospitalario para la atencion de pacientes en estado critico");
    }

    @Override
    public void orbitar() {
        System.out.println("Inciando orbitaje mientras se estabilizan pacientes heridos");
    }

    @Override
    public void transportePasajeros() {
        System.out.println("Inicien el transporte del personal herido");
    }

    @Override
    public void curacionHeridos() {
        System.out.println("Inicien el protocolo de de emergencia");
        System.out.println("Inicien triage de heridos");
    }
}
