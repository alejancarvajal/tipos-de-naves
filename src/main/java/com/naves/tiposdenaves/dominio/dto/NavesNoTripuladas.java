package com.naves.tiposdenaves.dominio.dto;

public class NavesNoTripuladas extends NaveEspacial {
    public NavesNoTripuladas( String nombre, String pais, Integer altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible, Double orbita, Integer cantidadTripulacion) {
        super( nombre, pais, altura, empuje, cantidadCargaOrbita, estado, combustible, orbita, cantidadTripulacion);
    }
}
