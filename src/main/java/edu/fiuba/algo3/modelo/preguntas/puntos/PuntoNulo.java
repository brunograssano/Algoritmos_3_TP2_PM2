package edu.fiuba.algo3.modelo.preguntas.puntos;

public class PuntoNulo implements Punto {

    static final int VALOR_PUNTO_NULO = 0;

    @Override
    public int valorNumerico() {
        return VALOR_PUNTO_NULO;
    }
}
