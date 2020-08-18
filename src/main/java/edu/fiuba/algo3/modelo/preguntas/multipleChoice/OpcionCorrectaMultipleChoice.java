package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.resultados.Resultado;

public class OpcionCorrectaMultipleChoice implements OpcionEvaluable {


    private String textoRespuesta;

    public OpcionCorrectaMultipleChoice(String textoRespuestaCorrecta) {
        this.textoRespuesta = textoRespuestaCorrecta;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaCorrecta();
    }

    public String obtenerTexto() {
        return textoRespuesta;
    }

}
