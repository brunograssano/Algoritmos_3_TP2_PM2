package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.preguntas.Resultado;

public interface PuntajeChoice {

    void evaluar(Resultado unResultado);

    Resultado obtenerResultado(int respuestasCorrectasTotales);
}

