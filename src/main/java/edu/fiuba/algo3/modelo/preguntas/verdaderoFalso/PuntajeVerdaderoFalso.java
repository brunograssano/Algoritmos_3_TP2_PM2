package edu.fiuba.algo3.modelo.preguntas.verdaderoFalso;

import edu.fiuba.algo3.modelo.preguntas.Resultado;

public interface PuntajeVerdaderoFalso {

    void evaluar(Resultado unResultado);

    Resultado obtenerResultado(int respuestasCorrectasTotales);
}
