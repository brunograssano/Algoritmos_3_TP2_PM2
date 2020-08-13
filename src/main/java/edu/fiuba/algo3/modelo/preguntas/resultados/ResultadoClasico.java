package edu.fiuba.algo3.modelo.preguntas.resultados;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.PuntoPositivo;

public class ResultadoClasico implements Resultado {

    private EstadoResultadoClasico estado;
    private Jugador jugador;

    public ResultadoClasico(int unaCantidadDeRespuesasCorrectasTotales, Jugador unJugador) {
        estado = new EstadoCorrectoClasico(unaCantidadDeRespuesasCorrectasTotales);
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
