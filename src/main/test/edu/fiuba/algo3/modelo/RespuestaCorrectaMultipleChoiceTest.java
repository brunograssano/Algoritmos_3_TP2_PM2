package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaCorrectaMultipleChoiceTest {
    @Test
    public void test01CreoUnaRespuestaCorrectaMCLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        RespuestaCorrectaMultipleChoice respuesta = new RespuestaCorrectaMultipleChoice("Soy correcta");
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(1,puntos.valorNumerico());
    }
}
