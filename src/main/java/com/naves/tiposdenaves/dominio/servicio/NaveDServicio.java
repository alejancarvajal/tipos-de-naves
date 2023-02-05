package com.naves.tiposdenaves.dominio.servicio;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.repositorio.NaveDRepositorio;
import com.naves.tiposdenaves.persistencia.entidades.Nave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaveDServicio {
    @Autowired
    private NaveDRepositorio naveDRepositorio;

    public List<NaveD> getAll(){
        return  naveDRepositorio.getAll();

    }


    public NaveD crearNave(NaveD nave) {
        return naveDRepositorio.crearNave(nave);

    }
}
