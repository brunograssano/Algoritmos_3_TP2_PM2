package edu.fiuba.algo3.modelo.desordenador;

import java.util.ArrayList;
import java.util.Collections;

public class Desordenador implements CriterioDesorden {

    @Override
    public void desordenar(ArrayList listaADesordenar) {
        Collections.shuffle(listaADesordenar);
    }
}
