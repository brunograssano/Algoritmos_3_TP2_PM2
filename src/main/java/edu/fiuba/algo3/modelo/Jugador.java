package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;

public class Jugador {
    private String nombre;
    private Puntuacion puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = new Puntuacion();
    }

    public void sumarPuntos(Punto unosPuntos){
        puntos.agregarPunto(unosPuntos);
    }

    public int obtenerPuntos(){
        return puntos.valorNumerico();
    }

}
