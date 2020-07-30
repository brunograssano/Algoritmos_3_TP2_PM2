package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;

public class EstadoCorrectoParcial implements EstadoResultadoParcial {

    private Puntuacion puntos;

    public EstadoCorrectoParcial(){
        puntos = new Puntuacion();
    }

    @Override
    public void agregarPunto(Punto unPunto) {
        puntos.agregarPunto(unPunto);
    }

    @Override
    public Punto obtenerPuntos() {
        return puntos;
    }
}
