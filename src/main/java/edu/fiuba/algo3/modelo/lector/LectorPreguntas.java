package edu.fiuba.algo3.modelo.lector;

import edu.fiuba.algo3.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface LectorPreguntas {
    ArrayList<Pregunta> generarPreguntas() throws ArchivoNoEncontradoException;
}
