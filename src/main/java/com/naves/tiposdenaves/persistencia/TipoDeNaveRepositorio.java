package com.naves.tiposdenaves.persistencia;

import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.dominio.repositorio.TipoDeNaveDRepositorio;
import com.naves.tiposdenaves.persistencia.crud.TipoDeNaveCrudRepositorio;
import com.naves.tiposdenaves.persistencia.entidades.TipoDeNave;
import com.naves.tiposdenaves.persistencia.mappeador.TipoDeNaveDMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TipoDeNaveRepositorio implements TipoDeNaveDRepositorio {

    @Autowired
    TipoDeNaveDMapeador mapeador;

    @Autowired
    private TipoDeNaveCrudRepositorio tipoDeNaveCrudRepositorio;

    public List<TipoDeNaveD> listaTiposDeNaves() {
        List<TipoDeNave> tipodenave = (List<TipoDeNave>) tipoDeNaveCrudRepositorio.findAll();
        return tipodenave.stream().map(tipo1 -> mapeador.toTipoDeNaveD(tipo1)).collect(Collectors.toList());

    }

    @Override
    public void crearTipoDeNave(TipoDeNaveD tipoDeNaveD) {
        TipoDeNave tipoDeNave = mapeador.toTipoDeNave(tipoDeNaveD);
        tipoDeNaveCrudRepositorio.save(tipoDeNave);
    }

}
