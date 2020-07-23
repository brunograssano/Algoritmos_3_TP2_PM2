package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface MetodoRespuesta {
    void agregarRespuestas(ArrayList<RespuestaComun> respuestas);

    void agregarTipo(TipoPuntaje unTipoPuntos);

    int evaluarClasico(ArrayList<RespuestaComun> respuestas);

    int evaluarPenalizable(ArrayList<RespuestaComun> respuestas);
}
