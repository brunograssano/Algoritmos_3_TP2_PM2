package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import java.util.ArrayList;

public interface PuntajeChoice extends Puntaje {

    Resultado obtenerResultado(int respuestasCorrectasTotales, Jugador unJugador);

    void puedeUsarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada);
}

