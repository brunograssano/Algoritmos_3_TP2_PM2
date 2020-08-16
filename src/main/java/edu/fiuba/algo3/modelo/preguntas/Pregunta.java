package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import java.util.ArrayList;

public abstract class Pregunta {

    protected Puntaje puntaje;
    protected String enunciado;

    public Pregunta(String enunciado,Puntaje puntaje){
        this.enunciado = enunciado;
        this.puntaje = puntaje;
    }

    public abstract Resultado responder(Respuesta respuestasUsuario, Jugador unJugador);

    public void verificarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada) {
        puntaje.puedeUsarModificador(modificador,modificadoresDeLaJugada);
    }

    public String textoPregunta() {
        return enunciado;
    }

    public Puntaje tipoPuntaje(){
        return puntaje;
    }

}
