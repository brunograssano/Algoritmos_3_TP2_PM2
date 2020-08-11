package edu.fiuba.algo3.modelo.preguntas.opciones;

import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public interface OpcionEvaluable extends Opcion {
    void evaluar(Resultado unResultado);
}
