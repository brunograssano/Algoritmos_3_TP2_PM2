package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.modificadores.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.preguntas.modificadores.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoParcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioSeEquivocoTest {

    @Test
    public void test01CreoUnUsuarioSeEquivocoLoComparoConUnUsuarioRespondioBienElOtroDuplicaSusPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaIncorrecta();
        ResultadoParcial otroResultado = new ResultadoParcial();
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
        puntosJugadores.add(unResultado.obtenerPuntos().valorNumerico());
        puntosJugadores.add(otroResultado.obtenerPuntos().valorNumerico());

        assertEquals(puntosEsperados,puntosJugadores);
    }

    @Test
    public void test02CreoUnUsuarioSeEquivocoLoComparoConOtroQueSeEquivocoAmbosNoSuman(){

        ResultadoParcial unResultado = new ResultadoParcial();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaIncorrecta();
        ResultadoParcial otroResultado = new ResultadoParcial();
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
        puntosJugadores.add(unResultado.obtenerPuntos().valorNumerico());
        puntosJugadores.add(otroResultado.obtenerPuntos().valorNumerico());

        assertEquals(puntosEsperados,puntosJugadores);
    }
}
