package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.resultados.ResultadoParcial;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioSeEquivocoTest {

    Jugador jugador;

    public void setUp(){
        jugador = new Jugador("Prueba");
    }

    @Test
    public void test01CreoUnUsuarioSeEquivocoLoComparoConUnUsuarioRespondioBienElOtroDuplicaSusPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial(jugador);
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaIncorrecta();
        ResultadoParcial otroResultado = new ResultadoParcial(jugador);
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();

        UsuarioSeEquivoco unaSituacion = new UsuarioSeEquivoco(unResultado);
        UsuarioRespondioBien otraSituacion = new UsuarioRespondioBien(otroResultado);

        unaSituacion.compararCon(otraSituacion);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(0);
        puntosEsperados.add(6);

        ArrayList<Integer> puntosJugadores = new ArrayList<>();

        PuntuacionRepresentable puntosRepresentados1 = new PuntuacionRepresentable();
        PuntuacionRepresentable puntosRepresentados2 = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados1);
        otroResultado.obtenerPuntos().valorNumerico(puntosRepresentados2);

        puntosJugadores.add(puntosRepresentados1.representar());
        puntosJugadores.add(puntosRepresentados2.representar());

        assertEquals(puntosEsperados,puntosJugadores);
    }

    @Test
    public void test02CreoUnUsuarioSeEquivocoLoComparoConOtroQueSeEquivocoAmbosNoSuman(){

        ResultadoParcial unResultado = new ResultadoParcial(jugador);
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaIncorrecta();
        ResultadoParcial otroResultado = new ResultadoParcial(jugador);
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaIncorrecta();


        UsuarioSeEquivoco unaSituacion = new UsuarioSeEquivoco(unResultado);
        UsuarioSeEquivoco otraSituacion = new UsuarioSeEquivoco(otroResultado);

        unaSituacion.compararCon(otraSituacion);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(0);
        puntosEsperados.add(0);

        ArrayList<Integer> puntosJugadores = new ArrayList<>();
        PuntuacionRepresentable puntosRepresentados1 = new PuntuacionRepresentable();
        PuntuacionRepresentable puntosRepresentados2 = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados1);
        otroResultado.obtenerPuntos().valorNumerico(puntosRepresentados2);

        puntosJugadores.add(puntosRepresentados1.representar());
        puntosJugadores.add(puntosRepresentados2.representar());

        assertEquals(puntosEsperados,puntosJugadores);
    }
}
