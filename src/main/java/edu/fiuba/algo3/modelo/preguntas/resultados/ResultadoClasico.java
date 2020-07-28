package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.Resultado;

public class ResultadoClasico extends Resultado {

    static final int PUNTOS_CLASICO = 1;
    
    public ResultadoClasico(int unaCantidadDeRespuesasCorrectasTotales) {
        super(unaCantidadDeRespuesasCorrectasTotales);
    }

    @Override
    public void calcular() {

        if(respuestasIncorrectas == 0 && respuestasCorrectasTotales == respuestasCorrectas){
            puntos = PUNTOS_CLASICO;
        }
    }
}
