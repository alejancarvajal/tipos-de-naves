package com.naves.tiposdenaves.persistencia.crud;

import com.naves.tiposdenaves.persistencia.entidades.TipoDeNave;
import org.springframework.data.repository.CrudRepository;

public interface TipoDeNaveCrudRepositorio extends CrudRepository <TipoDeNave,Integer> {

}