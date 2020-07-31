package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugador;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaJugadorMultipleChoiceTest {

    @Test
    public void test01CreoUnaRespuestaJugadorCorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        RespuestaCorrectaMultipleChoice respuesta = new RespuestaCorrectaMultipleChoice("Soy correcta");
        ArrayList<RespuestaIndividual> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        ResultadoClasico resultado = new ResultadoClasico(1);
        RespuestaJugadorMultipleChoice respuestaMC = new RespuestaJugadorMultipleChoice(respuestas);
        respuestaMC.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(1,puntos.valorNumerico());
    }

    @Test
    public void test02CreoUnaRespuestaJugadorIncorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        RespuestaIncorrectaMultipleChoice respuesta = new RespuestaIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoClasico resultado = new ResultadoClasico(1);

        ArrayList<RespuestaIndividual> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        RespuestaJugadorMultipleChoice respuestaMC = new RespuestaJugadorMultipleChoice(respuestas);
        respuestaMC.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(0,puntos.valorNumerico());
    }

    @Test
    public void test03CreoUnaRespuestaJugadorIncorrectaMCLePasoUnResultadoPenalizablePidoPuntosDebeSerNegativo(){
        RespuestaIncorrectaMultipleChoice respuesta = new RespuestaIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoPenalizable resultado = new ResultadoPenalizable();

        ArrayList<RespuestaIndividual> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        RespuestaJugadorMultipleChoice respuestaMC = new RespuestaJugadorMultipleChoice(respuestas);
        respuestaMC.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(-1,puntos.valorNumerico());
    }

}
