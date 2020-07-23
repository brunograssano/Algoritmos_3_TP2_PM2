package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntos;
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    /* A borrar probablemente
    public void sumarPuntos(int unosPuntos){
        puntos += unosPuntos;
    }
    */


    public int obtenerPuntos(){
        return puntos;
    }

    public void responder(Pregunta unaPregunta, ArrayList<RespuestaComun> respuestasJugador) {
        puntos += unaPregunta.responder(respuestasJugador);
    }
}
