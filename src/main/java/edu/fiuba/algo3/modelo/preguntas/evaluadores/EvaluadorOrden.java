package edu.fiuba.algo3.modelo.preguntas.evaluadores;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class EvaluadorOrden implements Evaluador {

    ArrayList<OpcionSimple> respuestasOrdenadas;

    public EvaluadorOrden(ArrayList<OpcionSimple> respuestasOrdenadas){
        this.respuestasOrdenadas = respuestasOrdenadas;
    }

    @Override
    public void evaluar(Resultado unResultado, ArrayList<OpcionSimple> respuestasJugador) {
        if(respuestasOrdenadas.equals(respuestasJugador)){
            unResultado.sumarRespuestaCorrecta();
        }else{
            unResultado.sumarRespuestaIncorrecta();
        }
    }
}
