package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoPenalizable;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultadoPenalizableTest {


    @Test
    public void test01CreoUnResultadoPenalizableRespondoCorrectamenteAlIntentarUsarExclusividadNoCambiaElResultado(){
        Jugador unJugador = new Jugador("Prueba");
        ResultadoPenalizable resultado = new ResultadoPenalizable(unJugador);

        resultado.sumarRespuestaCorrecta();

        resultado.aplicaExclusividad(new AnalizadorExclusividad());

        PuntuacionRepresentable puntos = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntos);

        assertEquals(1,puntos.representar());
    }

}
