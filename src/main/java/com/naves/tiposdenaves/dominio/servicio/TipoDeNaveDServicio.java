package com.naves.tiposdenaves.dominio.servicio;

import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.dominio.repositorio.TipoDeNaveDRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDeNaveDServicio {
    @Autowired
    private TipoDeNaveDRepositorio tipoDeNaveDRepositorio;
    public  List<TipoDeNaveD> listaTiposDeNaves(){
        return tipoDeNaveDRepositorio.listaTiposDeNaves();
    }


    public void crearTipoDeNave(TipoDeNaveD tipoDeNaveD) {
        tipoDeNaveDRepositorio.crearTipoDeNave(tipoDeNaveD);
    }
}
