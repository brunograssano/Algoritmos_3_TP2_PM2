package edu.fiuba.algo3.modelo.modificadores.exclusividad;

import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class UsuarioSeEquivoco implements SituacionesExclusividad {

    private Resultado resultadoDelJugador;

    public UsuarioSeEquivoco(Resultado resultado) {
        resultadoDelJugador = resultado;
    }

    @Override
    public void compararCon(UsuarioRespondioBien situacionDelRival) {
        situacionDelRival.ganoExclusividad();
    }

    @Override
    public void compararCon(UsuarioSeEquivoco situacionDelRival) {
    }

    @Override
    public void compararCon(SituacionesExclusividad situacion) {
        situacion.compararCon(this);
    }
}
