package edu.fiuba.algo3.modelo.preguntas.evaluadores;

import edu.fiuba.algo3.modelo.preguntas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class EvaluadorGrupo implements Evaluador {

    private Grupo grupo1;
    private Grupo grupo2;

    public EvaluadorGrupo(Grupo grupo1, Grupo grupo2){
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
    }

    @Override
    public void evaluar(Resultado unResultado, ArrayList<RespuestaGrupal> respuestasDelUsuario) {
        grupo1.contiene(unResultado,respuestasDelUsuario);

    }
}
