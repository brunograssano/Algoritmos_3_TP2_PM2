package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Desordenador {

    private static CriterioDeDesorden criterio = new CriterioNormal();

    public static void desordenar(ArrayList listaADesordenar){
        criterio.desordenar(listaADesordenar);
    }

    public static void setCriterio(CriterioDeDesorden unCriterio){
        criterio = unCriterio;
    }
}
