package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.Resultado;

public class ResultadoEleccion implements Resultado {

    private int respuestasCorrectas;
    private int respuestasIncorrectas;
    private int puntos;
    private int respuestasCorrectasTotales;
    static final int PUNTOS_CLASICO = 1;

    public ResultadoEleccion(int unaCantidadDeRespuesasCorrectasTotales){
        respuestasCorrectas=0;
        respuestasIncorrectas=0;
        puntos=0;
        respuestasCorrectasTotales = unaCantidadDeRespuesasCorrectasTotales;
    }

    @Override
    public void sumarRespuestaCorrecta() {
        respuestasCorrectas++;
    }

    @Override
    public void sumarRespuestaIncorrecta() {
        respuestasIncorrectas++;
    }

    @Override
    public void calcularClasico() {
        if(respuestasIncorrectas==0 && respuestasCorrectasTotales==respuestasCorrectas){
            puntos=PUNTOS_CLASICO;
        }
    }

    @Override
    public void calcularPenalizable() {
        puntos = respuestasCorrectas - respuestasIncorrectas;
    }

    @Override
    public void calcularParcial() {
        if(respuestasIncorrectas == 0) {
            puntos=respuestasCorrectas;
        }
    }

    @Override
    public int obtenerPuntos() {
        return puntos;
    }
}
