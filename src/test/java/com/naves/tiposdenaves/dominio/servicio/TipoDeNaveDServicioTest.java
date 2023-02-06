package com.naves.tiposdenaves.dominio.servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.dominio.repositorio.TipoDeNaveDRepositorio;


@ExtendWith(MockitoExtension.class)
class TipoDeNaveDServicioTest
{
    @InjectMocks
    private TipoDeNaveDServicio tipoDeNaveDServicio;

    @Mock
    private TipoDeNaveDRepositorio tipoDeNaveDRepositorio;

    @BeforeEach
    public void setUp() {
        tipoDeNaveDServicio = new TipoDeNaveDServicio(tipoDeNaveDRepositorio);
    }

    @Test
    public void listaTiposDeNavesTest() {
        TipoDeNaveD nave1 = new TipoDeNaveD("Nave 1", new NaveEspacial());
        TipoDeNaveD nave2 = new TipoDeNaveD("Nave 2", new NaveEspacial());
        List<TipoDeNaveD> naves = Arrays.asList(nave1, nave2);

        when(tipoDeNaveDRepositorio.listaTiposDeNaves()).thenReturn(naves);

        List<TipoDeNaveD> result = tipoDeNaveDServicio.listaTiposDeNaves();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Nave 1", result.get(0).getTipo());
        assertEquals("Nave 2", result.get(1).getTipo());
    }
    @Test
    public void crearTipoDeNaveTest() {
        TipoDeNaveD tipoDeNaveD = new TipoDeNaveD("Nave 1", new NaveEspacial());

        tipoDeNaveDServicio.crearTipoDeNave(tipoDeNaveD);

        org.mockito.Mockito.verify(tipoDeNaveDRepositorio).crearTipoDeNave(tipoDeNaveD);
    }

    @Test
    public void busquedaDeNavesPorTipoTest()
    {
        TipoDeNaveD nave1 = new TipoDeNaveD("Nave 1", new NaveEspacial());
        TipoDeNaveD nave2 = new TipoDeNaveD("Nave 2", new NaveEspacial());
        List<TipoDeNaveD> naves = Arrays.asList(nave1, nave2);

        when(tipoDeNaveDRepositorio.listaTiposDeNavesPorTipo("Nave 1")).thenReturn(naves);

        List<TipoDeNaveD> result = tipoDeNaveDServicio.busquedaDeNavesPorTipo("Nave 1");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Nave 1", result.get(0).getTipo());
        assertEquals("Nave 2", result.get(1).getTipo());
    }
}