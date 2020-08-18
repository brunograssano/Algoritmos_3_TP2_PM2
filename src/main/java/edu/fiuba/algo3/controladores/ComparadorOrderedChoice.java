package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.botones.OpcionOrderedChoice;

import java.util.Comparator;

public class ComparadorOrderedChoice implements Comparator<OpcionOrderedChoice> {

    @Override
    public int compare(OpcionOrderedChoice opcion1, OpcionOrderedChoice opcion2) {
        int valor = 0;
        if (opcion1.getNumeroOrden() > opcion2.getNumeroOrden())
            valor = 1;
        else if (opcion1.getNumeroOrden() < opcion2.getNumeroOrden())
            valor = -1;
        return valor;
    }

}
