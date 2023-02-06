package com.naves.tiposdenaves.dominio.dto;

public class NaveLazandera extends NaveEspacial{
    public NaveLazandera(String nombre, String pais, Integer altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible ) {
        super(nombre, pais, altura, empuje, cantidadCargaOrbita, estado, combustible, null, null);
    }
}
