package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.Resultado;

public class ResultadoPenalizable  extends Resultado {

    public ResultadoPenalizable(int unaCantidadDeRespuesasCorrectasTotales) {
        super(unaCantidadDeRespuesasCorrectasTotales);
    }

    @Override
    public void calcular() {
        puntos = respuestasCorrectas - respuestasIncorrectas;
    }
}
