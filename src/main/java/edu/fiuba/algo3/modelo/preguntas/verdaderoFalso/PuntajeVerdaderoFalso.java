package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface PuntajeVerdaderoFalso extends Puntaje {

    Resultado obtenerResultado(int respuestasCorrectasTotales, Jugador unJugador);

}
