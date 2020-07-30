package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNulo;

public class EstadoIncorrecto implements EstadoResultadoParcial,EstadoResultadoClasico {

    private PuntoNulo puntoNulo;

    public EstadoIncorrecto(){
        puntoNulo = new PuntoNulo();
    }

    @Override
    public void agregarPunto(Punto unPunto) {
    }

    @Override
    public Punto obtenerPuntos() {
        return puntoNulo;
    }


}
