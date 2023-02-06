package com.naves.tiposdenaves.dominio.repositorio;

import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;

import java.util.List;

public interface TipoDeNaveDRepositorio {
    List<TipoDeNaveD> listaTiposDeNaves();

    void crearTipoDeNave(TipoDeNaveD tipoDeNaveD);

    List<TipoDeNaveD> listaTiposDeNavesPorTipo(String tipo);

}
