package com.naves.tiposdenaves.persistencia.crud;

import com.naves.tiposdenaves.persistencia.entidades.Nave;
import org.springframework.data.repository.CrudRepository;

public interface NaveCrudRepositorio extends CrudRepository <Nave,Integer> {

}
