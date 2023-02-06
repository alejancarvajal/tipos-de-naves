package com.naves.tiposdenaves.dominio.dto;

public class NaveDeCombate extends NaveEspacial {
    public NaveDeCombate( String nombre, String pais, Integer altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible, Double orbita, Integer cantidadTripulacion) {
        super( nombre, pais, altura, empuje, cantidadCargaOrbita, estado, combustible, orbita, cantidadTripulacion);
    }
}
