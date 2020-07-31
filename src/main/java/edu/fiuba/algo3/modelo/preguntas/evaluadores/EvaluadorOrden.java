package edu.fiuba.algo3.modelo.preguntas.evaluadores;

import edu.fiuba.algo3.modelo.preguntas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.preguntas.evaluadores.Evaluador;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class EvaluadorOrden implements Evaluador {

    ArrayList<RespuestaOrden> respuestasOrdenadas;

    public EvaluadorOrden(ArrayList<RespuestaOrden> respuestasOrdenadas){
        this.respuestasOrdenadas = respuestasOrdenadas;
    }

    @Override
    public void evaluar(Resultado unResultado, ArrayList<RespuestaGrupal> respuestasJugador) {
        if(respuestasOrdenadas.equals(respuestasJugador)){
            unResultado.sumarRespuestaCorrecta();
        }else{
            unResultado.sumarRespuestaIncorrecta();
        }
    }
}
