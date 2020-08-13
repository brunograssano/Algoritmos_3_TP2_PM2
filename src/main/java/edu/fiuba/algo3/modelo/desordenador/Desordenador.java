package edu.fiuba.algo3.modelo.desordenador;

import java.util.ArrayList;

public class Desordenador {

    private CriterioDeDesorden criterio;

    public Desordenador (CriterioDeDesorden unCriterio){
        criterio = unCriterio;
    }

    public void desordenar(ArrayList listaADesordenar){
        criterio.desordenar(listaADesordenar);
    }

}
