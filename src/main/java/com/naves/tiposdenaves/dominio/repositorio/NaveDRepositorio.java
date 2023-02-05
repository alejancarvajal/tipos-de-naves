package com.naves.tiposdenaves.dominio.repositorio;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.persistencia.entidades.Nave;

import java.util.List;

public interface NaveDRepositorio {

    List<NaveD> getAll();


    NaveD crearNave(NaveD nave);

}
