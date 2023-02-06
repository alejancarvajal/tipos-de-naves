package com.naves.tiposdenaves.dominio.dto;

import com.naves.tiposdenaves.dominio.intefaces.LanzaderaInterfaz;

public class NaveLazandera extends NaveEspacial implements LanzaderaInterfaz {
    public NaveLazandera(String nombre, String pais, Integer altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible ) {
        super(nombre, pais, altura, empuje, cantidadCargaOrbita, estado, combustible, null, null);
    }

    @Override
    public void despegar(String nombre) {
        super.despegar(nombre);
    }

    @Override
    public void lanzarCarga() {
        System.out.println("Liberando carga en orbita");
    }
}
