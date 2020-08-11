package edu.fiuba.algo3.modelo.preguntas.groupChoice;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;

import java.util.ArrayList;

public class Grupo {

    private String nombreGrupo;
    ArrayList<OpcionSimple> respuestasDelGrupo;

    public Grupo(String nombreGrupo, ArrayList<OpcionSimple> respuestasDelGrupo){
        this.respuestasDelGrupo = respuestasDelGrupo;
        this.nombreGrupo = nombreGrupo;
    }

    public boolean esIgual(Grupo otroGrupo){
        return (otroGrupo.contieneMismasRespuestas(respuestasDelGrupo));
    }
    public int cantidadElementos(){
        return respuestasDelGrupo.size();
    }

    private boolean contieneMismasRespuestas(ArrayList<OpcionSimple> unasRespuestas){
        return (respuestasDelGrupo.containsAll(unasRespuestas) && unasRespuestas.containsAll(respuestasDelGrupo));
    }

    public ArrayList<OpcionSimple> respuestas(){
        return respuestasDelGrupo;
    }
}
