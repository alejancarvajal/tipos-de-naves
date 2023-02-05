package com.naves.tiposdenaves.controlador;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.servicio.NaveDServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NaveDControlador {
    @Autowired
    private NaveDServicio naveDService;
    @PostMapping("/all")
    public ResponseEntity<NaveD> getAll(@RequestBody NaveD naveD){

        return new ResponseEntity<>(naveDService.crearNave(naveD), HttpStatus.OK);
    }

}
