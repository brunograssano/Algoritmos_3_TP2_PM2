package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;

import java.util.ArrayList;
import java.util.List;

public class MetodoVerdaderoFalso implements MetodoRespuesta{

    static final int CANT_RESPUESTAS_VERDADERO_FALSO = 2;

    private List<Respuesta> respuestas;

    @Override
    public void agregarRespuestas(ArrayList<Respuesta> respuestas) {
        if(respuestas.size()!=CANT_RESPUESTAS_VERDADERO_FALSO){
            throw new CantidadErroneaDeRespuestasParaPreguntaException();
        }
        this.respuestas = respuestas;
    }

    @Override
    public int evaluar(Respuesta respuesta) {
        return respuesta.evaluar();
    }
}
