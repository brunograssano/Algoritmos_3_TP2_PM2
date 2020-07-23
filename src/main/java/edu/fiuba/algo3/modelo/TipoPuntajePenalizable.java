package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TipoPuntajePenalizable implements TipoPuntaje{
    @Override
    public int evaluar(MetodoRespuesta metodo, ArrayList<RespuestaComun> respuestas) {
        return metodo.evaluarPenalizable(respuestas);
    }
}
