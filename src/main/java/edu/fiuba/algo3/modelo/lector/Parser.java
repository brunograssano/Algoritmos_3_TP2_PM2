package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.json.simple.JSONObject;

public interface Parser {

    public Pregunta parse(JSONObject jsPregunta);
}
