package com.naves.tiposdenaves.persistencia;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.dominio.repositorio.NaveDRepositorio;
import com.naves.tiposdenaves.persistencia.crud.NaveCrudRepositorio;
import com.naves.tiposdenaves.persistencia.entidades.Nave;
import com.naves.tiposdenaves.persistencia.mappeador.NaveDMapeador;
import com.naves.tiposdenaves.persistencia.mappeador.NaveEspacialMapeador;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NaveRepositorio implements NaveDRepositorio {

    private final NaveDMapeador naveDMapeador;
    private final NaveEspacialMapeador naveEspacialMapeador;
    private final NaveCrudRepositorio naveCrudRepositorio;

    public NaveRepositorio(NaveDMapeador naveDMapeador, NaveEspacialMapeador naveEspacialMapeador, NaveCrudRepositorio naveCrudRepositorio) {
        this.naveDMapeador = naveDMapeador;
        this.naveEspacialMapeador = naveEspacialMapeador;
        this.naveCrudRepositorio = naveCrudRepositorio;
    }

    public List<NaveD> getAll() {
        List<Nave> nave = (List<Nave>) naveCrudRepositorio.findAll();
        return nave.stream().map(naveDMapeador::toNaveEspacial).collect(Collectors.toList());

    }

    @Override
    public NaveEspacial crearNave(NaveEspacial naveD) {
        Nave nave = naveCrudRepositorio.save(naveDMapeador.toNave(naveD));
        return naveDMapeador.toNaveEspacial(nave);
    }

    @Override
    public List<NaveEspacial> busquedaDeNavePorNombre(String nombre) {
        return naveCrudRepositorio.findByNombre(nombre).stream()
                .map(naveDMapeador::toNaveEspacial)
                .collect(Collectors.toList());
    }

    @Override
    public List<NaveEspacial> busquedaDeNavePorPais(String pais) {
        return naveCrudRepositorio.findByPais(pais).stream()
                .map(naveDMapeador::toNaveEspacial)
                .collect(Collectors.toList());

    }


}
