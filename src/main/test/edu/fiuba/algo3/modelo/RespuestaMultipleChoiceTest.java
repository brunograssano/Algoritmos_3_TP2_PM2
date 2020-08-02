package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaMultipleChoiceTest {

    @Test
    public void test01CreoUnaRespuestaCorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        OpcionCorrectaMultipleChoice respuesta = new OpcionCorrectaMultipleChoice("Soy correcta");
        ArrayList<OpcionEvaluable> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        ResultadoClasico resultado = new ResultadoClasico(1);
        RespuestaMultipleChoice respuestaMC = new RespuestaMultipleChoice(respuestas);
        respuestaMC.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(1,puntos.valorNumerico());
    }

    @Test
    public void test02CreoUnaRespuestaIncorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        OpcionIncorrectaMultipleChoice respuesta = new OpcionIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoClasico resultado = new ResultadoClasico(1);

        ArrayList<OpcionEvaluable> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        RespuestaMultipleChoice respuestaMC = new RespuestaMultipleChoice(respuestas);
        respuestaMC.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(0,puntos.valorNumerico());
    }

    @Test
    public void test03CreoUnaRespuestaIncorrectaMCLePasoUnResultadoPenalizablePidoPuntosDebeSerNegativo(){
        OpcionIncorrectaMultipleChoice respuesta = new OpcionIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoPenalizable resultado = new ResultadoPenalizable();

        ArrayList<OpcionEvaluable> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        RespuestaMultipleChoice respuestaMC = new RespuestaMultipleChoice(respuestas);
        respuestaMC.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(-1,puntos.valorNumerico());
    }

}
