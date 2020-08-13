package edu.fiuba.algo3.modelo.preguntas.resultados;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.PuntoPositivo;

public class ResultadoParcial implements Resultado {

    private EstadoResultadoParcial estado;
    private Jugador jugador;

    public ResultadoParcial(Jugador unJugador){
        estado = new EstadoCorrectoParcial();
        jugador = unJugador;
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

    @Override
    public void aplicarMultiplicador(Multiplicador multiplicador) {
        estado.multiplicarPuntos(multiplicador,jugador);
    }

    @Override
    public void aplicaExclusividad(AnalizadorExclusividad analizador) {
        estado.verSiAplicaExclusividad(this,analizador);
    }
}
