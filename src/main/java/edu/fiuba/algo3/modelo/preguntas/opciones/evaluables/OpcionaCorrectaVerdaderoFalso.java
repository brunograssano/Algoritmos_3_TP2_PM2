package edu.fiuba.algo3.modelo.preguntas.opciones.evaluables;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class OpcionaCorrectaVerdaderoFalso implements OpcionEvaluable {
    private String enunciado;
    public OpcionaCorrectaVerdaderoFalso(boolean respuestaCorrecta) {
        enunciado = respuestaCorrecta?"Verdadero":"Falso";
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaCorrecta();
    }
}
