package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaCorrectaVerdaderoFalso implements RespuestaIndividual {
    private String enunciado;
    public RespuestaCorrectaVerdaderoFalso(boolean respuestaCorrecta) {
        enunciado = respuestaCorrecta?"Verdadero":"Falso";
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaCorrecta();
    }
}
