package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoPositivo;

public class ResultadoPenalizable implements Resultado {

    private Puntuacion puntos;

    public ResultadoPenalizable(){
        puntos = new Puntuacion();
    }

    @Override
    public void sumarRespuestaCorrecta() {
        puntos.agregarPunto(new PuntoPositivo());
    }

    @Override
    public void sumarRespuestaIncorrecta() {
        puntos.agregarPunto(new PuntoNegativo());
    }

    @Override
    public Punto obtenerPuntos() {
        return puntos;
    }

    @Override
    public void aplicarModificador(Multiplicador multiplicador) {
        multiplicador.usarEnPuntos(puntos);
    }
}
