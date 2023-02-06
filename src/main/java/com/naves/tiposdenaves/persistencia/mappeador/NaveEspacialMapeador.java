package com.naves.tiposdenaves.persistencia.mappeador;

import com.naves.tiposdenaves.dominio.dto.NaveDeCombate;
import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.persistencia.entidades.Nave;
import org.mapstruct.Mapper;

@Mapper()
public interface NaveEspacialMapeador {

    NaveEspacial naveDeCombatetoNaveEspacial(NaveDeCombate nave);


    NaveDeCombate naveEspacialtoNaveDeCombate(NaveEspacial nave);


    Nave naveDeCombatetoNave(NaveDeCombate nave);
    NaveDeCombate navetoNaveDeCombate(Nave nave);

}
