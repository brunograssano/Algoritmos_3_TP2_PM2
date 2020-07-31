package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public interface PuntajeVerdaderoFalso {

    Resultado obtenerResultado(int respuestasCorrectasTotales);

    void puedeUsarModificador(Modificador modificador, ArrayList<Modificador> modificadoresDeLaJugada);
}
