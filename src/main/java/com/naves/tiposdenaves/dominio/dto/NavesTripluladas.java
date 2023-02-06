package com.naves.tiposdenaves.dominio.dto;

public class NavesTripluladas extends NaveEspacial {
    public NavesTripluladas( String nombre, String pais, Integer altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible, Double orbita, Integer cantidadTripulacion) {
        super(nombre, pais, altura, empuje, cantidadCargaOrbita, estado, combustible, orbita, cantidadTripulacion);
    }
}
