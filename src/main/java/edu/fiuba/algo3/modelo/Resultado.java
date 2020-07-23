package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Resultado {

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
        return respuestasCorrectasRespondidas;
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
