package com.naves.tiposdenaves.persistencia;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.dto.NaveDeCombate;
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
    private final NaveCrudRepositorio  naveCrudRepositorio;

    public NaveRepositorio(NaveDMapeador naveDMapeador, NaveEspacialMapeador naveEspacialMapeador, NaveCrudRepositorio naveCrudRepositorio) {
        this.naveDMapeador = naveDMapeador;
        this.naveEspacialMapeador = naveEspacialMapeador;
        this.naveCrudRepositorio = naveCrudRepositorio;
    }

    public List<NaveD> getAll(){
        List<Nave> nave =(List<Nave>) naveCrudRepositorio.findAll();
        return nave.stream().map(naveDMapeador::toNaveEspacial).collect(Collectors.toList());

    }

    @Override
    public NaveEspacial crearNave(NaveEspacial naveD) {
        NaveDeCombate naveDeCombate = naveEspacialMapeador.naveEspacialtoNaveDeCombate(naveD);
        Nave nave = naveCrudRepositorio.save(naveDMapeador.toNave(naveD));
        return naveDMapeador.toNaveEspacial(nave);
    }


}
