package org.info.javajedi.domain;

public class Entrenador {
    private String nombre;
    private String apellido;
    private int edad;

    public Entrenador(String nombreEntrenador, String apellidoEntrenador, int edadEntrenador) {
        this.nombre = nombreEntrenador;
        this.apellido = apellidoEntrenador;
        this.edad = edadEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
