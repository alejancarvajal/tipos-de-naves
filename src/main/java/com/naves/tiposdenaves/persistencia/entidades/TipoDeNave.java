package com.naves.tiposdenaves.persistencia.entidades;



import javax.persistence.*;

@Table(name = "tipo_de_nave")
@Entity
public class TipoDeNave {
    public TipoDeNave() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_nave")
    private Nave nave;


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

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }
}
