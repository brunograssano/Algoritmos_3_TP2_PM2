package edu.fiuba.algo3.modelo.puntos;

public class PuntuacionRepresentable {

    int total;

    public PuntuacionRepresentable(){
        total = 0;
    }

    public void agregarValor(int valor){
        total += valor;
    }

    public int representar(){
        return total;
    }
}
