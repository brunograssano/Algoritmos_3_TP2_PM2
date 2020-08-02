package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionIncorrectaVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaOpcionIncorrectaVFLePasoUnResultadoClasicoPidoPuntosDebeSer0(){
        OpcionIncorrectaVerdaderoFalso respuesta = new OpcionIncorrectaVerdaderoFalso(false);
        ResultadoClasico resultado = new ResultadoClasico(1);

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(0,puntos.valorNumerico());
    }

    @Test
    public void test02CreoUnaOpcionIncorrectaVFLePasoUnResultadoPenalizablePidoPuntosDebeSerMenosUno(){
        OpcionIncorrectaVerdaderoFalso respuesta = new OpcionIncorrectaVerdaderoFalso(false);
        ResultadoPenalizable resultado = new ResultadoPenalizable();

        respuesta.evaluar(resultado);

        Punto puntos = resultado.obtenerPuntos();

        assertEquals(-1,puntos.valorNumerico());
    }
}
