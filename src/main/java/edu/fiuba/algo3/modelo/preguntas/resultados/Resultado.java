package edu.fiuba.algo3.modelo.preguntas.resultados;


import edu.fiuba.algo3.modelo.modificadores.exclusividad.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.puntos.Punto;

public interface Resultado {

    void sumarRespuestaCorrecta();

    void sumarRespuestaIncorrecta();

    Punto obtenerPuntos();

    void aplicarMultiplicador(Multiplicador multiplicador);

    void aplicaExclusividad(AnalizadorExclusividad analizador);
}
