package com.naves.tiposdenaves.dominio.dto;

import com.naves.tiposdenaves.persistencia.entidades.Nave;


public class TipoDeNaveD {
    private Integer id;
    private String tipo;
    private NaveD nave;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NaveD getNave() {
        return nave;
    }

    public void setNave(NaveD nave) {
        this.nave = nave;
    }
}

