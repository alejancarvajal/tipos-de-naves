package com.naves.tiposdenaves.persistencia.crud;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.persistencia.entidades.Nave;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NaveCrudRepositorio extends CrudRepository <Nave,Integer> {

    List<Nave> findByNombre(String nombre);

    List<Nave> findByPais(String pais);

}
