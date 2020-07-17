package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class MetodoVerdaderoFalso implements MetodoRespuesta{

    private List<Respuesta> respuestas;

    @Override
    public void agregarRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public int evaluar(Respuesta respuesta) {
        return respuesta.evaluar();
    }
}
