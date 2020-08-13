package edu.fiuba.algo3.modelo.desordenador;

import java.util.ArrayList;
import java.util.Collections;

public class CriterioNormal implements CriterioDeDesorden {

    @Override
    public void desordenar(ArrayList listaADesordenar) {
        Collections.shuffle(listaADesordenar);
    }
}
