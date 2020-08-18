package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.turnos.TerminoJuego;
import edu.fiuba.algo3.modelo.turnos.Turno;
import edu.fiuba.algo3.modelo.turnos.TurnoPrimerJugador;
import edu.fiuba.algo3.modelo.turnos.TurnoSegundoJugador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TurnoTest {

    @Test
    public void test01CreoUnTurnoPidoMultiplicadoresDelJugadorYDevuelveDos(){
        Turno unTurno = new TurnoPrimerJugador(new Jugador("NombreJugador"));
        ArrayList<MultiplicadorJugador> multiplicadores = unTurno.multiplicadoresJugador();
        assertEquals(2,multiplicadores.size());
    }

    @Test
    public void test02CreoUnTurnoPidoExclusividadesDelJugadorYDevuelveDos(){
        Turno unTurno = new TurnoPrimerJugador(new Jugador("NombreJugador"));
        ArrayList<Exclusividad> exclusividades = unTurno.exclusividadesJugador();
        assertEquals(2,exclusividades.size());
    }

    @Test
    public void test03SiPreguntoSiTerminoElJuegoAUnTurnoDeUnJugadorDevuelveFalse(){
        Turno unTurno = new TurnoPrimerJugador(new Jugador("NombreJugador"));
        assertFalse(unTurno.terminoElJuego());
    }

    @Test
    public void test04SiPreguntoSiTerminoElJuegoAUnTerminoJuegoDevuelveTrue(){
        Turno unTurno = new TerminoJuego();
        assertTrue(unTurno.terminoElJuego());
    }

    @Test
    public void test05CreoUnTurnoJugadorUsaExclusividadPidoExclusividadesDelJugadorYDevuelveUna(){
        Jugador unJugador = new Jugador("NombreJugador");
        Jugador otroJugador = new Jugador("otroJugador");
        Respuesta unaRespuesta = new RespuestaVerdaderoFalso(new OpcionCorrectaVerdaderoFalso(true));
        Turno unTurno = new TurnoSegundoJugador(unaRespuesta, unJugador);
        Pregunta unaPregunta = new FabricaDePreguntas().CrearVerdaderoFalsoClasico("Un enunciado", true);
        Jugada unaJugada = new Jugada(unJugador, otroJugador,unaPregunta);

        ArrayList<Exclusividad> exclusividades = unJugador.exclusividades();
        unaJugada.agregarModificador(exclusividades.get(0));

        exclusividades = unTurno.exclusividadesJugador();
        assertEquals(1,exclusividades.size());
    }


}
