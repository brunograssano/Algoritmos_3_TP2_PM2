package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01CreoUnJugadorYLePidoSusPuntosDeberiaSerCero(){
        Jugador jugador = new Jugador("Pedro");
        assertEquals(0,jugador.obtenerPuntos());
    }

    @Test
    public void test02UnJugadorEsAsignadoLosPuntosAlResponderCorrectamenteUnVerdaderoFalsoClasico(){
        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Diciembre tiene 31 dias?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasPosibles,verdaderoFalso,tipoClasico);

        Jugador jugador = new Jugador("Pedro");

        Respuesta respuestaJugador = respuestaCorrecta;
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);
        int puntos = unaPregunta.responder(respuestasJugador);

        jugador.sumarPuntos(puntos);
        assertEquals(1,jugador.obtenerPuntos());
    }

    @Test
    public void test03UnJugadorRespondeErroneamenteUnaPreguntaVerdaderoFalsoYNoTienePuntos(){
        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El pasto es verde?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasPosibles,verdaderoFalso,tipoClasico);

        Jugador jugador = new Jugador("Lucas");

        Respuesta respuestaJugador = respuestaIncorrecta;
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);
        int puntos = unaPregunta.responder(respuestasJugador);

        jugador.sumarPuntos(puntos);
        assertEquals(0,jugador.obtenerPuntos());

    }

    @Test
    public void test04UnJugadorResponde5PreguntasVerdaderoFalsoBienYTiene5Puntos(){
        int puntos = 0;
        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El pasto es verde?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<>();

        respuestasPosibles.add(respuestaCorrecta);
        respuestasPosibles.add(respuestaIncorrecta);


        Pregunta unaPregunta1 = new Pregunta(enunciado,respuestasPosibles,verdaderoFalso,tipoClasico);
        Pregunta unaPregunta2 = new Pregunta(enunciado,respuestasPosibles,verdaderoFalso,tipoClasico);
        Pregunta unaPregunta3 = new Pregunta(enunciado,respuestasPosibles,verdaderoFalso,tipoClasico);
        Pregunta unaPregunta4 = new Pregunta(enunciado,respuestasPosibles,verdaderoFalso,tipoClasico);
        Pregunta unaPregunta5 = new Pregunta(enunciado,respuestasPosibles,verdaderoFalso,tipoClasico);

        Jugador jugador = new Jugador("Lucas");
        Respuesta respuestaJugador = respuestaCorrecta;

        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);
        puntos += unaPregunta1.responder(respuestasJugador);
        puntos += unaPregunta2.responder(respuestasJugador);
        puntos += unaPregunta3.responder(respuestasJugador);
        puntos += unaPregunta4.responder(respuestasJugador);
        puntos += unaPregunta5.responder(respuestasJugador);

        jugador.sumarPuntos(puntos);

        assertEquals(5,jugador.obtenerPuntos());

    }


}
