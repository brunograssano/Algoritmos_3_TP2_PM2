package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaIncorrectaMultipleChoice;

import java.util.ArrayList;

public class RespuestaIncorrectaVerdaderoFalso implements Respuesta {
    private String enunciado;
    public RespuestaIncorrectaVerdaderoFalso(boolean respuestaIncorrecta) {
        enunciado = respuestaIncorrecta?"Verdadero":"Falso";
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaIncorrecta();
    }
}
