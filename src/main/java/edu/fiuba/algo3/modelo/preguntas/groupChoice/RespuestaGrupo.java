package edu.fiuba.algo3.modelo.preguntas.groupChoice;

import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;

public class RespuestaGrupo implements Respuesta {

    private String enunciado;

    public RespuestaGrupo(String enunciado) {
            this.enunciado = enunciado;
    }

    @Override
    public void evaluar(Resultado unResultado) {
    }

}
