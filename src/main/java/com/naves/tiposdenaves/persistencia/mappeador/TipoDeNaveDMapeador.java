package com.naves.tiposdenaves.persistencia.mappeador;

import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.persistencia.entidades.TipoDeNave;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoDeNaveDMapeador {
TipoDeNaveD toTipoDeNaveD (TipoDeNave tipoDeNave);


TipoDeNave toTipoDeNave (TipoDeNaveD tipoDeNaveD);
}
