package com.naves.tiposdenaves.persistencia.entidades;


import javax.persistence.*;


@Table(name = "nave")
@Entity
public class Nave {
    public Nave() {
    }

    public Nave(int id, String nombre, String pais,  int altura, Double empuje, Double cantidadCargaOrbita, Boolean estado, String combustible, Double orbita, int cantidadTripulacion) {
        this.id = id;
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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String pais;
    private int altura;
    private Double empuje;
    @Column(name = "cantidad_carga_orbita")
    private Double cantidadCargaOrbita;
    private Boolean estado;
    private String combustible;
    private Double orbita;
    @Column(name = "cantidad_tripulacion")
    private int cantidadTripulacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
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

    public int getCantidadTripulacion() {
        return cantidadTripulacion;
    }

    public void setCantidadTripulacion(int cantidadTripulacion) {
        this.cantidadTripulacion = cantidadTripulacion;
    }
}
