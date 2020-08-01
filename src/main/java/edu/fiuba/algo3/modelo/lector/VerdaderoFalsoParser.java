package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.json.simple.JSONObject;

public class VerdaderoFalsoParser implements Parser {


    @Override
    public Pregunta parse(JSONObject jsPregunta) {
        JSONObject jVoF = (JSONObject) jsPregunta.get("VoF");

        String enunciado = (String) jVoF.get("enunciado");
        boolean penalizable = (boolean) jVoF.get("penalizable");
        boolean enunciadoEsCorrecto = (boolean) jVoF.get("enunciadoEsCorrecto");

        if(penalizable){
            return(FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoEsCorrecto));
        }
        return(FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto));

    }
}
