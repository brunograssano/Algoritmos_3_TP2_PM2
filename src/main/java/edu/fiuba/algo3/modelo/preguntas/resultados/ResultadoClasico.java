package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoPositivo;

public class ResultadoClasico implements Resultado {

    private EstadoResultadoClasico estado;

    public ResultadoClasico(int unaCantidadDeRespuesasCorrectasTotales) {
        estado = new EstadoCorrectoClasico(unaCantidadDeRespuesasCorrectasTotales);
    }


    @Override
    public void sumarRespuestaCorrecta() {
        estado.agregarPunto(new PuntoPositivo());
    }

    @Override
    public void sumarRespuestaIncorrecta() {
        estado = new EstadoIncorrecto();
    }

    @Override
    public Punto obtenerPuntos() {
        return estado.obtenerPuntos();
    }


}
