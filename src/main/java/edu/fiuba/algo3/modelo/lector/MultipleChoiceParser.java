package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.Excepciones.TipoDePuntajeEnArchivoNoValidoException;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class MultipleChoiceParser implements Parser{
    @Override
    public Pregunta parse(JSONObject jsPregunta) {
        JSONObject jMC = (JSONObject) jsPregunta.get("MC");
        JSONArray jCorrectas = (JSONArray) jMC.get("respuestasCorrectas");
        JSONArray jIncorrectas = (JSONArray) jMC.get("respuestasIncorrectas");
        String enunciado = (String) jMC.get("enunciado");
        String strPuntaje = (String) jMC.get("puntaje");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        jCorrectas.forEach(jsCorrecta -> respuestasCorrectas.add(new OpcionCorrectaMultipleChoice((String) jsCorrecta )));
        jIncorrectas.forEach(jsIncorrecta -> respuestasIncorrectas.add(new OpcionIncorrectaMultipleChoice((String) jsIncorrecta )));

        Pregunta pregunta;

        switch(strPuntaje){
            case "clasico":
                pregunta = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado, respuestasCorrectas,respuestasIncorrectas);
                break;

            case "penalizable":
                pregunta = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado, respuestasCorrectas,respuestasIncorrectas);
                break;

            case"parcial":
                pregunta = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado, respuestasCorrectas,respuestasIncorrectas);
                break;

            default:
               throw new TipoDePuntajeEnArchivoNoValidoException();

        }
        return pregunta;
    }
}
