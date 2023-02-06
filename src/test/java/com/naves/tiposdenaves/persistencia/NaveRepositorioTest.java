package com.naves.tiposdenaves.persistencia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naves.tiposdenaves.dominio.dto.NaveD;
import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.persistencia.crud.NaveCrudRepositorio;
import com.naves.tiposdenaves.persistencia.entidades.Nave;
import com.naves.tiposdenaves.persistencia.mappeador.NaveDMapeador;
import com.naves.tiposdenaves.persistencia.mappeador.NaveEspacialMapeador;


@ExtendWith(MockitoExtension.class)
class NaveRepositorioTest
{
    @Mock
    private NaveDMapeador naveDMapeador;

    @Mock
    private NaveEspacialMapeador naveEspacialMapeador;

    @Mock
    private NaveCrudRepositorio naveCrudRepositorio;

    @InjectMocks
    private NaveRepositorio naveRepositorio;
    @BeforeEach
    public void setUp() {
        naveRepositorio = new NaveRepositorio(naveDMapeador, null, naveCrudRepositorio);
    }
    @Test
    public void getAllTest() {
        Nave nave = new Nave();
        List<Nave> expectedNaves = Arrays.asList(nave);
        NaveD naveD = new NaveEspacial();
        List<NaveD> expectedNaveDs = Arrays.asList(naveD);

        when(naveCrudRepositorio.findAll()).thenReturn(expectedNaves);
        when(naveDMapeador.toNaveEspacial(nave)).thenReturn((NaveEspacial) naveD);

        List<NaveD> actualNaveDs = naveRepositorio.getAll();

        assertThat(actualNaveDs).isEqualTo(expectedNaveDs);
    }

    @Test
    public void crearNaveTest() {
        Nave nave = new Nave();
        NaveEspacial naveD = new NaveEspacial();
        nave.setNombre("LANCER");

        when(naveCrudRepositorio.save(any())).thenReturn(nave);
        when(naveDMapeador.toNaveEspacial(any())).thenReturn(naveD);

        NaveEspacial actualNaveD = naveRepositorio.crearNave(naveD);

        assertThat(actualNaveD).isEqualTo(naveD);
    }
    @Test
    public void busquedaPorNombreTest() {
        Nave nave1 = new Nave();
        nave1.setNombre("Nave 1");
        Nave nave2 = new Nave();
        nave2.setNombre("Nave 2");

        when(naveCrudRepositorio.findByNombre("Test")).thenReturn(Arrays.asList(nave1, nave2));
        when(naveDMapeador.toNaveEspacial(nave1)).thenReturn(new NaveEspacial());
        when(naveDMapeador.toNaveEspacial(nave2)).thenReturn(new NaveEspacial());

        List<NaveEspacial> result = naveRepositorio.busquedaDeNavePorNombre("Test");

        assertEquals(2, result.size());
    }

    @Test
    public void busquedaPorPaisTest() {
        Nave nave1 = new Nave();
        nave1.setPais("Pais 1");
        Nave nave2 = new Nave();
        nave2.setPais("Pais 2");

        when(naveCrudRepositorio.findByPais("Test")).thenReturn(Arrays.asList(nave1, nave2));
        when(naveDMapeador.toNaveEspacial(nave1)).thenReturn(new NaveEspacial());
        when(naveDMapeador.toNaveEspacial(nave2)).thenReturn(new NaveEspacial());

        List<NaveEspacial> result = naveRepositorio.busquedaDeNavePorPais("Test");

        assertEquals(2, result.size());
    }

}