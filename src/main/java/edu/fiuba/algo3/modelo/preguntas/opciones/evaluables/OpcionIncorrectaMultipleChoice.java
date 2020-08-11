package edu.fiuba.algo3.modelo.preguntas.opciones.evaluables;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class OpcionIncorrectaMultipleChoice implements OpcionEvaluable {

    private String textoRespuesta;

    public OpcionIncorrectaMultipleChoice(String textoRespuestaIncorrecta) {
        this.textoRespuesta = textoRespuestaIncorrecta;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaIncorrecta();
    }

    @Override
    public String obtenerTexto() {
        return textoRespuesta;
    }

}
