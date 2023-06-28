package org.info.javajedi.domain;
import java.util.List;

public class Equipo {
    private String nombreEquipo;
    private String fechaCreacion;
    private Entrenador entrenador;
    private List<Jugador> jugadores;


    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Equipo(String nombreEquipo, String fechaCreacion, Entrenador entrenador, List<Jugador> jugadores) {
        this.nombreEquipo = nombreEquipo;
        this.fechaCreacion = fechaCreacion;
        this.entrenador = entrenador; // Asignación directa del objeto entrenador
        if (jugadores.size() != 5) {
            throw new IllegalArgumentException("Debes ingresar exactamente cinco jugadores.");
        }
        this.jugadores = jugadores;
    }

}

