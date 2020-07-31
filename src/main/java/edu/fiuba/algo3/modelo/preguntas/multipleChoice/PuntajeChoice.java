package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface PuntajeChoice {

    Resultado obtenerResultado(int respuestasCorrectasTotales);
}

