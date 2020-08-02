package edu.fiuba.algo3.modelo.preguntas.groupChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.EvaluadorGrupo;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;


public class GroupChoice implements Pregunta {

    private Grupo grupo1;
    private Grupo grupo2;
    private String enunciado;
    private PuntajeClasico puntaje;

    public GroupChoice(String enunciado, Grupo grupo1,Grupo grupo2){
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
        this.enunciado = enunciado;
        puntaje = new PuntajeClasico();
    }

    @Override
    public Resultado evaluar(RespuestaJugador respuestasUsuario) {
        Resultado unResultado = puntaje.obtenerResultado(1);
        EvaluadorGrupo evaluador = new EvaluadorGrupo(grupo1,grupo2);
        respuestasUsuario.evaluarConParametro(unResultado, evaluador);
        return unResultado;
    }

    @Override
    public void verificarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        puntaje.puedeUsarModificador(modificador,modificadoresDeLaJugada);
    }
}
