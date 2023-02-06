package com.naves.tiposdenaves.configuraciones;

import com.naves.tiposdenaves.controlador.NaveDControlador;
import com.naves.tiposdenaves.controlador.TipoDeNaveDControlador;
import com.naves.tiposdenaves.dominio.servicio.NaveDServicio;
import com.naves.tiposdenaves.dominio.servicio.TipoDeNaveDServicio;
import com.naves.tiposdenaves.persistencia.NaveRepositorio;
import com.naves.tiposdenaves.persistencia.TipoDeNaveRepositorio;
import com.naves.tiposdenaves.persistencia.crud.NaveCrudRepositorio;
import com.naves.tiposdenaves.persistencia.crud.TipoDeNaveCrudRepositorio;
import com.naves.tiposdenaves.persistencia.mappeador.NaveDMapeador;
import com.naves.tiposdenaves.persistencia.mappeador.NaveEspacialMapeador;
import com.naves.tiposdenaves.persistencia.mappeador.TipoDeNaveDMapeador;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionDependencias {
    @Bean
    public NaveDControlador tipoDeNaveDControlador(NaveDServicio naveDService) {
        return new NaveDControlador(naveDService);
    }

    @Bean
    public TipoDeNaveDControlador tipoDeNaveDControlador(TipoDeNaveDServicio tipoDeNaveDServicio, NaveDServicio naveDServicio) {
        return new TipoDeNaveDControlador(tipoDeNaveDServicio, naveDServicio);
    }

    @Bean
    public TipoDeNaveDServicio tipoDeNaveDServicio(TipoDeNaveRepositorio tipoDeNaveRepositorio) {
        return new TipoDeNaveDServicio(tipoDeNaveRepositorio);
    }

    @Bean
    public NaveDServicio naveDServicio(NaveRepositorio naveRepositorio) {
        return new NaveDServicio(naveRepositorio);
    }

    @Bean
    public TipoDeNaveRepositorio tipoDeNaveRepositorio(TipoDeNaveDMapeador tipoDeNaveDMapeador, TipoDeNaveCrudRepositorio tipoDeNaveCrudRepositorio) {
        return new TipoDeNaveRepositorio(tipoDeNaveDMapeador, tipoDeNaveCrudRepositorio);
    }

    @Bean
    public NaveRepositorio naveRepositorio(NaveDMapeador naveDMapeador, NaveEspacialMapeador naveEspacialMapeador, NaveCrudRepositorio naveCrudRepositorio) {
        return new NaveRepositorio(naveDMapeador, naveEspacialMapeador, naveCrudRepositorio);
    }


    @Bean
    public NaveEspacialMapeador naveEspacialMapeador() {
        return Mappers.getMapper(NaveEspacialMapeador.class);
    }

    @Bean
    public NaveDMapeador naveDMapeador() {
        return Mappers.getMapper(NaveDMapeador.class);
    }

    @Bean
    public TipoDeNaveDMapeador tipoDeNaveDMapeador() {
        return Mappers.getMapper(TipoDeNaveDMapeador.class);
    }
}
