package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class GroupChoiceParser implements Parser {

    @Override
    public Pregunta parse(JSONObject jsPregunta) {

        JSONObject jGroup = (JSONObject) jsPregunta.get("GROUP");
        JSONArray jGrupo1 = (JSONArray) jGroup.get("respuestasGrupo1");
        JSONArray jGrupo2 = (JSONArray) jGroup.get("respuestasGrupo2");
        String enunciado = (String) jGroup.get("enunciado");
        String labelGrupo1 = (String) jGroup.get("labelGrupo1");
        String labelGrupo2 = (String) jGroup.get("labelGrupo2");

        ArrayList<OpcionSimple> respuestasGrupo1 = new ArrayList<>();
        ArrayList<OpcionSimple> respuestasGrupo2 = new ArrayList<>();

        jGrupo1.forEach(jsRespuesta-> respuestasGrupo1.add(new OpcionSimple((String) jsRespuesta )));
        jGrupo2.forEach(jsRespuesta-> respuestasGrupo2.add(new OpcionSimple((String) jsRespuesta )));

        return FabricaDePreguntas.CrearGrupo(enunciado,labelGrupo1, respuestasGrupo1, labelGrupo2, respuestasGrupo2);
    }
}
