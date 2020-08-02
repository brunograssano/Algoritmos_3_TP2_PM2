package edu.fiuba.algo3.modelo.preguntas.opciones.evaluables;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class OpcionCorrectaVerdaderoFalso implements OpcionEvaluable {
    private String enunciado;
    public OpcionCorrectaVerdaderoFalso(boolean respuestaCorrecta) {
        enunciado = respuestaCorrecta?"Verdadero":"Falso";
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaCorrecta();
    }
}
