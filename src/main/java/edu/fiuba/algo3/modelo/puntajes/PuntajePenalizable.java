package edu.fiuba.algo3.modelo.puntajes;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.PuntajeChoice;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import edu.fiuba.algo3.modelo.resultados.ResultadoPenalizable;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.PuntajeVerdaderoFalso;
import java.util.ArrayList;

public class PuntajePenalizable implements PuntajeChoice, PuntajeVerdaderoFalso {


    @Override
    public Resultado obtenerResultado(int respuestasCorrectasTotales, Jugador unJugador) {
        return new ResultadoPenalizable(unJugador);
    }

    @Override
    public void puedeUsarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        modificador.usarEnPuntaje(this,modificadoresDeLaJugada);
    }



}
