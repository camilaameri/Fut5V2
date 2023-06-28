package org.info.javajedi.service.crearequipos.imp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.info.javajedi.domain.Entrenador;
import org.info.javajedi.domain.Equipo;
import org.info.javajedi.domain.Jugador;
import org.info.javajedi.service.crearequipos.CrearEquiposI;

public class CrearEquipo implements CrearEquiposI {
    private Scanner scanner;

    public CrearEquipo() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void crearEquipo() {
        System.out.println("Ingrese los datos del equipo:");

        System.out.print("Nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();

        System.out.print("Fecha de creación del equipo: ");
        String fechaCreacion = scanner.nextLine();

        System.out.print("Nombre del entrenador: ");
        String nombreEntrenador = scanner.nextLine();

        System.out.print("Apellido del entrenador: ");
        String apellidoEntrenador = scanner.nextLine();

        System.out.print("Edad del entrenador: ");
        int edadEntrenador = scanner.nextInt();
        scanner.nextLine();

        Entrenador entrenador = new Entrenador(nombreEntrenador, apellidoEntrenador, edadEntrenador);

        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Ingrese los datos del Jugador " + i + ":");

            System.out.print("Identificador: ");
            int identificador = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nombre: ");
            String nombreJugador = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellidoJugador = scanner.nextLine();

            System.out.print("Altura: ");
            double altura = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Posición: ");
            String posicion = scanner.nextLine();

            System.out.print("Cantidad de goles: ");
            int cantidadGoles = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Cantidad de partidos: ");
            int cantidadPartidos = scanner.nextInt();
            scanner.nextLine();

            System.out.print("¿Es capitán? (true/false): ");
            boolean esCapitan = scanner.nextBoolean();
            scanner.nextLine();

            System.out.print("Número de camiseta: ");
            int numeroCamiseta = scanner.nextInt();
            scanner.nextLine();

            Jugador jugador = new Jugador(identificador, nombreJugador, apellidoJugador, altura, posicion,
                    cantidadGoles, cantidadPartidos, esCapitan, numeroCamiseta);

            jugadores.add(jugador);
        }

        Equipo equipo = new Equipo(nombreEquipo, fechaCreacion, entrenador, jugadores);
        guardarEquipoEnArchivo(equipo);

        System.out.println("¡Equipo creado exitosamente!");
        System.out.println();
    }

    private void guardarEquipoEnArchivo(Equipo equipo) {
        String nombreArchivo = "C:\\Users\\Usuario\\Desktop\\programacion codigos\\probando cosas de java\\Fut5V2\\src\\main\\java\\org\\info\\javajedi\\service\\equipos.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir los datos del equipo en el archivo
            writer.write("Nombre del equipo: " + equipo.getNombreEquipo());
            writer.newLine();
            writer.write("Fecha de creación: " + equipo.getFechaCreacion());
            writer.newLine();
            writer.write("Nombre del entrenador: " + equipo.getEntrenador().getNombre());
            writer.newLine();
            writer.write("Apellido del entrenador: " + equipo.getEntrenador().getApellido());
            writer.newLine();
            writer.write("Edad del entrenador: " + equipo.getEntrenador().getEdad());
            writer.newLine();
            writer.write("Jugadores:");
            writer.newLine();
            for (Jugador jugador : equipo.getJugadores()) {
                writer.write("Identificador: " + jugador.getIdentificador());
                writer.newLine();
                writer.write("Nombre: " + jugador.getNombre());
                writer.newLine();
                writer.write("Apellido: " + jugador.getApellido());
                writer.newLine();
                writer.write("Altura: " + jugador.getAltura());
                writer.newLine();
                writer.write("Posición: " + jugador.getPosicion());
                writer.newLine();
                writer.write("Cantidad de goles: " + jugador.getCantidadGoles());
                writer.newLine();
                writer.write("Cantidad de partidos: " + jugador.getCantidadPartidos());
                writer.newLine();
                writer.write("Es capitán: " + jugador.isEsCapitan());
                writer.newLine();
                writer.write("Número de camiseta: " + jugador.getNumeroCamiseta());
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    @Override
    public void eliminarEquipo() {
        System.out.print("Ingrese el nombre del equipo que desea eliminar: ");
        String nombreEquipoEliminar = scanner.nextLine();

        String nombreArchivo = "C:\\Users\\Usuario\\Desktop\\programacion codigos\\probando cosas de java\\Fut5V2\\src\\main\\java\\org\\info\\javajedi\\service\\equipos.txt";
        String archivoTemporal = "C:\\Users\\Usuario\\Desktop\\programacion codigos\\probando cosas de java\\Fut5V2\\src\\main\\java\\org\\info\\javajedi\\service\\equipos.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String linea;
            boolean equipoEncontrado = false;

            while ((linea = reader.readLine()) != null) {
                if (linea.contains("Nombre del equipo: ")) {
                    String nombreEquipo = linea.substring(linea.indexOf(": ") + 2);

                    if (nombreEquipo.equals(nombreEquipoEliminar)) {
                        // Eliminar el equipo actual
                        skipTeam(reader);
                        equipoEncontrado = true;
                    } else {
                        writer.write(linea);
                        writer.newLine();
                    }
                } else {
                    writer.write(linea);
                    writer.newLine();
                }
            }

            if (!equipoEncontrado) {
                System.out.println("El equipo no se encontró en el archivo.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer/escribir en el archivo: " + e.getMessage());
        }

        // Renombrar el archivo temporal al nombre original
        try {
            java.nio.file.Files.move(java.nio.file.Paths.get(archivoTemporal),
                    java.nio.file.Paths.get(nombreArchivo),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Error al renombrar el archivo temporal: " + e.getMessage());
        }
    }

    private void skipTeam(BufferedReader reader) throws IOException {
        // Leer y descartar las líneas correspondientes al equipo
        String linea;
        while ((linea = reader.readLine()) != null) {
            if (linea.trim().isEmpty()) {
                // Fin del equipo
                break;
            }
        }
    }
}
