package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.Resultado;

public abstract class Resultado {

    protected int respuestasCorrectas;
    protected int respuestasIncorrectas;
    protected int puntos;
    protected int respuestasCorrectasTotales;


    public abstract void calcular();

    public Resultado(int unaCantidadDeRespuesasCorrectasTotales){
        respuestasCorrectas = 0;
        respuestasIncorrectas = 0;
        puntos = 0;
        respuestasCorrectasTotales = unaCantidadDeRespuesasCorrectasTotales;
    }

    public void sumarRespuestaCorrecta() {
        respuestasCorrectas++;
    }

    public void sumarRespuestaIncorrecta() {
        respuestasIncorrectas++;
    }


    public int obtenerPuntos() {
        return puntos;
    }
}
