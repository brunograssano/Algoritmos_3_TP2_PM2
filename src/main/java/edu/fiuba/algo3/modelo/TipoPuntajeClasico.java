package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TipoPuntajeClasico implements TipoPuntaje{
    @Override
    public int evaluar(Resultado unResultado) {
        return unResultado.calcularClasico();
    }
    /*
    @Override
    public int evaluar(MetodoRespuesta metodo, ArrayList<RespuestaComun> respuestas) {
        return metodo.evaluarClasico(respuestas);
    }

     */

}
