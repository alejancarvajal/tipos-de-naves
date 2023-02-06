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

    private NaveDServicio naveDService;

    public NaveDControlador(NaveDServicio naveDService) {
        this.naveDService = naveDService;
    }

    @PostMapping("/creacion")
    public ResponseEntity<NaveD> creacionNaves(@RequestBody NaveEspacial naveD) {

        return new ResponseEntity<>(naveDService.crearNave(naveD), HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<NaveD>> listaNaves() {
        return new ResponseEntity<>(naveDService.getAll(), HttpStatus.OK);
    }

}
