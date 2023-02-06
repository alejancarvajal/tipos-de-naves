package com.naves.tiposdenaves.dominio.servicio;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.dominio.repositorio.NaveDRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NaveDServicio {

    private final NaveDRepositorio naveDRepositorio;

    public NaveDServicio(NaveDRepositorio naveDRepositorio) {
        this.naveDRepositorio = naveDRepositorio;
    }

    public List<NaveD> getAll(){
        return  naveDRepositorio.getAll();

    }

    public NaveEspacial crearNave(NaveEspacial nave) {
        return naveDRepositorio.crearNave(nave);

    }

    public List<NaveEspacial> busquedaDeNavesPorNombre(String nombre) {
        return naveDRepositorio.busquedaDeNavePorNombre(nombre);
    }

    public List<NaveEspacial> busquedaDeNavesPorPais(String pais) {
       return naveDRepositorio.busquedaDeNavePorPais(pais);
    }
}
