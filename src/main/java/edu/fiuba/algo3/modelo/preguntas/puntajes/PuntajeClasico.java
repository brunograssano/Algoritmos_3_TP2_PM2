package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.PuntajeChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.PuntajeVerdaderoFalso;
import java.util.ArrayList;

public class PuntajeClasico implements PuntajeChoice, PuntajeVerdaderoFalso {

    @Override
    public Resultado obtenerResultado(int respuestasCorrectasTotales, Jugador unJugador) {
        return new ResultadoClasico(respuestasCorrectasTotales,unJugador);
    }

    @Override
    public void puedeUsarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        modificador.usarEnPuntaje(this,modificadoresDeLaJugada);
    }

}
