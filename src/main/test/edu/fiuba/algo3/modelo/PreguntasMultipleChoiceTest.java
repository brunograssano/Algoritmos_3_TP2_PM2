package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntasMultipleChoiceTest {

    @Test
    public void test01CreoUnaPreguntaMultipleChoiceYSeEligeLaCorrecta(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Tiramisú");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Gelatina");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Vigilante");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Cordero a la Wellington");

        ArrayList<RespuestaComun> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuestaCorrecta1);
        respuestasPosibles.add(respuestaCorrecta2);
        respuestasPosibles.add(respuestaCorrecta3);
        respuestasPosibles.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasPosibles,multipleChoice,tipoClasico);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(1,puntos);

    }


}
