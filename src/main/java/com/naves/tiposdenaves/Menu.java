package com.naves.tiposdenaves;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naves.tiposdenaves.dominio.dto.NaveEspacial;
import com.naves.tiposdenaves.dominio.dto.TipoDeNaveD;
import com.naves.tiposdenaves.dominio.dto.TipoDeNaveEspacial;
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
                    int subOpcionConsulta = 0;
                    while (subOpcionConsulta != 3) {
                        System.out.println("Submenu consultar:");
                        System.out.println("Ingresa el tipo de consulta:");
                        System.out.println("1. simple ");
                        System.out.println("2. avanzada ");
                        System.out.println("3. Regresar");
                        System.out.print("Ingresa la opcion : ");
                        subOpcionConsulta = scanner.nextInt();
                        switch (subOpcionConsulta) {
                            case 1:
                                System.out.println("Consulta simple ");
                                break;
                            case 2:
                                System.out.println("Consulta avanzada");
                                break;
                            case 3:
                                System.out.println("Regresando");
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }
                    }
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
                //   System.out.println("Response: " + EntityUtils.toString(response.getEntity()));
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

                tiposDeNave.forEach(s -> {
                    System.out.println(" Lista de naves disponibles: ");
                    System.out.print(" El tipo de nave: " + s.getTipo());
                    System.out.print("  y el respectivo nombre registrado es: " + s.getNave().getNombre());
                    System.out.println(" ");
                });
                if (tiposDeNave.isEmpty()) {
                    System.out.println(" No se tienen naves disponibles en el inventario");
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
