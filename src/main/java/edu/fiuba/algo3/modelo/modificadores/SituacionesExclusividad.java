package edu.fiuba.algo3.modelo.modificadores;

public interface SituacionesExclusividad {
    void compararCon(UsuarioRespondioBien situacionDelRival);

    void compararCon(UsuarioSeEquivoco situacionDelRival);

    void compararCon(SituacionesExclusividad situacion);
}
