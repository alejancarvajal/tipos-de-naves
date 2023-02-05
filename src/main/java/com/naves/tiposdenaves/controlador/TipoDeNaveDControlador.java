package com.naves.tiposdenaves.controlador;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.dominio.servicio.NaveDServicio;
import com.naves.tiposdenaves.dominio.servicio.TipoDeNaveDServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TipoDeNaveDControlador {

    @Autowired
    private TipoDeNaveDServicio tipoDeNaveDServicio;

    @Autowired
    private NaveDServicio naveDServicio;

/*    @GetMapping("/all")
    public List<TipoDeNaveD> tipoDeNaveDS() {
        return tipoDeNaveDServicio.listaTiposDeNaves();
    }*/

    @PostMapping("/creacion")
    public void crearTipoDeNave(@RequestBody TipoDeNaveD tipoDeNaveD) {
        NaveD naveD =  naveDServicio.crearNave(tipoDeNaveD.getNave());
        tipoDeNaveD.setNave(naveD);
        tipoDeNaveDServicio.crearTipoDeNave(tipoDeNaveD);
    }

}
