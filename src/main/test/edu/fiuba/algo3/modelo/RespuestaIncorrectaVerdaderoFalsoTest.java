package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaIncorrectaVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaRespuestaIncorrectaVFLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        RespuestaIncorrectaVerdaderoFalso respuesta = new RespuestaIncorrectaVerdaderoFalso(false);
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(0,puntos.valorNumerico());
    }

    @Test
    public void test02CreoUnaRespuestaIncorrectaVFLePasoUnResultadoPenalizablePidoPuntosDebeSerMenosUno(){
        RespuestaIncorrectaVerdaderoFalso respuesta = new RespuestaIncorrectaVerdaderoFalso(false);
        ResultadoPenalizable resultado = new ResultadoPenalizable();

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(-1,puntos.valorNumerico());
    }
}
