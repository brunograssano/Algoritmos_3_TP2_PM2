package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public interface Puntaje {

    void puedeUsarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada);

    Resultado obtenerResultado(int respuestasCorrectasTotales, Jugador unJugador);
}
