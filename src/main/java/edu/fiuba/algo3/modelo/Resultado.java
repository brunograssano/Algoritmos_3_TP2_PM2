package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Resultado {

    private static final int PUNTAJE_CORRECTO_CLASICO = 1;
    private static final int PUNTAJE_INCORRECTO_CLASICO = 0;
    private int respuestasCorrectasRespondidas;
    private int respuestasCorrectasTotales;
    private int respuestasIncorrectasRespondidas;

    public Resultado(int cantidadDeRespuestasCorrectasTotales){
        this.respuestasCorrectasRespondidas = 0;
        this.respuestasCorrectasTotales = cantidadDeRespuestasCorrectasTotales;
        this.respuestasIncorrectasRespondidas = 0;
    }

    public void sumarRespuestaCorrecta() {
        this.respuestasCorrectasRespondidas++;
    }

    public void sumarRespuestaIncorrecta() {
        this.respuestasIncorrectasRespondidas++;
    }

    public int calcularClasico() {
        if(respuestasCorrectasRespondidas == respuestasCorrectasTotales && respuestasIncorrectasRespondidas == 0){
            return PUNTAJE_CORRECTO_CLASICO;
        }
        return PUNTAJE_INCORRECTO_CLASICO;
    }

    public int calcularPenalizable() {
        return (respuestasCorrectasRespondidas - respuestasIncorrectasRespondidas);
    }

    public int calcularParcial() {
        if (respuestasIncorrectasRespondidas == 0){
            return respuestasCorrectasRespondidas;
        }
        return 0;
    }
}
