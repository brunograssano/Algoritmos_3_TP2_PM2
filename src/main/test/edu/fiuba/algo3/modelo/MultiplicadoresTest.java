package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
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

        jugada.agregarModificador(new MultiplicadorJugador(jugador1,2));

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = new OpcionCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = new OpcionCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

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

        jugada.agregarModificador(new MultiplicadorJugador(jugador2,3));

        OpcionIncorrectaVerdaderoFalso respuestaJugador1 = new OpcionIncorrectaVerdaderoFalso(!enunciadoNoEsCorrecto);
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = new OpcionCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

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

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()-> jugada.agregarModificador(new MultiplicadorJugador(jugador2,3))
        );
    }

    @Test
    public void test04IntentoAgregarUnMultiplicadorEnUnMultipleChoiceClasicoYTiraExcepcion(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, preguntaMultipleChoice);

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()-> jugada.agregarModificador(new MultiplicadorJugador(jugador1,3))
        );
    }

    @Test
    public void test05IntentoAgregarUnMultiplicadorEnUnMultipleChoiceParcialYTiraExcepcion(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, preguntaMultipleChoice);

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()-> jugada.agregarModificador(new MultiplicadorJugador(jugador1,3))
        );
    }

    @Test
    public void test06IntentoAgregarMultiplicadorEnPreguntaDeGrupoYLanzaExepcion() {

        String enunciado = "Agrupar los segun mamiferos y reptiles";

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("Conejo");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("Lagarto");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Iguana");

        ArrayList<OpcionSimple> grupo1OpcionesCorrectas = new ArrayList<>();
        ArrayList<OpcionSimple> grupo2OpcionesCorrectas = new ArrayList<>();

        grupo1OpcionesCorrectas.add(opcion1Grupo1);
        grupo1OpcionesCorrectas.add(opcion2Grupo1);
        grupo2OpcionesCorrectas.add(opcion1Grupo2);
        grupo2OpcionesCorrectas.add(opcion2Grupo2);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado,"Mamiferos", grupo1OpcionesCorrectas,"Reptiles", grupo2OpcionesCorrectas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");
        Jugada jugada = new Jugada(jugador1, jugador2, preguntaGrupo);

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()-> jugada.agregarModificador(new MultiplicadorJugador(jugador1,3))
        );
    }

    @Test
    public void test07IntentoAgregarMultiplicadorEnPreguntaDeOrdenYLanzaExepcion() {

        String enunciado = "Ordenar de menor a mayor";

        OpcionSimple opcionOrden1 = new OpcionSimple("1");
        OpcionSimple opcionOrden2 = new OpcionSimple("2");
        OpcionSimple opcionOrden3 = new OpcionSimple("3");
        OpcionSimple opcionOrden4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(opcionOrden1);
        respuestasOrdenadas.add(opcionOrden2);
        respuestasOrdenadas.add(opcionOrden3);
        respuestasOrdenadas.add(opcionOrden4);

        Pregunta preguntaOrden = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");
        Jugada jugada = new Jugada(jugador1, jugador2, preguntaOrden);

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()-> jugada.agregarModificador(new MultiplicadorJugador(jugador1,3))
        );
    }


}

