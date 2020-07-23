package edu.fiuba.algo3.modelo;

public class TipoPuntajeParcial implements TipoPuntaje {
    @Override
    public int evaluar(Resultado unResultado) {
        return unResultado.calcularParcial();
    }
}
