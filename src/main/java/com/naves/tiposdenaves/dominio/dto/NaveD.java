package com.naves.tiposdenaves.dominio.dto;


public abstract class NaveD {

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

    public NaveD() {
    }

    public NaveD(final String nombre, final String pais, final Integer altura, final Double empuje, final Double cantidadCargaOrbita, final Boolean estado,
                 final String combustible, final Double orbita, final Integer cantidadTripulacion) {

        this.nombre = nombre;
        this.pais = pais;
        this.altura = altura;
        this.empuje = empuje;
        this.cantidadCargaOrbita = cantidadCargaOrbita;
        this.estado = estado;
        this.combustible = combustible;
        this.orbita = orbita;
        this.cantidadTripulacion = cantidadTripulacion;
    }

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

    void despegar(String nombre) {
        System.out.println("Iniciando configuraciones para el despegue");
        System.out.println("Configuraciones terminadas inciando despegue de la nave " + nombre + " en 3");
        System.out.println("2");
        System.out.println("1");
        System.out.println("Ignicion de propulsores");
        System.out.println("Lanzamiento completado");
    }

    ;

    void aterrizar(String nombre) {
        System.out.println("Iniciando configuraciones para el aterrizaje de la nave "+nombre);
    }

    ;
}
