package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.desordenador.NoDesordena;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.respuestas.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoHootTest {

    @Test
    public void test01LePediAlAlgoHootUnaJugadaVoFRespondenBienAmbosJugadoresAmbosGananPuntos(){


        AlgoHoot.getInstance().agregarJugadores("Joaquin","Bruno",new NoDesordena());

        OpcionCorrectaVerdaderoFalso unaOpcionCorrecta = new OpcionCorrectaVerdaderoFalso(true);
        RespuestaVerdaderoFalso unaRespuestaCorrecta = new RespuestaVerdaderoFalso(unaOpcionCorrecta);

        AlgoHoot.getInstance().procesarTurno(unaRespuestaCorrecta);
        AlgoHoot.getInstance().procesarTurno(unaRespuestaCorrecta);

        Jugador jugador1 = AlgoHoot.getInstance().obtenerJugador1();
        Jugador jugador2 = AlgoHoot.getInstance().obtenerJugador2();

        assertEquals(1,jugador1.obtenerPuntos());
        assertEquals(1,jugador2.obtenerPuntos());
    }

    @Test
    public void test02LePediAlAlgoHootUnaJugadaVoFRespondeBienUnoUsaExclusividadGanaElDobleDePuntos(){

        AlgoHoot.getInstance().agregarJugadores("Joaquin","Bruno",new NoDesordena());

        AlgoHoot.getInstance().usarModificador(new Exclusividad(AlgoHoot.getInstance().obtenerJugador1()));

        OpcionCorrectaVerdaderoFalso unaOpcionCorrecta = new OpcionCorrectaVerdaderoFalso(true);
        RespuestaVerdaderoFalso unaRespuestaCorrecta = new RespuestaVerdaderoFalso(unaOpcionCorrecta);

        OpcionIncorrectaVerdaderoFalso unaOpcionIncorrecta = new OpcionIncorrectaVerdaderoFalso(false);
        RespuestaVerdaderoFalso unaRespuestaIncorrecta = new RespuestaVerdaderoFalso(unaOpcionIncorrecta);

        AlgoHoot.getInstance().procesarTurno(unaRespuestaCorrecta);
        AlgoHoot.getInstance().procesarTurno(unaRespuestaIncorrecta);

        Jugador jugador1 = AlgoHoot.getInstance().obtenerJugador1();
        Jugador jugador2 = AlgoHoot.getInstance().obtenerJugador2();

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test03LePidoAlAlgoHootUnGanadorEsteEsElJugadorConMasPuntos(){

        
        AlgoHoot.getInstance().agregarJugadores("Joaquin","Bruno",new NoDesordena());

        AlgoHoot.getInstance().usarModificador(new Exclusividad(AlgoHoot.getInstance().obtenerJugador1()));

        OpcionCorrectaVerdaderoFalso unaOpcionCorrecta = new OpcionCorrectaVerdaderoFalso(true);
        RespuestaVerdaderoFalso unaRespuestaCorrecta = new RespuestaVerdaderoFalso(unaOpcionCorrecta);

        OpcionIncorrectaVerdaderoFalso unaOpcionIncorrecta = new OpcionIncorrectaVerdaderoFalso(false);
        RespuestaVerdaderoFalso unaRespuestaIncorrecta = new RespuestaVerdaderoFalso(unaOpcionIncorrecta);

        AlgoHoot.getInstance().procesarTurno(unaRespuestaCorrecta);
        AlgoHoot.getInstance().procesarTurno(unaRespuestaIncorrecta);

        Jugador jugador1 = AlgoHoot.getInstance().obtenerJugador1();
        String estadoFinal = AlgoHoot.getInstance().obtenerJugadorGanador().resultadoJuego();

        String nombreGanador = jugador1.obtenerNombre();
        String puntosGanador = String.valueOf(jugador1.obtenerPuntos());
        String resultadoEsperado = "Gano el jugador "+nombreGanador+" con "+ puntosGanador +" puntos";

        assertEquals(resultadoEsperado,estadoFinal);
    }

}
