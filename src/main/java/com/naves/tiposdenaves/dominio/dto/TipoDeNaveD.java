package com.naves.tiposdenaves.dominio.dto;


public class TipoDeNaveD {
    private Integer id;
    private String tipo;
    private NaveEspacial nave;

    public TipoDeNaveD() {
    }

    public TipoDeNaveD( String tipo, NaveEspacial nave) {
        this.tipo = tipo;
        this.nave = nave;
    }

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

    public NaveEspacial getNave() {
        return nave;
    }

    public void setNave(NaveEspacial nave) {
        this.nave = nave;
    }
}

