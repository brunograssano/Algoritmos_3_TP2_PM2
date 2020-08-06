package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class UsuarioSeEquivoco implements SituacionesExclusividad{

    private Resultado resultadoDelJugador;

    public UsuarioSeEquivoco(Resultado resultado) {
        resultadoDelJugador = resultado;
    }

    @Override
    public void compararCon(UsuarioRespondioBien situacionDelRival) {
        situacionDelRival.ganoExclusividad(); //El otro respondio bien, por lo que se aplica el x2
    }

    @Override
    public void compararCon(UsuarioSeEquivoco situacionDelRival) {
        //Se equivocaron ambos, reciben los dos 0 puntos (ya esta en el resultado)
    }

    @Override
    public void compararCon(SituacionesExclusividad situacion) {
        situacion.compararCon(this);
    }
}
