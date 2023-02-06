package com.naves.tiposdenaves;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naves.tiposdenaves.dominio.dto.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public static final String NAVE = "naves";
    public static final String TIPO_DE_NAVE = "tipo-de-nave";
    public static final String CONSULTAR = "/consultar/";

    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Menu:");
            System.out.println("1. Crear nave");
            System.out.println("2. Listar nave");
            System.out.println("3. Consultar nave");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opcion ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println(" Bienvenido al menu de creacion");
                    procesoCreacion(scanner);
                    break;
                case 2:
                    System.out.println(" Bienvenido al inventario");
                    consumoServicioLista("tipo-de-nave/listar");
                    break;
                case 3:
                    System.out.println(" Bienvenido al menu consultar");
                    procesoConsulta(scanner);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Opcion invalida.");
            }
        }

    }

    private void procesoConsulta(Scanner scanner) {
        int subOpcionConsulta = 0;
        while (subOpcionConsulta != 2) {
            System.out.println("Submenu consultar:");
            System.out.println("Ingresa el tipo de consulta:");
            System.out.println("1. simple ");
            System.out.println("2. Regresar");
            System.out.print("Ingresa la opcion : ");
            subOpcionConsulta = scanner.nextInt();
            switch (subOpcionConsulta) {
                case 1:
                    System.out.println("Consulta simple ");
                    procesoConsultaSimple("Submenu busqueda simple:", "Selecciona el tipo de consulta");
                    break;
                case 2:
                    System.out.println("Regresando");
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    private void procesoConsultaSimple(String titulo, String subtitulo) {
        Scanner scanner = new Scanner(System.in);
        int subOpcionConsultaSimple = 0;
        while (subOpcionConsultaSimple != 4) {
            System.out.println(titulo);
            System.out.println(subtitulo);
            System.out.println("1. Busqueda por tipo de nave");
            System.out.println("2. Busqueda por nombre de nave");
            System.out.println("3. Busqueda por pais");
            System.out.println("4. Regresar");
            System.out.print("Ingresa la opcion : ");
            subOpcionConsultaSimple = scanner.nextInt();
            switch (subOpcionConsultaSimple) {
                case 1:
                    int subOpcion = 0;
                    while (subOpcion != 6) {
                        System.out.println("Inciando Busqueda por tipo de nave:");
                        System.out.println("Ingresa el tipo de nave a buscar:");
                        System.out.println("1. Nave lanzadera ");
                        System.out.println("2. Nave de combate ");
                        System.out.println("3. Nave de rescate ");
                        System.out.println("4. Nave no tripulada ");
                        System.out.println("5. Nave tripulada ");
                        System.out.println("6. Regresar");
                        subOpcion = scanner.nextInt();
                        String tipo = "";
                        switch (subOpcion) {
                            case 1:
                                tipo = TipoDeNaveEspacial.LANZADERA.name();
                                consumoServicioConsulta(TIPO_DE_NAVE, CONSULTAR, tipo);
                                break;
                            case 2:
                                tipo = TipoDeNaveEspacial.COMBATE.name();
                                consumoServicioConsulta(TIPO_DE_NAVE, CONSULTAR, tipo);
                                break;
                            case 3:
                                tipo = TipoDeNaveEspacial.RESCATE.name();
                                consumoServicioConsulta(TIPO_DE_NAVE, CONSULTAR, tipo);
                                break;
                            case 4:
                                tipo = TipoDeNaveEspacial.NOTRIPULADA.name();
                                consumoServicioConsulta(TIPO_DE_NAVE, CONSULTAR, tipo);
                                break;
                            case 5:
                                tipo = TipoDeNaveEspacial.TRIPULADA.name();
                                consumoServicioConsulta(TIPO_DE_NAVE, CONSULTAR, tipo);;
                                break;
                            case 6:
                                System.out.println("Regresando");

                                break;
                            default:
                                System.out.println("Opcion invalida");
                        }

                    }

                    break;
                case 2:
                    System.out.println("Inciando Busqueda por nombre:");
                    String nombre = scanner.next();
                    consumoServicioConsulta(NAVE, CONSULTAR.concat("nombre/"), nombre);
                    break;
                case 3:
                    System.out.println("Inciando Busqueda por pais:");
                    String pais = scanner.next();
                    consumoServicioConsulta(NAVE, CONSULTAR.concat("pais/"), pais);
                    break;
                case 4:
                    System.out.println("Regresando");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }

    private void procesoCreacion(Scanner scanner) {
        int subOpcion = 0;
        while (subOpcion != 6) {
            System.out.println("Submenu creacion:");
            System.out.println("Ingresa el tipo de nave a crear:");
            System.out.println("1. Nave lanzadera ");
            System.out.println("2. Nave de combate ");
            System.out.println("3. Nave de rescate ");
            System.out.println("4. Nave no tripulada ");
            System.out.println("5. Nave tripulada ");
            System.out.println("6. Regresar");
            System.out.print("Ingresa la opcion : ");
            subOpcion = scanner.nextInt();
            switch (subOpcion) {
                case 1:
                    System.out.println("Creacion de nave lanzadera");
                    NaveEspacial naveEspacialLanzandera = construirNaveEspacial(scanner, true, false, false);
                    consumirServicioCreacion(TipoDeNaveEspacial.LANZADERA.name(), naveEspacialLanzandera);
                    break;
                case 2:
                    System.out.println(" Creacion de nave de combate  ");
                    NaveEspacial naveEspacialCombate = construirNaveEspacial(scanner, false, false, false);
                    consumirServicioCreacion(TipoDeNaveEspacial.COMBATE.name(), naveEspacialCombate);
                    break;
                case 3:
                    System.out.println("Creacion de nave de rescate ");
                    NaveEspacial naveEspacialRescate = construirNaveEspacial(scanner, false, false, false);
                    consumirServicioCreacion(TipoDeNaveEspacial.RESCATE.name(), naveEspacialRescate);
                    break;
                case 4:
                    System.out.println("Creacion de nave de no tripulada ");
                    NaveEspacial naveEspacialNoTripulada = construirNaveEspacial(scanner, false, true, false);
                    consumirServicioCreacion(TipoDeNaveEspacial.NOTRIPULADA.name(), naveEspacialNoTripulada);
                    break;
                case 5:
                    System.out.println(" Creacion de nave de tripulada");
                    NaveEspacial naveEspacialTripulada = construirNaveEspacial(scanner, false, false, true);
                    consumirServicioCreacion(TipoDeNaveEspacial.TRIPULADA.name(), naveEspacialTripulada);

                    break;
                case 6:
                    System.out.println("Regresando");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }

    }

    private static void consumirServicioCreacion(String tipoNave, NaveEspacial naveEspacialLanzandera) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8090/tipos-de-naves/api/tipo-de-nave/creacion");
            httpPost.setHeader("Content-Type", "application/json");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(new TipoDeNaveD(tipoNave, naveEspacialLanzandera));

            HttpEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HttpEntity consumoServicioLista(String verbo) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:8090/tipos-de-naves/api/" + verbo);
            httpGet.setHeader("Accept", "application/json");
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                ObjectMapper mapper = new ObjectMapper();
                List<TipoDeNaveD> tiposDeNave = mapper.readValue(EntityUtils.toString(entity), new TypeReference<List<TipoDeNaveD>>() {
                });
                System.out.println(" Lista de naves disponibles: ");
                int contador = 1;
                for (TipoDeNaveD s : tiposDeNave) {
                    System.out.print(contador + ". El tipo de nave: " + s.getTipo());
                    System.out.print("  y el respectivo nombre registrado es: " + s.getNave().getNombre());
                    System.out.println(" ");
                    contador++;
                }
                procesoSeleccionNave(tiposDeNave);

                if (tiposDeNave.isEmpty()) {
                    System.out.println(" No se tienen naves disponibles en el inventario");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void procesoSeleccionNave(List<TipoDeNaveD> listaNaves) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea usar alguna de las naves encontradas");
        System.out.println("1. Si");
        System.out.println("2. No");

        Integer respuesta = scanner.nextInt();
        switch (respuesta) {
            case 1:
                System.out.println("Indique el numero de la nave segun la lista");
                int indicador = scanner.nextInt();
                TipoDeNaveD tipoDeNaveD = listaNaves.get(indicador - 1);
                TipoDeNaveEspacial tipo = TipoDeNaveEspacial.valueOf(tipoDeNaveD.getTipo());
                NaveEspacial nave = tipoDeNaveD.getNave();
                switch (tipo) {
                    case LANZADERA:
                        NaveLazandera naveLazandera = new NaveLazandera(nave.getNombre(), nave.getPais(),
                                nave.getAltura(), nave.getEmpuje(), nave.getCantidadCargaOrbita(), nave.getEstado(),
                                nave.getCombustible());
                        System.out.println("Activando sistemas de la nave lanzadera");
                        int subOpcion = 0;
                        while (subOpcion != 3) {
                            System.out.println("Ingresa la accion a realizar");
                            System.out.println("1. Iniciar despegue");
                            System.out.println("2. Lanzar Carga");
                            System.out.println("3. Regresar");
                            subOpcion = scanner.nextInt();

                            switch (subOpcion) {
                                case 1:
                                    naveLazandera.despegar(naveLazandera.getNombre());
                                    break;
                                case 2:
                                    naveLazandera.lanzarCarga();
                                    break;
                                case 3:
                                    System.out.println("Regresando");
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                            }
                        }
                        break;
                    case COMBATE:
                        NaveDeCombate naveDeCombate = new NaveDeCombate(nave.getNombre(), nave.getPais(),
                                nave.getAltura(), nave.getEmpuje(), nave.getCantidadCargaOrbita(), nave.getEstado(),
                                nave.getCombustible(), nave.getOrbita(), nave.getCantidadTripulacion());

                        System.out.println("Activando sistemas de la nave de combate");
                        int opcionCombate = 0;
                        while (opcionCombate != 9) {
                            System.out.println("Ingresa la accion a realizar");
                            System.out.println("1. Iniciar despegue");
                            System.out.println("2. Iniciar aterrrizaje");
                            System.out.println("3. Iniciar ataque");
                            System.out.println("4. Iniciar defensa");
                            System.out.println("5. Iniciar retirada");
                            System.out.println("6. Iniciar abordaje");
                            System.out.println("7. Iniciar Peticion de destino");
                            System.out.println("8. Iniciar orbitaje");
                            System.out.println("9. Regresar");
                            opcionCombate = scanner.nextInt();

                            switch (opcionCombate) {
                                case 1:
                                    naveDeCombate.despegar(naveDeCombate.getNombre());
                                    break;
                                case 2:
                                    naveDeCombate.aterrizar(naveDeCombate.getNombre());
                                    break;
                                case 3:
                                    naveDeCombate.atacar();
                                    break;
                                case 4:
                                    naveDeCombate.defender();
                                    break;
                                case 5:
                                    naveDeCombate.retirada();
                                    break;
                                case 6:
                                    naveDeCombate.transportePasajeros();
                                    break;
                                case 7:
                                    naveDeCombate.definirDestino();
                                    break;
                                case 8:
                                    naveDeCombate.orbitar();
                                    break;
                                case 9:
                                    System.out.println("Regresando");
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                            }
                        }
                        break;
                    case RESCATE:
                        NaveDeRescate naveDeRescate = new NaveDeRescate(nave.getNombre(), nave.getPais(),
                                nave.getAltura(), nave.getEmpuje(), nave.getCantidadCargaOrbita(), nave.getEstado(),
                                nave.getCombustible(), nave.getOrbita(), nave.getCantidadTripulacion());
                        System.out.println("Activando sistemas de la nave de rescate");
                        int opcionRescate = 0;
                        while (opcionRescate != 7) {
                            System.out.println("Ingresa la accion a realizar");
                            System.out.println("1. Iniciar despegue");
                            System.out.println("2. Iniciar aterrrizaje");
                            System.out.println("3. Iniciar protocolos medicos");
                            System.out.println("4. Iniciar abordaje");
                            System.out.println("5. Iniciar Peticion de destino");
                            System.out.println("6. Iniciar orbitaje");
                            System.out.println("7. Regresar");
                            opcionRescate = scanner.nextInt();

                            switch (opcionRescate) {
                                case 1:
                                    naveDeRescate.despegar(naveDeRescate.getNombre());
                                    break;
                                case 2:
                                    naveDeRescate.aterrizar(naveDeRescate.getNombre());
                                    break;
                                case 3:
                                    naveDeRescate.curacionHeridos();
                                    break;
                                case 4:
                                    naveDeRescate.transportePasajeros();
                                    break;
                                case 5:
                                    naveDeRescate.definirDestino();
                                    break;
                                case 6:
                                    naveDeRescate.orbitar();
                                    break;
                                case 7:
                                    System.out.println("Regresando");
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                            }
                        }
                        break;
                    case NOTRIPULADA:
                        NavesNoTripuladas navesNoTripuladas = new NavesNoTripuladas(nave.getNombre(), nave.getPais(),
                                nave.getEstado());
                        System.out.println("Activando sistemas de la nave de no tripulada");
                        int opcionNoTripulada = 0;
                        while (opcionNoTripulada != 8) {
                            System.out.println("Ingresa la accion a realizar");
                            System.out.println("1. Iniciar despegue");
                            System.out.println("2. Iniciar aterrrizaje");
                            System.out.println("3. Iniciar Investigacion");
                            System.out.println("4. Iniciar captura de imagenes");
                            System.out.println("5. Iniciar abastecimiento");
                            System.out.println("6. Iniciar Peticion de destino");
                            System.out.println("7. Iniciar orbitaje");
                            System.out.println("8. Regresar");
                            opcionNoTripulada = scanner.nextInt();

                            switch (opcionNoTripulada) {
                                case 1:
                                    navesNoTripuladas.despegar(navesNoTripuladas.getNombre());
                                    break;
                                case 2:
                                    navesNoTripuladas.aterrizar(navesNoTripuladas.getNombre());
                                    break;
                                case 3:
                                    navesNoTripuladas.investigar();
                                    break;
                                case 4:
                                    navesNoTripuladas.capturarImagenes();
                                    break;
                                case 5:
                                    navesNoTripuladas.abastercer();
                                    break;
                                case 6:
                                    navesNoTripuladas.definirDestino();
                                    break;
                                case 7:
                                    navesNoTripuladas.orbitar();
                                    break;
                                case 8:
                                    System.out.println("Regresando");
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                            }
                        }
                        break;
                    case TRIPULADA:
                        NavesTripluladas navesTripluladas = new NavesTripluladas(nave.getNombre(), nave.getPais(),
                                nave.getEstado(), nave.getOrbita(), nave.getCantidadTripulacion());
                        System.out.println("Activando sistemas de la nave de tripulada");
                        int opcionTripulada = 0;
                        while (opcionTripulada != 6) {
                            System.out.println("Ingresa la accion a realizar");
                            System.out.println("1. Iniciar despegue");
                            System.out.println("2. Iniciar aterrrizaje");
                            System.out.println("3. Iniciar abordaje");
                            System.out.println("4. Iniciar Peticion de destino");
                            System.out.println("5. Iniciar orbitaje");
                            System.out.println("6. Regresar");
                            opcionTripulada = scanner.nextInt();

                            switch (opcionTripulada) {
                                case 1:
                                    navesTripluladas.despegar(navesTripluladas.getNombre());
                                    break;
                                case 2:
                                    navesTripluladas.aterrizar(navesTripluladas.getNombre());
                                    break;
                                case 3:
                                    navesTripluladas.transportePasajeros();
                                    break;
                                case 4:
                                    navesTripluladas.definirDestino();
                                    break;
                                case 5:
                                    navesTripluladas.orbitar();
                                    break;
                                case 6:
                                    System.out.println("Regresando");
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                            }
                        }
                        break;
                }
                break;
            case 2:
                System.out.println("Volviendo al menu inicial");
                break;
            default:
                System.out.println("Seleccion no valida volviendo al menu inicial");

        }
    }

    public HttpEntity consumoServicioConsulta(String ruta, String verbo, String parametro) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://localhost:8090/tipos-de-naves/api/" + ruta + verbo + parametro);
            httpGet.setHeader("Accept", "application/json");
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                ObjectMapper mapper = new ObjectMapper();
                if (NAVE.equals(ruta)) {

                    List<NaveEspacial> naves = mapper.readValue(EntityUtils.toString(entity), new TypeReference<List<NaveEspacial>>() {
                    });
                    String tipoBusqueda = verbo.contains("pais") ? "pais" : "nombre";

                    System.out.println(" Lista de naves por " + tipoBusqueda + " disponibles: ");
                    naves.forEach(s -> {
                        System.out.print("  Nave identificada con id: " + s.getId()
                                + " y su respectivo " + tipoBusqueda + " es: "
                                + (verbo.contains("pais") ? s.getPais() : s.getNombre()));
                        System.out.println(" ");
                    });
                    if (naves.isEmpty()) {
                        System.out.println(" No se tienen naves disponibles en el inventario");
                    }
                } else if (TIPO_DE_NAVE.equals(ruta)) {
                    List<TipoDeNaveD> tiposDeNave = mapper.readValue(EntityUtils.toString(entity), new TypeReference<List<TipoDeNaveD>>() {
                    });
                    System.out.println(" Lista de naves disponibles: ");
                    tiposDeNave.forEach(s -> {
                        System.out.print(" El tipo de nave: " + s.getTipo());
                        System.out.print("  y el respectivo nombre registrado es: " + s.getNave().getNombre());
                        System.out.println(" ");
                    });
                    if (tiposDeNave.isEmpty()) {
                        System.out.println(" No se tienen naves disponibles en el inventario");
                    }
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private NaveEspacial construirNaveEspacial(Scanner scanner, boolean esLazandera, boolean esNoTripulada, boolean esTripulada) {
        Double orbita = null;
        Integer cantidadtripulacion = null;
        String combustible = null;
        Double cantidadcargaorbita = null;
        Integer altura = null;
        Double empuje = null;

        System.out.println(" Ingrese el nombre de la nave");
        String nombre = scanner.next();
        System.out.println(" Ingrese el pais  de la nave");
        String pais = scanner.next();
        System.out.println(" Ingrese el estado de la nave");
        Boolean estado = scanner.nextBoolean();


        if (!esNoTripulada && !esTripulada) {
            System.out.println(" Ingrese la altura de la nave");
            altura = scanner.nextInt();
            System.out.println(" Ingrese el empuje de la nave");
            empuje = scanner.nextDouble();
            System.out.println(" Ingrese la cantidad de toneladas en orbita baja de la nave");
            cantidadcargaorbita = scanner.nextDouble();
            System.out.println(" Ingrese el combustible de la nave");
            combustible = scanner.next();

        }
        if (!esLazandera && !esNoTripulada) {
            System.out.println(" Ingrese la orbita de la nave");
            orbita = scanner.nextDouble();
            System.out.println(" Ingrese la cantidad de tripulacion de la nave");
            cantidadtripulacion = scanner.nextInt();
        }

        return new NaveEspacial(nombre, pais, altura, empuje, cantidadcargaorbita, estado, combustible, orbita, cantidadtripulacion);
    }
}
