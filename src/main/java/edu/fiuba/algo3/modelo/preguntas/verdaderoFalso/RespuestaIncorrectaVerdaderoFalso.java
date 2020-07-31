package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaIncorrectaVerdaderoFalso implements RespuestaIndividual {
    private String enunciado;
    public RespuestaIncorrectaVerdaderoFalso(boolean respuestaIncorrecta) {
        enunciado = respuestaIncorrecta?"Verdadero":"Falso";
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaIncorrecta();
    }
}
