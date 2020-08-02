package edu.fiuba.algo3.modelo.preguntas.resultados;


import edu.fiuba.algo3.modelo.preguntas.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.modificadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoPositivo;

public class ResultadoParcial implements Resultado {

    private EstadoResultadoParcial estado;

    public ResultadoParcial(){
        estado = new EstadoCorrectoParcial();
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
        estado.multiplicarPuntos(multiplicador);
    }

    @Override
    public void aplicaExclusividad(AnalizadorExclusividad analizador) {
        estado.verSiAplicaExclusividad(this,analizador);
    }
}
