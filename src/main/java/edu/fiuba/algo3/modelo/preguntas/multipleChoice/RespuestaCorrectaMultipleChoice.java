package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaCorrectaMultipleChoice implements RespuestaIndividual {


    private String textoRespuesta;

    public RespuestaCorrectaMultipleChoice(String textoRespuestaCorrecta) {
        this.textoRespuesta = textoRespuestaCorrecta;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaCorrecta();
    }

}
