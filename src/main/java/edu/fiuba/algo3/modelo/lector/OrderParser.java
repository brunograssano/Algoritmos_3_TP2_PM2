package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class OrderParser implements Parser {


    @Override
    public Pregunta parse(JSONObject jsPregunta) {

        JSONObject jOrder = (JSONObject) jsPregunta.get("ORDER");
        JSONArray jrespuestasEnOrden = (JSONArray) jOrder.get("respuestasEnOrden");
        String enunciado = (String) jOrder.get("enunciado");

        ArrayList<OpcionSimple> respuestasOrdenadas = new ArrayList<>();

        jrespuestasEnOrden.forEach(jsRespuesta-> respuestasOrdenadas.add(new OpcionSimple((String) jsRespuesta )));

        return FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);
    }
}
