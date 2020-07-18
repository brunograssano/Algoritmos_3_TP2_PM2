package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01UnJugadorEsAsignadoLosPuntosAlResponderCorrectamenteUnVerdaderoFalsoClasico(){
        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Diciembre tiene 31 dias?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<Respuesta> respuestas = new ArrayList<>();

        respuestas.add(respuestaCorrecta);
        respuestas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);

        Jugador jugador = new Jugador("Pedro");

        int puntos = unaPregunta.responder(respuestaCorrecta);

        jugador.sumarPuntos(puntos);

        assertEquals(1,jugador.obtenerPuntos());

    }

    @Test
    public void test02UnJugadorRespondeErroneamenteUnaPreguntaVerdaderoFalsoYNoTienePuntos(){
        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El pasto es verde?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<Respuesta> respuestas = new ArrayList<>();

        respuestas.add(respuestaCorrecta);
        respuestas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);

        Jugador jugador = new Jugador("Lucas");

        int puntos = unaPregunta.responder(respuestaIncorrecta);

        jugador.sumarPuntos(puntos);

        assertEquals(0,jugador.obtenerPuntos());

    }

    @Test
    public void test03UnJugadorResponde5PreguntasVerdaderoFalsoBienYTiene5Puntos(){
        int puntos = 0;
        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El pasto es verde?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<Respuesta> respuestas = new ArrayList<>();

        respuestas.add(respuestaCorrecta);
        respuestas.add(respuestaIncorrecta);


        Pregunta unaPregunta1 = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);
        Pregunta unaPregunta2 = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);
        Pregunta unaPregunta3 = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);
        Pregunta unaPregunta4 = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);
        Pregunta unaPregunta5 = new Pregunta(enunciado,respuestas,verdaderoFalso,tipoClasico);

        Jugador jugador = new Jugador("Lucas");

        puntos += unaPregunta1.responder(respuestaCorrecta);
        puntos += unaPregunta2.responder(respuestaCorrecta);
        puntos += unaPregunta3.responder(respuestaCorrecta);
        puntos += unaPregunta4.responder(respuestaCorrecta);
        puntos += unaPregunta5.responder(respuestaCorrecta);

        jugador.sumarPuntos(puntos);

        assertEquals(5,jugador.obtenerPuntos());

    }


}
