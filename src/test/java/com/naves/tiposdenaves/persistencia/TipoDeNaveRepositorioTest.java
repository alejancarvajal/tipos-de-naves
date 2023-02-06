package com.naves.tiposdenaves.persistencia;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.persistencia.crud.TipoDeNaveCrudRepositorio;
import com.naves.tiposdenaves.persistencia.entidades.TipoDeNave;
import com.naves.tiposdenaves.persistencia.mappeador.TipoDeNaveDMapeador;


@ExtendWith(MockitoExtension.class)
class TipoDeNaveRepositorioTest
{
    @Mock
    private TipoDeNaveDMapeador tipoDeNaveDMapeador;

    @Mock
    private TipoDeNaveCrudRepositorio tipoDeNaveCrudRepositorio;

    @InjectMocks
    private TipoDeNaveRepositorio tipoDeNaveRepositorio;

    private List<TipoDeNave> tipoDeNaves;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tipoDeNaves = new ArrayList<>();
        TipoDeNave tipoDeNave = new TipoDeNave();
        tipoDeNave.setTipo("Tipo 1");
        tipoDeNaves.add(tipoDeNave);
        tipoDeNaveRepositorio = new TipoDeNaveRepositorio(tipoDeNaveDMapeador, tipoDeNaveCrudRepositorio);

    }

    @Test
    public void listaTiposDeNavesTest() {
        when(tipoDeNaveCrudRepositorio.findAll()).thenReturn(tipoDeNaves);
        when(tipoDeNaveDMapeador.toTipoDeNaveD(any())).thenReturn(new TipoDeNaveD());
        List<TipoDeNaveD> result = tipoDeNaveRepositorio.listaTiposDeNaves();
        assertEquals(1, result.size());
    }

    @Test
    public void listaTiposDeNavesPorTipoTest() {
        when(tipoDeNaveCrudRepositorio.findByTipo("Tipo 1")).thenReturn(tipoDeNaves);
        when(tipoDeNaveDMapeador.toTipoDeNaveD(any())).thenReturn(new TipoDeNaveD());
        List<TipoDeNaveD> result = tipoDeNaveRepositorio.listaTiposDeNavesPorTipo("Tipo 1");
        assertEquals(1, result.size());
    }
}