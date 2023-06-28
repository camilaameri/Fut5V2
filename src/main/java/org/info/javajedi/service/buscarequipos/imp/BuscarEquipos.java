package org.info.javajedi.service.buscarequipos.imp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.info.javajedi.service.buscarequipos.BuscarEquiposI;

public class BuscarEquipos implements BuscarEquiposI {
    private Scanner scanner;

    public BuscarEquipos() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void buscarEquipoPorNombre() {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Usuario\\Desktop\\programacion codigos\\java_jedi\\Fut5\\src\\main\\java\\org\\info\\javajedi\\service\\equipos.txt"))) {
            String linea;
            boolean equipoEncontrado = false;

            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Nombre del equipo: ")) {
                    String nombre = linea.substring("Nombre del equipo: ".length());

                    if (nombre.equalsIgnoreCase(nombreEquipo)) {
                        equipoEncontrado = true;
                        mostrarAtributosEquipo(reader);
                        break;
                    }
                }
            }

            if (!equipoEncontrado) {
                System.out.println("No se encontró ningún equipo con el nombre '" + nombreEquipo + "'.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }



    public void mostrarAtributosEquipo(BufferedReader reader) {
        try {
            System.out.println("Atributos del equipo:");

            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Nombre del equipo: ")) {
                    System.out.println(linea);
                } else if (linea.startsWith("Fecha de creación: ")) {
                    System.out.println(linea);
                } else if (linea.startsWith("Nombre del entrenador: ")) {
                    System.out.println(linea);
                } else if (linea.startsWith("Apellido del entrenador: ")) {
                    System.out.println(linea);
                } else if (linea.startsWith("Jugadores:")) {
                    System.out.println(linea);
                    mostrarAtributosJugadores(reader);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void mostrarAtributosJugadores(BufferedReader reader) throws IOException {
        String linea;
        boolean esCapitan = false;

        while ((linea = reader.readLine()) != null) {
            if (linea.trim().isEmpty()) {
                // Fin de los atributos del equipo
                break;
            } else if (linea.startsWith("Identificador: ")) {
                int identificador = Integer.parseInt(linea.substring("Identificador: ".length()));
                String nombre = reader.readLine().substring("Nombre: ".length());
                String apellido = reader.readLine().substring("Apellido: ".length());
                double altura = Double.parseDouble(reader.readLine().substring("Altura: ".length()));
                String posicion = reader.readLine().substring("Posición: ".length());
                int goles = Integer.parseInt(reader.readLine().substring("Cantidad de goles: ".length()));
                int partidos = Integer.parseInt(reader.readLine().substring("Cantidad de partidos: ".length()));
                boolean esCapitanJugador = Boolean.parseBoolean(reader.readLine().substring("Es capitán: ".length()));
                int numeroCamiseta = Integer.parseInt(reader.readLine().substring("Número de camiseta: ".length()));

                if (esCapitanJugador) {
                    System.out.println("Nombre del jugador capitán: " + nombre + " " + apellido);
                }
            }
        }
    }







}
