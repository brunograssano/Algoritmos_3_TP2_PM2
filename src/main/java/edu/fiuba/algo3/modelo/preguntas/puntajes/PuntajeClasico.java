package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.PuntajeChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.PuntajeVerdaderoFalso;

import java.util.ArrayList;

public class PuntajeClasico implements PuntajeChoice, PuntajeVerdaderoFalso {

    @Override
    public Resultado obtenerResultado(int respuestasCorrectasTotales) {
        return new ResultadoClasico(respuestasCorrectasTotales);
    }

    @Override
    public void puedeUsarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        modificador.usarEnPuntaje(this,modificadoresDeLaJugada);
    }

}
