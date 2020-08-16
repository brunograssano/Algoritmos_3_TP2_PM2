package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.resultados.ResultadoPenalizable;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaVerdaderoFalsoTest {

    Jugador jugador;

    public void setUp(){
        jugador = new Jugador("Prueba");
    }

    @Test
    public void test01CreoUnaRespuestaVFCorrectaLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        OpcionCorrectaVerdaderoFalso respuesta = new OpcionCorrectaVerdaderoFalso(true);
        RespuestaVerdaderoFalso respuestaVoF = new RespuestaVerdaderoFalso(respuesta);
        ResultadoClasico resultado = new ResultadoClasico(1,jugador);

        respuestaVoF.evaluar(resultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1, puntosRepresentados.representar());
    }

    @Test
    public void test02CreoUnaRespuestaVFIncorrectaLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        OpcionIncorrectaVerdaderoFalso respuesta = new OpcionIncorrectaVerdaderoFalso(true);
        RespuestaVerdaderoFalso respuestaVoF = new RespuestaVerdaderoFalso(respuesta);
        ResultadoClasico resultado = new ResultadoClasico(1,jugador);

        respuestaVoF.evaluar(resultado);
        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0, puntosRepresentados.representar());
    }

    @Test
    public void test03CreoUnaRespuestaVFIncorrectaLePasoUnResultadoPenalizablePidoPuntosDebeSerNegativo(){
        OpcionIncorrectaVerdaderoFalso respuesta = new OpcionIncorrectaVerdaderoFalso(false);
        RespuestaVerdaderoFalso respuestaVoF = new RespuestaVerdaderoFalso(respuesta);
        ResultadoPenalizable resultado = new ResultadoPenalizable(jugador);

        respuestaVoF.evaluar(resultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(-1, puntosRepresentados.representar());
    }
}
