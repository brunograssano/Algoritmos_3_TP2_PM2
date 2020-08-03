package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.modificadores.MultiplicadorExclusividad;
import edu.fiuba.algo3.modelo.preguntas.modificadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNulo;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import org.junit.jupiter.api.Test;

import javax.management.loading.MLet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicadorJugadorTest {

    @Test
    public void test01AlIntentarAplicarUnMultiplicadorAUnPuntajeClasicoSeDebeLanzarExcepcion(){

        Jugador unJugador = new Jugador("Juan");

        int unFactor = 2;

        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        ArrayList<Modificador> modificadoresDeLaJugada = new ArrayList();

        modificadoresDeLaJugada.add(unMultiplicador);

        PuntajeClasico unPuntaje = new PuntajeClasico();

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()->{
                    unMultiplicador.usarEnPuntaje(unPuntaje,modificadoresDeLaJugada);}
        );
    }

    @Test
    public void test02AlIntentarAplicarUnMultiplicadorAUnPuntajeParcialSeDebeLanzarExcepcion(){

        Jugador unJugador = new Jugador("Juan");

        int unFactor = 2;

        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        ArrayList<Modificador> modificadoresDeLaJugada = new ArrayList();

        PuntajeParcial unPuntaje = new PuntajeParcial();

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()->{
                    unMultiplicador.usarEnPuntaje(unPuntaje,modificadoresDeLaJugada);}
        );
    }

    @Test
    public void test03CreoUnMultiplicadorLoAplicoEnUnPuntajePenalizableYLosPuntosSeDuplican(){

        Jugador unJugador = new Jugador("Juan");

        int unFactor = 2;

        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        ArrayList<Modificador> modificadoresDeLaJugada = new ArrayList();

        PuntajePenalizable unPuntaje = new PuntajePenalizable();

        Resultado unResultado = unPuntaje.obtenerResultado(2);
        Resultado otroResultado = unPuntaje.obtenerResultado(2);

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        unMultiplicador.aplicar(unJugador,unResultado,otroResultado);

        assertEquals(4,unResultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test04CreoUnMultiplicadorLoAplicoEnUnPuntajePenalizableYLosPuntosSeTriplican(){

        Jugador unJugador = new Jugador("Juan");

        int unFactor = 3;

        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        ArrayList<Modificador> modificadoresDeLaJugada = new ArrayList();

        PuntajePenalizable unPuntaje = new PuntajePenalizable();

        Resultado unResultado = unPuntaje.obtenerResultado(2);
        Resultado otroResultado = unPuntaje.obtenerResultado(2);

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        unMultiplicador.aplicar(unJugador,unResultado,otroResultado);

        assertEquals(6,unResultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test05CreoUnMultiplicadorLoAplicoEnUnaPuntuacionYLosPuntosSeTriplican(){

        Jugador unJugador = new Jugador("Juan");

        int unFactor = 3;

        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<10;i++) {
            puntos.agregarPunto(new PuntoPositivo());
        }

        unMultiplicador.usarEnPuntos(puntos);

        assertEquals(30,puntos.valorNumerico());
    }

    @Test
    public void test06CreoUnMultiplicadorLoAplicoEnUnaPuntuacionYLosPuntosSeDuplican(){

        Jugador unJugador = new Jugador("Juan");

        int unFactor = 2;

        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<10;i++) {
            puntos.agregarPunto(new PuntoNegativo());
        }

        unMultiplicador.usarEnPuntos(puntos);

        assertEquals(-20,puntos.valorNumerico());
    }

}
