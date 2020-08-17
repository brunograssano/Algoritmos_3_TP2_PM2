package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.resultados.Resultado;


public interface PuntajeChoice extends Puntaje {

    Resultado obtenerResultado(int respuestasCorrectasTotales, Jugador unJugador);

}

