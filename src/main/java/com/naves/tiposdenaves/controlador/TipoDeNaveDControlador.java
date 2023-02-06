package com.naves.tiposdenaves.controlador;

import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.dominio.servicio.NaveDServicio;
import com.naves.tiposdenaves.dominio.servicio.TipoDeNaveDServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-de-nave")
public class TipoDeNaveDControlador {

    private final TipoDeNaveDServicio tipoDeNaveDServicio;
    private final NaveDServicio naveDServicio;

    public TipoDeNaveDControlador(TipoDeNaveDServicio tipoDeNaveDServicio, NaveDServicio naveDServicio) {
        this.tipoDeNaveDServicio = tipoDeNaveDServicio;
        this.naveDServicio = naveDServicio;
    }

    @GetMapping("/listar")
    public List<TipoDeNaveD> listarTiposDeNaves() {
        return (tipoDeNaveDServicio.listaTiposDeNaves());
    }

    @PostMapping("/creacion")
    public void crearTipoDeNave(@RequestBody TipoDeNaveD tipoDeNaveD) {
        NaveEspacial nave = naveDServicio.crearNave(tipoDeNaveD.getNave());
        tipoDeNaveD.setNave(nave);
        tipoDeNaveDServicio.crearTipoDeNave(tipoDeNaveD);
    }

    @GetMapping("/consultar/{tipo}")
    public List<TipoDeNaveD> busquedaPorTipo(@PathVariable String tipo) {
       return tipoDeNaveDServicio.busquedaDeNavesPorTipo(tipo);
    }


}
