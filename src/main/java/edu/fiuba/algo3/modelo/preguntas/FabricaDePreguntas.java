package edu.fiuba.algo3.modelo.preguntas;


import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;

import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.OrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;

import java.util.ArrayList;

public class FabricaDePreguntas {

    public static Pregunta CrearMultipleChoiceClasico(String enunciado, ArrayList<OpcionCorrectaMultipleChoice>respuestasCorrectas, ArrayList<OpcionIncorrectaMultipleChoice>respuestasIncorrectas){
        PuntajeClasico clasico = new PuntajeClasico();
        return new MultipleChoice(enunciado,respuestasCorrectas,respuestasIncorrectas,clasico);
    }

    public static Pregunta CrearMultipleChoicePenalizable(String enunciado, ArrayList<OpcionCorrectaMultipleChoice>respuestasCorrectas, ArrayList<OpcionIncorrectaMultipleChoice>respuestasIncorrectas){
        PuntajePenalizable penalizable = new PuntajePenalizable();
        return new MultipleChoice(enunciado,respuestasCorrectas,respuestasIncorrectas,penalizable);
    }

    public static Pregunta CrearMultipleChoiceParcial(String enunciado, ArrayList<OpcionCorrectaMultipleChoice>respuestasCorrectas, ArrayList<OpcionIncorrectaMultipleChoice>respuestasIncorrectas){
        PuntajeParcial parcial = new PuntajeParcial();
        return new MultipleChoice(enunciado,respuestasCorrectas,respuestasIncorrectas,parcial);
    }

    public static Pregunta CrearVerdaderoFalsoClasico(String enunciado, boolean enunciadoEsCorrecto){
        PuntajeClasico clasico = new PuntajeClasico();
        return new VerdaderoFalso(enunciado,enunciadoEsCorrecto,clasico);
    }

    public static Pregunta CrearVerdaderoFalsoPenalizable(String enunciado,boolean enunciadoEsCorrecto){
        PuntajePenalizable penalizable = new PuntajePenalizable();
        return new VerdaderoFalso(enunciado,enunciadoEsCorrecto,penalizable);
    }

    public static Pregunta CrearOrden(String enunciado, ArrayList<OpcionSimple> respuestasOrdenadas) {
        return new OrderedChoice(enunciado,respuestasOrdenadas);
    }
    public static Pregunta CrearGrupo(String enunciado, Grupo grupo1, Grupo grupo2){
        return new GroupChoice(enunciado, grupo1, grupo2);
    }
}
