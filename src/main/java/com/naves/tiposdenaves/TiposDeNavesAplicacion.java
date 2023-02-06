package com.naves.tiposdenaves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TiposDeNavesAplicacion {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TiposDeNavesAplicacion.class, args);

		Menu menu = new Menu();
		menu.run();
	}

}
