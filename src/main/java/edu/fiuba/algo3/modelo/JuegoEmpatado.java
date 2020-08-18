package edu.fiuba.algo3.modelo;

public class JuegoEmpatado implements FinJuego {

    private final static String MENSAJE_EMPATE = "Empataron ambos jugadores";

    @Override
    public String resultadoJuego() {
        return MENSAJE_EMPATE;
    }
}
