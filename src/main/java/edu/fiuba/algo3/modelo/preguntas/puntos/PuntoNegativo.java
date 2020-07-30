package edu.fiuba.algo3.modelo.preguntas.puntos;

public class PuntoNegativo implements Punto {

    static final int VALOR_PUNTO_NEGATIVO = -1;

    @Override
    public int valorNumerico() {
        return VALOR_PUNTO_NEGATIVO;
    }

}
