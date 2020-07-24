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

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, multipleChoice,tipoClasico);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(1,puntos);
    }


}
