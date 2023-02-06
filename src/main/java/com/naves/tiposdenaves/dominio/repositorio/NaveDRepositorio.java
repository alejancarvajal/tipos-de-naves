package com.naves.tiposdenaves.dominio.repositorio;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.dto.NaveEspacial;

import java.util.List;

public interface NaveDRepositorio {

    List<NaveD> getAll();


    NaveEspacial crearNave(NaveEspacial nave);

}
