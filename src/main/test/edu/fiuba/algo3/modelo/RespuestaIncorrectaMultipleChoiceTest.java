package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaIncorrectaMultipleChoiceTest {
    @Test
    public void test01CreoUnaRespuestaIncorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        RespuestaIncorrectaMultipleChoice respuesta = new RespuestaIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(0,puntos.valorNumerico());
    }

    @Test
    public void test02CreoUnaRespuestaIncorrectaMCLePasoUnResultadoPenalizablePidoPuntosDebeSerNegativo(){
        RespuestaIncorrectaMultipleChoice respuesta = new RespuestaIncorrectaMultipleChoice("Soy incorrecta");
        ResultadoPenalizable resultado = new ResultadoPenalizable();

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(-1,puntos.valorNumerico());
    }
}
