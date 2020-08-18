package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.resultados.Resultado;

public interface PuntajeVerdaderoFalso extends Puntaje {

    Resultado obtenerResultado(int respuestasCorrectasTotales, Jugador unJugador);

}
