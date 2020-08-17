package edu.fiuba.algo3.modelo.puntos;

public class PuntoNulo implements Punto {

    static final int VALOR_PUNTO_NULO = 0;

    @Override
    public Puntuacion multiplicar(int factor) {
        Puntuacion puntosMultiplicados = new Puntuacion();
        puntosMultiplicados.agregarPunto(this);
        return puntosMultiplicados;
    }

    @Override
    public void valorNumerico(PuntuacionRepresentable puntuacionRepresentable) {
        puntuacionRepresentable.agregarValor(VALOR_PUNTO_NULO);
    }

}
