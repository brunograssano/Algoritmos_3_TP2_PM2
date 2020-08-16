package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class OpcionCorrectaVerdaderoFalso implements OpcionEvaluable {
    private String textoRespuesta;
    public OpcionCorrectaVerdaderoFalso(boolean respuestaCorrecta) {
        textoRespuesta = respuestaCorrecta?"Verdadero":"Falso";
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaCorrecta();
    }

    public String obtenerTexto() {
        return textoRespuesta;
    }
}
