package com.naves.tiposdenaves.persistencia;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.repositorio.NaveDRepositorio;
import com.naves.tiposdenaves.persistencia.crud.NaveCrudRepositorio;
import com.naves.tiposdenaves.persistencia.entidades.Nave;
import com.naves.tiposdenaves.persistencia.mappeador.NaveDMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NaveRepositorio implements NaveDRepositorio {
    @Autowired
    private NaveDMapeador mapper;
    @Autowired
    private NaveCrudRepositorio  naveCrudRepositorio;

    public List<NaveD> getAll(){
        List<Nave> nave =(List<Nave>) naveCrudRepositorio.findAll();
        return nave.stream().map(nave1 -> mapper.toNaveD(nave1)).collect(Collectors.toList());


    }

    @Override
    public NaveD crearNave(NaveD naveD) {
        Nave nave = naveCrudRepositorio.save(mapper.toNave(naveD));
        return mapper.toNaveD(nave);
    }


}
