package edu.fiuba.algo3.modelo.modificadores;


import java.util.Stack;

public class AnalizadorExclusividad {
    Stack<SituacionesExclusividad> situacionesExclusividad;

    public AnalizadorExclusividad(){
        situacionesExclusividad = new Stack<>();
    }

    /*
    Pre: Necesita tener 2 situaciones de exclusividad para poder hacer un analisis correctamente.
    Post: Asiganara las nuevas puntuaciones a los usuarios que corresponda.
     */
    public void analizarSituacion() {
        SituacionesExclusividad situacion1 = situacionesExclusividad.pop();
        SituacionesExclusividad situacion2 = situacionesExclusividad.pop();

        situacion1.compararCon(situacion2);

    }

    public void agregarSituacion(SituacionesExclusividad situacion){
        situacionesExclusividad.push(situacion);
    }
}
