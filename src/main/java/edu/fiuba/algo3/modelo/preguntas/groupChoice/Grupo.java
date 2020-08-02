package edu.fiuba.algo3.modelo.preguntas.groupChoice;

import edu.fiuba.algo3.modelo.preguntas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class Grupo {

    private String nombreGrupo;
    ArrayList<RespuestaGrupo> respuestasDelGrupo;

    public Grupo(String nombreGrupo, ArrayList<RespuestaGrupo> respuestasDelGrupo){
        this.respuestasDelGrupo = respuestasDelGrupo;
        this.nombreGrupo = nombreGrupo;
    }

    public void contiene(Resultado unResultado, ArrayList<RespuestaGrupal> respuestasDelUsuario) {
        if( respuestasDelUsuario.containsAll(respuestasDelGrupo) && respuestasDelGrupo.size() == respuestasDelUsuario.size() ){
            unResultado.sumarRespuestaCorrecta();
        }else{
            unResultado.sumarRespuestaIncorrecta();
        }
    }
}
