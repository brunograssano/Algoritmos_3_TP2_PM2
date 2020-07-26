package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaCorrectaMultipleChoice;

import java.util.ArrayList;

public class RespuestaCorrectaVerdaderoFalso implements Respuesta {
    private String enunciado;
    public RespuestaCorrectaVerdaderoFalso(boolean respuestaCorrecta) {
        enunciado = respuestaCorrecta?"Verdadero":"Falso";
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaCorrecta();
    }
}
