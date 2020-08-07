package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;

import java.util.ArrayList;

public class Orden {

    ArrayList<OpcionSimple> respuestasOrdenadas;

    public Orden(ArrayList<OpcionSimple> unasRespuestasOrdenadas) {
        respuestasOrdenadas = unasRespuestasOrdenadas;
    }

    public boolean esIgual(Orden unOrden){
        return unOrden.poseeMismoOrden(respuestasOrdenadas);
    }

    private boolean poseeMismoOrden(ArrayList<OpcionSimple> unOrdenRespuestas){
        return respuestasOrdenadas.equals(unOrdenRespuestas);
    }
}