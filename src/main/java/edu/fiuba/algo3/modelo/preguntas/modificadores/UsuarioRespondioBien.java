package edu.fiuba.algo3.modelo.preguntas.modificadores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class UsuarioRespondioBien implements SituacionesExclusividad {
    Resultado resultadoDelJugador;
    public UsuarioRespondioBien(Resultado resultado) {
        resultadoDelJugador = resultado;
    }

    @Override
    public void compararCon(UsuarioRespondioBien situacionDelRival) {
        pierdoPuntuacion();
        situacionDelRival.pierdoPuntuacion();
    }

    @Override
    public void compararCon(UsuarioSeEquivoco situacionDelRival) {
        ganoExclusividad();
    }

    @Override
    public void compararCon(SituacionesExclusividad situacion) {
        situacion.compararCon(this);
    }

    public void pierdoPuntuacion(){
        resultadoDelJugador.sumarRespuestaIncorrecta();
    }

    public void ganoExclusividad() {
        resultadoDelJugador.aplicarMultiplicador(new Multiplicador(new Jugador("TEMPORAL"),2));
        //Ver forma de evitar tener que mandarle el jugador, quizas crear un multiplicar exclusivo de Exclusividad
        // (este puede llegar a ser siempre 2)
    }
}
