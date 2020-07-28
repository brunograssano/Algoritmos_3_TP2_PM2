package edu.fiuba.algo3.modelo.preguntas;

import java.util.ArrayList;

public interface Pregunta {

    Resultado evaluar(ArrayList<Respuesta> respuestasUsuario);

}
