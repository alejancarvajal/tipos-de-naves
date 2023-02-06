package com.naves.tiposdenaves.persistencia;

import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.dominio.repositorio.TipoDeNaveDRepositorio;
import com.naves.tiposdenaves.persistencia.crud.TipoDeNaveCrudRepositorio;
import com.naves.tiposdenaves.persistencia.entidades.TipoDeNave;
import com.naves.tiposdenaves.persistencia.mappeador.TipoDeNaveDMapeador;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TipoDeNaveRepositorio implements TipoDeNaveDRepositorio {

    private final TipoDeNaveDMapeador tipoDeNaveDMapeador;
    private final TipoDeNaveCrudRepositorio tipoDeNaveCrudRepositorio;

    public TipoDeNaveRepositorio(TipoDeNaveDMapeador tipoDeNaveDMapeador, TipoDeNaveCrudRepositorio tipoDeNaveCrudRepositorio) {
        this.tipoDeNaveDMapeador = tipoDeNaveDMapeador;
        this.tipoDeNaveCrudRepositorio = tipoDeNaveCrudRepositorio;
    }

    public List<TipoDeNaveD> listaTiposDeNaves() {
        List<TipoDeNave> tipodenave = (List<TipoDeNave>) tipoDeNaveCrudRepositorio.findAll();
        return tipodenave.stream().map(tipoDeNaveDMapeador::toTipoDeNaveD).collect(Collectors.toList());

    }

    @Override
    public void crearTipoDeNave(TipoDeNaveD tipoDeNaveD) {
        TipoDeNave tipoDeNave = tipoDeNaveDMapeador.toTipoDeNave(tipoDeNaveD);
        tipoDeNaveCrudRepositorio.save(tipoDeNave);
    }

}
