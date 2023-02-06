package com.naves.tiposdenaves.dominio.servicio;

import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.dominio.repositorio.TipoDeNaveDRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDeNaveDServicio {

    private final TipoDeNaveDRepositorio tipoDeNaveDRepositorio;
    public TipoDeNaveDServicio(TipoDeNaveDRepositorio tipoDeNaveDRepositorio) {
        this.tipoDeNaveDRepositorio = tipoDeNaveDRepositorio;
    }

    public  List<TipoDeNaveD> listaTiposDeNaves(){
        return tipoDeNaveDRepositorio.listaTiposDeNaves();
    }

    public void crearTipoDeNave(TipoDeNaveD tipoDeNaveD) {
        tipoDeNaveDRepositorio.crearTipoDeNave(tipoDeNaveD);
    }
}
