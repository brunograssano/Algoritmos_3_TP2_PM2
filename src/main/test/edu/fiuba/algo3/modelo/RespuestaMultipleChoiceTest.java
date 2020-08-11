package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaMultipleChoiceTest {

    Jugador jugador;

    public void setUp(){
        jugador = new Jugador("Prueba");
    }


    @Test
    public void test01CreoUnaRespuestaCorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        OpcionCorrectaMultipleChoice respuesta = new OpcionCorrectaMultipleChoice("Soy correcta");
        ArrayList<OpcionEvaluable> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        ResultadoClasico resultado = new ResultadoClasico(1,jugador);
        RespuestaMultipleChoice respuestaMC = new RespuestaMultipleChoice(respuestas);
        respuestaMC.evaluar(resultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1,puntosRepresentados.representar());
    }

    @Test
    public void test02CreoUnaRespuestaIncorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        OpcionIncorrectaMultipleChoice respuesta = new OpcionIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoClasico resultado = new ResultadoClasico(1,jugador);

        ArrayList<OpcionEvaluable> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        RespuestaMultipleChoice respuestaMC = new RespuestaMultipleChoice(respuestas);
        respuestaMC.evaluar(resultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0,puntosRepresentados.representar());
    }

    @Test
    public void test03CreoUnaRespuestaIncorrectaMCLePasoUnResultadoPenalizablePidoPuntosDebeSerNegativo(){
        OpcionIncorrectaMultipleChoice respuesta = new OpcionIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoPenalizable resultado = new ResultadoPenalizable(jugador);

        ArrayList<OpcionEvaluable> respuestas = new ArrayList<>();
        respuestas.add(respuesta);
        RespuestaMultipleChoice respuestaMC = new RespuestaMultipleChoice(respuestas);
        respuestaMC.evaluar(resultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(-1,puntosRepresentados.representar());
    }

}
