package edu.fiuba.algo3.modelo.preguntas.puntos;

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
    public int valorNumerico() {
        int total=0;
        for (Punto punto:puntos) {
            total+=punto.valorNumerico();
        }
        return total;
    }

    public void multiplicar(int factor) {
        ArrayList<Punto> puntosIniciales = (ArrayList<Punto>) puntos.clone();
        for(int i=1; i < factor ; i++){
            puntos.addAll(puntosIniciales);
        }
    }
}
