package com.naves.tiposdenaves.controlador;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.dominio.servicio.NaveDServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/naves")
public class NaveDControlador {

    private NaveDServicio naveDServicio;

    public NaveDControlador(NaveDServicio naveDServicio) {
        this.naveDServicio = naveDServicio;
    }

    @PostMapping("/creacion")
    public ResponseEntity<NaveD> creacionNaves(@RequestBody NaveEspacial naveD) {

        return new ResponseEntity<>(naveDServicio.crearNave(naveD), HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<NaveD>> listaNaves() {
        return new ResponseEntity<>(naveDServicio.getAll(), HttpStatus.OK);
    }
    @GetMapping("/consultar/nombre/{nombre}")
    public List<NaveEspacial> busquedaPorNombre(@PathVariable String nombre) {
        return naveDServicio.busquedaDeNavesPorNombre(nombre);
    }

    @GetMapping("/consultar/pais/{pais}")
    public List<NaveEspacial> busquedaPorPais(@PathVariable String pais) {
        return naveDServicio.busquedaDeNavesPorPais(pais);
    }
}
