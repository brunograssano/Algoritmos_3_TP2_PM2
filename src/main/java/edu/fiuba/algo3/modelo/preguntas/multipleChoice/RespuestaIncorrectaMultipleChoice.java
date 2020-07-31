package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaIncorrectaMultipleChoice implements RespuestaIndividual {

    private String textoRespuesta;

    public RespuestaIncorrectaMultipleChoice(String textoRespuestaIncorrecta) {
        this.textoRespuesta = textoRespuestaIncorrecta;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaIncorrecta();
    }

}
