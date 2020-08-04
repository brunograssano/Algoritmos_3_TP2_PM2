package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionCorrectaVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaOpcionCorrectaVFLePasoUnResultadoClasicoPidoPuntosDebeSer1(){
        OpcionCorrectaVerdaderoFalso respuesta = new OpcionCorrectaVerdaderoFalso(true);
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(1,puntos.valorNumerico());
    }

}
