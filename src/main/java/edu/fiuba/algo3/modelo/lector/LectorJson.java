package edu.fiuba.algo3.modelo.lector;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import edu.fiuba.algo3.Excepciones.TipoDePuntajeEnArchivoNoValidoException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectorJson implements LectorPreguntas {

    private static final String RUTA_VOF = "VoF.json";
    private static final String RUTA_MC = "MC.json";

    private ArrayList<Pregunta> preguntasTotales;

    public LectorJson() {
        this.preguntasTotales = new ArrayList<>();
    }

    @Override
    public ArrayList<Pregunta> generarPreguntas() {

        Parser parserVerdaderoFalso = new VerdaderoFalsoParser();
        Parser parserMultipleChoice = new MultipleChoiceParser();
        agregarPreguntasDeArchivo(preguntasTotales, RUTA_MC, parserMultipleChoice);
        agregarPreguntasDeArchivo(preguntasTotales, RUTA_VOF, parserVerdaderoFalso);
        return preguntasTotales;
    }

    private void agregarPreguntasDeArchivo(ArrayList<Pregunta> preguntasTotales, String ruta, Parser preguntaParser) {

        JSONParser jsonParser = new JSONParser();

        try (FileReader lector = new FileReader(System.getProperty("user.dir") + ruta)) {

            agregarPreguntas(preguntasTotales, lector, preguntaParser, jsonParser);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (TipoDePuntajeEnArchivoNoValidoException ex) {  //ver que hacemos con las excepciones.
            ex.printStackTrace();
        }
    }


    private void agregarPreguntas(ArrayList<Pregunta> preguntasTotales, FileReader lector, Parser preguntaParser, JSONParser jsonParser) throws IOException, ParseException {

        ArrayList<Pregunta> preguntas = new ArrayList<>();
        Object obj = jsonParser.parse(lector);
        JSONArray preguntasJson = (JSONArray) obj;

        preguntasJson.forEach(jsPregunta -> preguntas.add(preguntaParser.parse((JSONObject) jsPregunta)));
        preguntasTotales.addAll(preguntas);

    }

}
