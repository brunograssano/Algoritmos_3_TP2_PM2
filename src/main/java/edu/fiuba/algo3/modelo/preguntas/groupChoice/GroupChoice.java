package edu.fiuba.algo3.modelo.preguntas.groupChoice;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;

import java.util.ArrayList;


public class GroupChoice implements Pregunta {

    private ArrayList<RespuestaGrupo> respuestaGrupo1Correcta;
    private ArrayList<RespuestaGrupo> respuestaGrupo2Correcta;
    private String enunciado;

    public GroupChoice(String enunciado, ArrayList<RespuestaGrupo> grupo1,ArrayList<RespuestaGrupo> grupo2){
        respuestaGrupo1Correcta = grupo1;
        respuestaGrupo2Correcta = grupo2;
        this.enunciado = enunciado;
    }

    @Override
    public Resultado evaluar(RespuestaJugador respuestasUsuario) {
        Resultado unResultado = new ResultadoClasico(1);
        respuestasUsuario.evaluarGrupo(unResultado, respuestaGrupo1Correcta, respuestaGrupo2Correcta);
        return unResultado;
    }
}
