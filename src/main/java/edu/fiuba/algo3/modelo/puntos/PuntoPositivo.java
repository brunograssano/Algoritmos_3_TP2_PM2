package edu.fiuba.algo3.modelo.puntos;

public class PuntoPositivo implements Punto {

    static final int VALOR_PUNTO_POSITVO = 1;

    @Override
    public Puntuacion multiplicar(int factor) {
        Puntuacion puntosMultiplicados = new Puntuacion();
        for(int i = 0; i < factor ; i++){
            puntosMultiplicados.agregarPunto(this);
        }
        return puntosMultiplicados;
    }

    @Override
    public void valorNumerico(PuntuacionRepresentable puntuacionRepresentable) {
        puntuacionRepresentable.agregarValor(VALOR_PUNTO_POSITVO);
    }

}
