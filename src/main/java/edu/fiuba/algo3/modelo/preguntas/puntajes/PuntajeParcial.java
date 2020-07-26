package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.preguntas.multipleChoice.PuntajeChoice;
import edu.fiuba.algo3.modelo.preguntas.Resultado;

public class PuntajeParcial implements PuntajeChoice {
    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.calcularParcial();
    }
}
