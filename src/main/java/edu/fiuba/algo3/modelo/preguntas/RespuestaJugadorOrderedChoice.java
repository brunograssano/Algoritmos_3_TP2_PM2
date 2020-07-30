package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;

import java.util.ArrayList;

public class RespuestaJugadorOrderedChoice implements RespuestaJugador {

    private ArrayList<Respuesta> respuestasJugador;

    public RespuestaJugadorOrderedChoice(ArrayList<Respuesta> respuestasUsuario){
        this.respuestasJugador = respuestasUsuario;
    }

    @Override
    public void evaluar(Resultado unResultado) {
    }

    public void evaluarOrden(Resultado unResultado,ArrayList<RespuestaOrden> respuestasOrdenadasCorrectamente){
        if(respuestasOrdenadasCorrectamente.equals(respuestasJugador)){
            unResultado.sumarRespuestaCorrecta();
        }else{
            unResultado.sumarRespuestaIncorrecta();
        }
    }
}
