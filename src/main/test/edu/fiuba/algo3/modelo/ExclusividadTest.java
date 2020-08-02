package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Exclusividad;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {

    @Test
    public void test01UnJugadorAplicaExclusividadRespondeCorrectamenteYOtroJugadorRespondeErroneamenteSeMultiplicanPuntosAlCorrecto(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = new RespuestaCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);
        RespuestaIncorrectaVerdaderoFalso respuestaJugador2 = new RespuestaIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }


    @Test
    public void test02SeUsanDosExclusividadesUnSoloJugadorRespondeBienYCuadriplicaPuntos(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = new RespuestaCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);

        jugada.agregarModificador(new Exclusividad(jugador2));
        RespuestaIncorrectaVerdaderoFalso respuestaJugador2 = new RespuestaIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(4,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test03AmbosJugadoresRespondenBienNingunoGanaPuntos(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = new RespuestaCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);
        RespuestaCorrectaVerdaderoFalso respuestaJugador2 = new RespuestaCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test04AmbosJugadoresRespondenMalSiguenConCeroPuntos(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        RespuestaIncorrectaVerdaderoFalso respuestaJugador1 = new RespuestaIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);
        RespuestaIncorrectaVerdaderoFalso respuestaJugador2 = new RespuestaIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

}
