package edu.fiuba.algo3.modelo.preguntas.groupChoice;

import edu.fiuba.algo3.modelo.preguntas.evaluadores.EvaluadorGrupo;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;


public class GroupChoice implements Pregunta {

    private Grupo grupo1;
    private Grupo grupo2;

//    private ArrayList<RespuestaGrupo> respuestaGrupo1Correcta;
  //  private ArrayList<RespuestaGrupo> respuestaGrupo2Correcta;
    private String enunciado;

    public GroupChoice(String enunciado, Grupo grupo1,Grupo grupo2){
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
        this.enunciado = enunciado;
    }

    @Override
    public Resultado evaluar(RespuestaJugador respuestasUsuario) {
        Resultado unResultado = new ResultadoClasico(1);
        EvaluadorGrupo evaluador = new EvaluadorGrupo(grupo1,grupo2);
        respuestasUsuario.evaluarConParametro(unResultado, evaluador);
        return unResultado;
    }
}
