package com.naves.tiposdenaves.dominio.dto;


public class NaveD {

    private Integer id;
    private String nombre;
    private String pais;
    private Integer altura;
    private Double empuje;
    private Double cantidadCargaOrbita;
    private Boolean estado;
    private String combustible;
    private Double orbita;
    private Integer cantidadTripulacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Double getEmpuje() {
        return empuje;
    }

    public void setEmpuje(Double empuje) {
        this.empuje = empuje;
    }

    public Double getCantidadCargaOrbita() {
        return cantidadCargaOrbita;
    }

    public void setCantidadCargaOrbita(Double cantidadCargaOrbita) {
        this.cantidadCargaOrbita = cantidadCargaOrbita;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Double getOrbita() {
        return orbita;
    }

    public void setOrbita(Double orbita) {
        this.orbita = orbita;
    }

    public Integer getCantidadTripulacion() {
        return cantidadTripulacion;
    }

    public void setCantidadTripulacion(Integer cantidadTripulacion) {
        this.cantidadTripulacion = cantidadTripulacion;
    }

}
