package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaExcepcion;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.RespuestaGrupo;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicadoresTest {

    @Test
    public void test01ElJugadorAplicaMultiplicadorX2AUnaPreguntaPenalizableYRespondeCorrectamente(){

        String enunciado = "Slack acepta videollamadas";

        boolean enunciadoNoEsCorrecto = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoNoEsCorrecto);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Multiplicador(jugador1,2));

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = new RespuestaCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);
        RespuestaCorrectaVerdaderoFalso respuestaJugador2 = new RespuestaCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(1,jugador2.obtenerPuntos());
    }

    @Test
    public void test02ElJugadorAplicaMultiplicadorX3AUnaPreguntaPenalizableYRespondeCorrectamente(){

        String enunciado = "Slack acepta videollamadas";

        boolean enunciadoNoEsCorrecto = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoNoEsCorrecto);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Multiplicador(jugador2,3));

        RespuestaIncorrectaVerdaderoFalso respuestaJugador1 = new RespuestaIncorrectaVerdaderoFalso(!enunciadoNoEsCorrecto);
        RespuestaCorrectaVerdaderoFalso respuestaJugador2 = new RespuestaCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(-1,jugador1.obtenerPuntos());
        assertEquals(3,jugador2.obtenerPuntos());
    }

    @Test
    public void test03IntentoAgregarUnMultiplicadorEnUnVoFClasicoYTiraExcepcion(){

        String enunciado = "Slack acepta videollamadas";
        boolean enunciadoNoEsCorrecto = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoNoEsCorrecto);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        assertThrows(ModificadorNoAptoParaPreguntaExcepcion.class,
                ()->{jugada.agregarModificador(new Multiplicador(jugador2,3));}
        );
    }

    @Test
    public void test04IntentoAgregarUnMultiplicadorEnUnMultipleChoiceClasicoYTiraExcepcion(){

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, preguntaMultipleChoice);

        assertThrows(ModificadorNoAptoParaPreguntaExcepcion.class,
                ()->{jugada.agregarModificador(new Multiplicador(jugador1,3));}
        );
    }

    @Test
    public void test05IntentoAgregarUnMultiplicadorEnUnMultipleChoiceParcialYTiraExcepcion(){

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, preguntaMultipleChoice);

        assertThrows(ModificadorNoAptoParaPreguntaExcepcion.class,
                ()->{jugada.agregarModificador(new Multiplicador(jugador1,3));}
        );
    }

    @Test
    public void test06IntentoAgregarMultiplicadorEnPreguntaDeGrupoYLanzaExepcion() {

        String enunciado = "Agrupar los segun mamiferos y reptiles";

        RespuestaGrupo respuesta1Grupo1 = new RespuestaGrupo("Gatito");
        RespuestaGrupo respuesta2Grupo1 = new RespuestaGrupo("Conejo");
        RespuestaGrupo respuesta1Grupo2 = new RespuestaGrupo("Lagarto");
        RespuestaGrupo respuesta2Grupo2 = new RespuestaGrupo("Iguana");

        ArrayList<RespuestaGrupo> grupo1Respuesta = new ArrayList<>();
        ArrayList<RespuestaGrupo> grupo2Respuesta = new ArrayList<>();

        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);

        Grupo grupo1 = new Grupo("Mamiferos",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Reptiles",grupo2Respuesta);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");
        Jugada jugada = new Jugada(jugador1, jugador2, preguntaGrupo);

        assertThrows(ModificadorNoAptoParaPreguntaExcepcion.class,
                ()->{jugada.agregarModificador(new Multiplicador(jugador1,3));}
        );
    }

    @Test
    public void test07IntentoAgregarMultiplicadorEnPreguntaDeOrdenYLanzaExepcion() {

        String enunciado = "Ordenar de menor a mayor";

        RespuestaOrden respuestaOrden1 = new RespuestaOrden("1");
        RespuestaOrden respuestaOrden2 = new RespuestaOrden("2");
        RespuestaOrden respuestaOrden3 = new RespuestaOrden("3");
        RespuestaOrden respuestaOrden4 = new RespuestaOrden("4");

        ArrayList<RespuestaOrden> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta preguntaOrden = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");
        Jugada jugada = new Jugada(jugador1, jugador2, preguntaOrden);

        assertThrows(ModificadorNoAptoParaPreguntaExcepcion.class,
                ()->{jugada.agregarModificador(new Multiplicador(jugador1,3));}
        );
    }


}
