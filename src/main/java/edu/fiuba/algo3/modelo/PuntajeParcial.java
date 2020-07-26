package edu.fiuba.algo3.modelo;

public class PuntajeParcial implements Puntaje {
    @Override
    public int evaluar(Resultado unResultado) {
        return unResultado.calcularParcial();
    }
}
