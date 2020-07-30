package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;

public class RespuestaOrden implements Respuesta {

    private String enunciado;

    public  RespuestaOrden(String enunciado){
        this.enunciado = enunciado;
    }

    @Override
    public void evaluar(Resultado unResultado) {
    }

}
