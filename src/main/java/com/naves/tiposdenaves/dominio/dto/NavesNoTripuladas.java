package com.naves.tiposdenaves.dominio.dto;

import com.naves.tiposdenaves.dominio.intefaces.NavegacionInterfaz;
import com.naves.tiposdenaves.dominio.intefaces.NoTripuladasInterfaz;

public class NavesNoTripuladas extends NaveEspacial implements NoTripuladasInterfaz, NavegacionInterfaz {
    public NavesNoTripuladas( String nombre, String pais, Integer altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible, Double orbita, Integer cantidadTripulacion) {
        super( nombre, pais, altura, empuje, cantidadCargaOrbita, estado, combustible, orbita, cantidadTripulacion);
    }

    @Override
    public void definirDestino() {
        System.out.println("Definiendo Destino o ruta ");
    }

    @Override
    public void orbitar() {
        System.out.println("Navegacion configurada para orbitar");
    }

    @Override
    public void abastercer() {
        System.out.println("Abasteciendo estacion EEI");
    }

    @Override
    public void investigar() {
        System.out.println("Iniciando investigacion de superficie");
    }

    @Override
    public void capturarImagenes() {
        System.out.println("Capturando imagenes de exploracion");
    }
}
