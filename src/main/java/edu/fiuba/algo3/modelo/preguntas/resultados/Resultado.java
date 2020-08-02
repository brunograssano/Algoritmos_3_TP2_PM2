package edu.fiuba.algo3.modelo.preguntas.resultados;


import edu.fiuba.algo3.modelo.preguntas.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.modificadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;

public interface Resultado {


    void sumarRespuestaCorrecta();

    void sumarRespuestaIncorrecta();

    Punto obtenerPuntos();

    void aplicarMultiplicador(Multiplicador multiplicador);

    void aplicaExclusividad(AnalizadorExclusividad analizador);
}
