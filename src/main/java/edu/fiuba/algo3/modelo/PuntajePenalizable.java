package edu.fiuba.algo3.modelo;

public class PuntajePenalizable implements Puntaje {


    @Override
    public int evaluar(Resultado unResultado) {
        return unResultado.calcularPenalizable();
    }
}
