package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class OpcionIncorrectaVerdaderoFalso implements OpcionEvaluable {
    private String textoRespuesta;

    public OpcionIncorrectaVerdaderoFalso(boolean respuestaIncorrecta) {
        textoRespuesta = respuestaIncorrecta?"Verdadero":"Falso";
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaIncorrecta();
    }

    public String obtenerTexto() {
        return textoRespuesta;
    }
}
