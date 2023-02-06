package com.naves.tiposdenaves.dominio.servicio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.dominio.repositorio.NaveDRepositorio;


@ExtendWith(MockitoExtension.class)
class NaveDServicioTest
{
    @Mock
    private NaveDRepositorio naveDRepositorio;

    private NaveDServicio naveDServicio;

    @BeforeEach
    public void setup() {
        naveDServicio = new NaveDServicio(naveDRepositorio);
    }

    @Test
    public void testGetAll() {
        List<NaveD> naves = new ArrayList<>();
        naves.add(new NaveEspacial());
        when(naveDRepositorio.getAll()).thenReturn(naves);
        assertNotNull(naveDServicio.getAll());
        assertEquals(1, naveDServicio.getAll().size());
    }

    @Test
    public void testCrearNave() {
        NaveEspacial nave = new NaveEspacial();
        when(naveDRepositorio.crearNave(nave)).thenReturn(nave);
        assertNotNull(naveDServicio.crearNave(nave));
        org.mockito.Mockito.verify(naveDRepositorio).crearNave(nave);

    }

    @Test
    public void testBusquedaDeNavesPorNombre() {
        List<NaveEspacial> naves = new ArrayList<>();
        naves.add(new NaveEspacial());
        when(naveDRepositorio.busquedaDeNavePorNombre("Nombre")).thenReturn(naves);
        assertNotNull(naveDServicio.busquedaDeNavesPorNombre("Nombre"));
        assertEquals(1, naveDServicio.busquedaDeNavesPorNombre("Nombre").size());
    }

    @Test
    public void testBusquedaDeNavesPorPais()
    {
        List<NaveEspacial> naves = new ArrayList<>();
        naves.add(new NaveEspacial());
        when(naveDRepositorio.busquedaDeNavePorPais("Pais")).thenReturn(naves);
        assertNotNull(naveDServicio.busquedaDeNavesPorPais("Pais"));
    }
}