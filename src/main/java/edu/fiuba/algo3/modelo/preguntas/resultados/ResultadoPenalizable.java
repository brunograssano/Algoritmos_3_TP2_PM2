package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;
import edu.fiuba.algo3.modelo.puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.puntos.PuntoPositivo;

public class ResultadoPenalizable implements Resultado {

    private Puntuacion puntos;
    private Jugador jugador;

    public ResultadoPenalizable(Jugador unJugador){
        puntos = new Puntuacion();
        jugador = unJugador;
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
    public void aplicarMultiplicador(Multiplicador multiplicador) {
        puntos = multiplicador.usarEnPuntos(puntos,jugador);
    }

    @Override
    public void aplicaExclusividad(AnalizadorExclusividad analizador) {
    }

}
