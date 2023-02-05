package com.naves.tiposdenaves.persistencia.mappeador;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.persistencia.entidades.Nave;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface NaveDMapeador {

    NaveD toNaveD(Nave nave);


    Nave toNave(NaveD nave);
}
