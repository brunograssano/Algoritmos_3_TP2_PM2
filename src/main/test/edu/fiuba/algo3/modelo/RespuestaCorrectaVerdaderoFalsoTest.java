package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaCorrectaVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaRespuestaCorrectaVFLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        RespuestaCorrectaVerdaderoFalso respuesta = new RespuestaCorrectaVerdaderoFalso(true);
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(1,puntos.valorNumerico());
    }

}
