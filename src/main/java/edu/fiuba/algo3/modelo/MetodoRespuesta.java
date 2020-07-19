package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface MetodoRespuesta {
    void agregarRespuestas(ArrayList<Respuesta> respuestas);

    int evaluar(ArrayList<Respuesta> respuestas);
}
