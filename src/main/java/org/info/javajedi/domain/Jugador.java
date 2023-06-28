package org.info.javajedi.domain;



public class Jugador {
    private int identificador;
    private String nombre;
    private String apellido;
    private double altura;
    private String posicion;
    private int cantidadGoles;
    private int cantidadPartidos;
    private boolean esCapitan;
    private int numeroCamiseta;
    private String equipo;

    public Jugador( int identificador, String nombre, String apellido, double altura, String posicion, int cantidadGoles, int cantidadPartidos, boolean esCapitan, int numeroCamiseta) {
        
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.posicion = posicion;
        this.cantidadGoles = cantidadGoles;
        this.cantidadPartidos = cantidadPartidos;
        this.esCapitan = esCapitan;
        this.numeroCamiseta = numeroCamiseta;
        this.equipo = "";
    }

      public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }


    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(int cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }

    public int getCantidadPartidos() {
        return cantidadPartidos;
    }

    public void setCantidadPartidos(int cantidadPartidos) {
        this.cantidadPartidos = cantidadPartidos;
    }

    public boolean isEsCapitan() {
        return esCapitan;
    }

    public void setEsCapitan(boolean esCapitan) {
        this.esCapitan = esCapitan;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }




}