package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;

public class RespuestaIncorrectaMultipleChoice implements Respuesta {

    private String textoRespuesta;

    public RespuestaIncorrectaMultipleChoice(String textoRespuestaIncorrecta) {
        this.textoRespuesta = textoRespuestaIncorrecta;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaIncorrecta();
    }

}
