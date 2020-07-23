package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface MetodoRespuesta {
    void agregarRespuestas(ArrayList<RespuestaCorrecta> respuestasCorrectas,ArrayList<RespuestaIncorrecta> respuestasIncorrectas);

    //int evaluarClasico(ArrayList<RespuestaComun> respuestas);

    //int evaluarPenalizable(ArrayList<RespuestaComun> respuestas);

    Resultado evaluar(ArrayList<RespuestaComun> respuestasUsuario);
}
