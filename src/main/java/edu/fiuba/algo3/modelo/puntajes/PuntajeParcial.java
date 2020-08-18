package edu.fiuba.algo3.modelo.puntajes;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.PuntajeChoice;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import edu.fiuba.algo3.modelo.resultados.ResultadoParcial;
import java.util.ArrayList;

public class PuntajeParcial implements PuntajeChoice {

    @Override
    public Resultado obtenerResultado(int respuestasCorrectasTotales, Jugador unJugador) {
        return new ResultadoParcial(unJugador);
    }

    @Override
    public void puedeUsarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        modificador.usarEnPuntaje(this,modificadoresDeLaJugada);
    }
}
