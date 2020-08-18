package edu.fiuba.algo3.modelo.preguntas.multipleChoice;

import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.resultados.Resultado;

public class OpcionIncorrectaMultipleChoice implements OpcionEvaluable {

    private String textoRespuesta;

    public OpcionIncorrectaMultipleChoice(String textoRespuestaIncorrecta) {
        this.textoRespuesta = textoRespuestaIncorrecta;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaIncorrecta();
    }

    public String obtenerTexto() {
        return textoRespuesta;
    }

}
