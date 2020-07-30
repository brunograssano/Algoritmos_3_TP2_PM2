package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNulo;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;

public class EstadoCorrectoClasico implements EstadoResultadoClasico {

    private int cantidadDeRespuestasCorrectasTotales;
    private Puntuacion puntos;

    public EstadoCorrectoClasico(int unaCantidadDeRespuesasCorrectasTotales){
        cantidadDeRespuestasCorrectasTotales = unaCantidadDeRespuesasCorrectasTotales;
        puntos = new Puntuacion();
    }

    @Override
    public void agregarPunto(Punto unPunto) {
        puntos.agregarPunto(unPunto);
    }

    @Override
    public Punto obtenerPuntos() {
        Punto punto = new PuntoNulo();
        if(puntos.valorNumerico() == cantidadDeRespuestasCorrectasTotales){
            punto = new PuntoPositivo();
        }
        return punto;
    }

}
