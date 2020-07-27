package edu.fiuba.algo3.modelo.preguntas.puntajes;

import edu.fiuba.algo3.modelo.preguntas.multipleChoice.PuntajeChoice;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoParcial;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.PuntajeVerdaderoFalso;

public class PuntajeClasico implements PuntajeChoice, PuntajeVerdaderoFalso {
    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.calcular();
    }

    @Override
    public Resultado obtenerResultado(int respuestasCorrectasTotales) {
        return new ResultadoClasico(respuestasCorrectasTotales);
    }

}
