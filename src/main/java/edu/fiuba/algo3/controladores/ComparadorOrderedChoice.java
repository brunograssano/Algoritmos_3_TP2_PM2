package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.seccionesVista.spinners.SpinnerOrderedChoice;

import java.util.Comparator;

public class ComparadorOrderedChoice implements Comparator<SpinnerOrderedChoice> {

    @Override
    public int compare(SpinnerOrderedChoice opcion1, SpinnerOrderedChoice opcion2) {
        int valor = 0;
        if (opcion1.getNumeroOrden() > opcion2.getNumeroOrden())
            valor = 1;
        else if (opcion1.getNumeroOrden() < opcion2.getNumeroOrden())
            valor = -1;
        return valor;
    }

}
