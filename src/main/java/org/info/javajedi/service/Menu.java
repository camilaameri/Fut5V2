package org.info.javajedi.service;
import java.util.Scanner;
import org.info.javajedi.service.buscarequipos.BuscarEquiposI;
import org.info.javajedi.service.buscarequipos.imp.BuscarEquipos;
import org.info.javajedi.service.crearequipos.CrearEquiposI;
import org.info.javajedi.service.crearequipos.imp.CrearEquipo;
import org.info.javajedi.service.jugadorservice.JugadorI;
import org.info.javajedi.service.jugadorservice.imp.JugadorService;

public class Menu {
    private CrearEquiposI crearEquiposI;
    private JugadorI jugadorI;
    private BuscarEquiposI buscarEquiposI;
    private Scanner scanner;

    public Menu() {
        crearEquiposI = new CrearEquipo();
        jugadorI = new JugadorService();
        buscarEquiposI = new BuscarEquipos();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Crear equipo");
            System.out.println("2. Buscar jugador por nombre");
            System.out.println("3. Buscar equipo por nombre");
            System.out.println("4. Buscar equipo en orden alfabetico");
            System.out.println("5. Buscar equipo por orden de camiseta");
            System.out.println("6. Eliminar equipo");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    crearEquiposI.crearEquipo();
                    break;
                case 2:
                    jugadorI.buscarJugadorPorNombre();
                    break;
                case 3:
                    buscarEquiposI.buscarEquipoPorNombre();
                    break;
               /* case 4:
                    buscarEquiposI.buscarEquipoAlfabeticamente();
                    break;
                case 5:
                    buscarEquiposI.buscarEquipoPorCamiseta();
                    break;
                case 6:
                    crearEquiposI.eliminarEquipo();
                    break;*/
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            System.out.println();
        } while (opcion != 7);
    }
}
