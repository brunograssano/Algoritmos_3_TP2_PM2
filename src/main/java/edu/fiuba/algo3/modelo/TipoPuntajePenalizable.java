package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class TipoPuntajePenalizable implements TipoPuntaje{


    @Override
    public int evaluar(Resultado unResultado) {
        return unResultado.calcularPenalizable();
    }
}
