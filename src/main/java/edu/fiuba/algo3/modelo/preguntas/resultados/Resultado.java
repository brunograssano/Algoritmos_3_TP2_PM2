package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;

public interface Resultado {


    void sumarRespuestaCorrecta();

    void sumarRespuestaIncorrecta();

    Punto obtenerPuntos();

    void aplicarModificador(Multiplicador multiplicador);
}
