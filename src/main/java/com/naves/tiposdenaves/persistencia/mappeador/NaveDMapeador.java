package com.naves.tiposdenaves.persistencia.mappeador;

import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.persistencia.entidades.Nave;
import org.mapstruct.Mapper;

@Mapper()
public interface NaveDMapeador {

    NaveEspacial toNaveEspacial(Nave nave);


    Nave toNave(NaveEspacial nave);
}
