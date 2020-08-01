package edu.fiuba.algo3.modelo.preguntas.evaluadores;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public interface Evaluador {
    void evaluar(Resultado unResultado, ArrayList<OpcionSimple> respuestasDelUsuario);
}
