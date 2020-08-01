package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import java.util.ArrayList;

public class Orden {

    ArrayList<RespuestaOrden> respuestasOrdenadas;

    public Orden(ArrayList<RespuestaOrden> unasRespuestasOrdenadas) {
        respuestasOrdenadas = unasRespuestasOrdenadas;
    }

    public boolean esIgual(Orden unOrden){
        return unOrden.poseeMismoOrden(respuestasOrdenadas);
    }

    private boolean poseeMismoOrden(ArrayList<RespuestaOrden> unOrdenRespuestas){
        return respuestasOrdenadas.equals(unOrdenRespuestas);
    }
}