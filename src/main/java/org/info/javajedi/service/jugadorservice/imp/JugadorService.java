package org.info.javajedi.service.jugadorservice.imp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.info.javajedi.service.jugadorservice.JugadorI;

public class JugadorService implements JugadorI {
    private Scanner scanner;

    public JugadorService() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void buscarJugadorPorNombre() {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombreJugador = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\programacion codigos\\probando cosas de java\\Fut5V2\\src\\main\\java\\org\\info\\javajedi\\service\\equipos.txt"))) {
            String linea;
            boolean jugadorEncontrado = false;

            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Identificador: ")) {
                    int identificador = Integer.parseInt(linea.substring("Identificador: ".length()));
                    String nombre = "";
                    String apellido = "";
                    double altura = 0.0;
                    String posicion = "";
                    int cantidadGoles = 0;
                    int cantidadPartidos = 0;
                    boolean esCapitan = false;
                    int numeroCamiseta = 0;

                    while ((linea = reader.readLine()) != null && !linea.trim().isEmpty()) {
                        if (linea.startsWith("Nombre: ")) {
                            nombre = linea.substring("Nombre: ".length());
                        } else if (linea.startsWith("Apellido: ")) {
                            apellido = linea.substring("Apellido: ".length());
                        } else if (linea.startsWith("Altura: ")) {
                            altura = Double.parseDouble(linea.substring("Altura: ".length()));
                        } else if (linea.startsWith("Posición: ")) {
                            posicion = linea.substring("Posición: ".length());
                        } else if (linea.startsWith("Cantidad de goles: ")) {
                            cantidadGoles = Integer.parseInt(linea.substring("Cantidad de goles: ".length()));
                        } else if (linea.startsWith("Cantidad de partidos: ")) {
                            cantidadPartidos = Integer.parseInt(linea.substring("Cantidad de partidos: ".length()));
                        } else if (linea.startsWith("Es capitán: ")) {
                            esCapitan = Boolean.parseBoolean(linea.substring("Es capitán: ".length()));
                        } else if (linea.startsWith("Número de camiseta: ")) {
                            numeroCamiseta = Integer.parseInt(linea.substring("Número de camiseta: ".length()));
                        }
                    }

                    if (nombre.equalsIgnoreCase(nombreJugador)) {
                        jugadorEncontrado = true;

                        System.out.println("Atributos del jugador:");
                        System.out.println("Identificador: " + identificador);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Apellido: " + apellido);
                        System.out.println("Altura: " + altura);
                        System.out.println("Posición: " + posicion);
                        System.out.println("Cantidad de goles: " + cantidadGoles);
                        System.out.println("Cantidad de partidos: " + cantidadPartidos);
                        System.out.println("Es capitán: " + esCapitan);
                        System.out.println("Número de camiseta: " + numeroCamiseta);

                        break;
                    }
                }
            }

            if (!jugadorEncontrado) {
                System.out.println("No se encontró ningún jugador con el nombre '" + nombreJugador + "'.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }





}
