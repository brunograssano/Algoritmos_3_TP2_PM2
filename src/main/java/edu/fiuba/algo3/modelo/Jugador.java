package edu.fiuba.algo3.modelo;

public class Jugador {
    private String nombre;
    private int puntos;
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public void sumarPuntos(int unosPuntos){
        puntos += unosPuntos;
    }

    public int obtenerPuntos(){
        return puntos;
    }
}
