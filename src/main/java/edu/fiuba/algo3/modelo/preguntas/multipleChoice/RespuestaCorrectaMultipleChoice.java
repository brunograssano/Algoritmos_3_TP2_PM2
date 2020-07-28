package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;

public class RespuestaCorrectaMultipleChoice implements Respuesta {


    private String textoRespuesta;

    public RespuestaCorrectaMultipleChoice(String textoRespuestaCorrecta) {
        this.textoRespuesta = textoRespuestaCorrecta;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaCorrecta();
    }

}
