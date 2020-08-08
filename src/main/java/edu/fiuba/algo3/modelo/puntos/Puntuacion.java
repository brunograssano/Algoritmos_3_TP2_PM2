package edu.fiuba.algo3.modelo.puntos;

import java.util.ArrayList;

public class Puntuacion implements Punto {

    private ArrayList<Punto> puntos;

    public Puntuacion(){
        puntos = new ArrayList<Punto>();
    }

    public void agregarPunto(Punto unPunto){
        puntos.add(unPunto);
    }

    @Override
    public void valorNumerico(PuntuacionRepresentable puntuacionRepresentable) {
        for (Punto punto:puntos) {
            punto.valorNumerico(puntuacionRepresentable);
        }
    }

    public int representar() {
        PuntuacionRepresentable puntuacionRepresentable = new PuntuacionRepresentable();
        for (Punto punto:puntos) {
            punto.valorNumerico(puntuacionRepresentable);
        }
        return puntuacionRepresentable.representar();
    }

    public Puntuacion multiplicar(int factor) {
        Puntuacion puntuacionMultiplicada = new Puntuacion();
        for (Punto punto:puntos) {
            puntuacionMultiplicada.agregarPunto(punto.multiplicar(factor));
        }
        return puntuacionMultiplicada;
    }
}
