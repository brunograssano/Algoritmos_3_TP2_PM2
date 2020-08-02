package edu.fiuba.algo3.modelo.preguntas.opciones.evaluables;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class OpcionIncorrectaVerdaderoFalso implements OpcionEvaluable {
    private String enunciado;

    public OpcionIncorrectaVerdaderoFalso(boolean respuestaIncorrecta) {
        enunciado = respuestaIncorrecta?"Verdadero":"Falso";
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaIncorrecta();
    }
}
