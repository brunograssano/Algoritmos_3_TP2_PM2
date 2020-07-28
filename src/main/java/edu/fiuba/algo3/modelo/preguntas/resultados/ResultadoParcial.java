package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.Resultado;

public class ResultadoParcial extends Resultado {

    public ResultadoParcial(int unaCantidadDeRespuesasCorrectasTotales) {
        super(unaCantidadDeRespuesasCorrectasTotales);
    }

    @Override
    public void calcular() {
        if(respuestasIncorrectas == 0) {
            puntos = respuestasCorrectas;
        }
    }
}
