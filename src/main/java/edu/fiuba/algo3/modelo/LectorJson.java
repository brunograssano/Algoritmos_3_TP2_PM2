package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;

import java.io.FileReader;
import java.io.IOException;

import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaIncorrectaMultipleChoice;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectorJson implements LectorPreguntas {
    private ArrayList<Pregunta> preguntasTotales;


    public LectorJson(){
       this.preguntasTotales = new ArrayList<>();
    }

    @Override
    public ArrayList<Pregunta> generarPreguntas() {
        agregarPreguntasMultipleChoice(preguntasTotales);
        agregarPreguntasVoF(preguntasTotales);
        return preguntasTotales;
    }

    private void agregarPreguntasVoF(ArrayList<Pregunta> preguntasTotales){

        JSONParser jsonParser = new JSONParser();

        try(FileReader lectorVoF = new FileReader(System.getProperty("user.dir") + "VoF.json")) {

            ArrayList<Pregunta> preguntasVoF = new ArrayList<>();
            Object obj = jsonParser.parse(lectorVoF);
            JSONArray preguntasVoFJson = (JSONArray) obj;

            preguntasVoFJson.forEach(jsPregunta -> preguntasVoF.add(parseVerdaderoFalso((JSONObject) jsPregunta)));
            preguntasTotales.addAll(preguntasVoF);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private Pregunta parseVerdaderoFalso(JSONObject jsPregunta){

        JSONObject jVoF = (JSONObject) jsPregunta.get("VoF");

        String enunciado = (String) jVoF.get("enunciado");
        boolean penalizable = (boolean) jVoF.get("penalizable");
        boolean enunciadoEsCorrecto = (boolean) jVoF.get("enunciadoEsCorrecto");

        if(penalizable){
             return(FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoEsCorrecto));
        }
        return(FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoEsCorrecto));
    }


    private void agregarPreguntasMultipleChoice(ArrayList<Pregunta> preguntasTotales){
        JSONParser jsonParser = new JSONParser();

        try(FileReader lectorMc = new FileReader(System.getProperty("user.dir") + "VoF.json")) {

            ArrayList<Pregunta> preguntasMc = new ArrayList<>();
            Object obj = jsonParser.parse(lectorMc);
            JSONArray preguntasMcJson = (JSONArray) obj;

            preguntasMcJson.forEach(jsPregunta -> preguntasMc.add(parseMultipleChoice((JSONObject) jsPregunta)));
            preguntasTotales.addAll(preguntasMc);


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private Pregunta parseMultipleChoice(JSONObject jsPregunta) {
        JSONObject jMC = (JSONObject) jsPregunta.get("MC");
        JSONArray jCorrectas = (JSONArray) jMC.get("respuestasCorrectas");
        JSONArray jIncorrectas = (JSONArray) jMC.get("respuestasIncorrectas");
        String enunciado = (String) jMC.get("enunciado");
        String strPuntaje = (String) jMC.get("puntaje");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        jCorrectas.forEach(jsCorrecta -> respuestasCorrectas.add(new RespuestaCorrectaMultipleChoice((String) jsCorrecta )));
        jIncorrectas.forEach(jsIncorrecta -> respuestasIncorrectas.add(new RespuestaIncorrectaMultipleChoice((String) jsIncorrecta )));

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
                pregunta = null; //acá deberia lanzar excepcion

        }
        return pregunta;
    }
}
