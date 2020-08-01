package edu.fiuba.algo3.modelo.preguntas.groupChoice;

import edu.fiuba.algo3.modelo.preguntas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class RespuestaGrupo implements RespuestaGrupal {

    private String enunciado;

    public RespuestaGrupo(String enunciado) {
            this.enunciado = enunciado;
    }
}
