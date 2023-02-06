package com.naves.tiposdenaves.dominio.dto;

import com.naves.tiposdenaves.dominio.intefaces.DeCombateInterfaz;
import com.naves.tiposdenaves.dominio.intefaces.NavegacionInterfaz;
import com.naves.tiposdenaves.dominio.intefaces.TripuladasInterfaz;

public class NaveDeCombate extends NaveEspacial implements TripuladasInterfaz, NavegacionInterfaz, DeCombateInterfaz {
    public NaveDeCombate(String nombre, String pais, Integer altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible, Double orbita, Integer cantidadTripulacion) {
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
    public void transportePasajeros() {
        System.out.println("Iniciando el abordaje de escuadron");
        System.out.println("Terminando el abordaje de escuadron");
    }

    @Override
    public void definirDestino() {
        System.out.println("El destino para atacar ha sido recibo");
    }

    @Override
    public void orbitar() {
        System.out.println("Iniciando Orbitaje, incien protocolo de armamento");
    }

    @Override
    public void defender() {
        System.out.println("Iniciando defensiva");
        atacar("defensivo");
    }

    @Override
    public void atacar() {
        System.out.println("Iniciando ataque");

    }
    public void atacar(String tipo) {
        System.out.println("Iniciando ataque "+ tipo);

    }

    @Override
    public void retirada() {
        System.out.println("Iniciando Retirada");
        atacar("de cobertura");
    }
}
