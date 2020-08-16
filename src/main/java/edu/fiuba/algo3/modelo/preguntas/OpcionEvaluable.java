package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.resultados.Resultado;

public interface OpcionEvaluable{
    void evaluar(Resultado unResultado);
    String obtenerTexto();
}
