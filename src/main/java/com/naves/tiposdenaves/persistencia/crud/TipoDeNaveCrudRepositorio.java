package com.naves.tiposdenaves.persistencia.crud;

import com.naves.tiposdenaves.persistencia.entidades.TipoDeNave;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipoDeNaveCrudRepositorio extends CrudRepository <TipoDeNave,Integer> {


    List<TipoDeNave> findByTipo(String tipo);
}