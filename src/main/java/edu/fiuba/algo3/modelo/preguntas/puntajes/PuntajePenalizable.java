package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.preguntas.multipleChoice.PuntajeChoice;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.PuntajeVerdaderoFalso;

public class PuntajePenalizable implements PuntajeChoice, PuntajeVerdaderoFalso {


    @Override
    public Resultado obtenerResultado(int respuestasCorrectasTotales) {
        return new ResultadoPenalizable();
    }
}
