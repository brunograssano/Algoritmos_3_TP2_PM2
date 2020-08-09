package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.Orden;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaGroupChoiceTest {

    @Test
    public void test01CreoUnaRespuestaGroupChoiceYLaComparoConUnaIgual() {
        OpcionSimple opcion1Grupo1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("Conejo");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("Lagarto");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Iguana");

        ArrayList<OpcionSimple> grupo1Respuesta = new ArrayList<>();
        ArrayList<OpcionSimple> grupo2Respuesta = new ArrayList<>();

        grupo1Respuesta.add(opcion1Grupo1);
        grupo1Respuesta.add(opcion2Grupo1);
        grupo2Respuesta.add(opcion1Grupo2);
        grupo2Respuesta.add(opcion2Grupo2);

        RespuestaGroupChoice unaRespuesta = new RespuestaGroupChoice("Mamiferos", grupo1Respuesta, "Reptiles", grupo2Respuesta);
        RespuestaGroupChoice otraRespuesta = new RespuestaGroupChoice("Mamiferos", grupo1Respuesta, "Reptiles", grupo2Respuesta);

        assertTrue(unaRespuesta.esIgual(otraRespuesta));
    }

    @Test
    public void test02CreoUnaRespuestaGroupChoiceYLaComparoConUnaDistinta(){

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("Conejo");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("Lagarto");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Iguana");

        ArrayList<OpcionSimple> opcionesGrupo1Respuesta1 = new ArrayList<>();
        ArrayList<OpcionSimple> opcionesGrupo2Respuesta1 = new ArrayList<>();

        opcionesGrupo1Respuesta1.add(opcion1Grupo1);
        opcionesGrupo1Respuesta1.add(opcion2Grupo1);
        opcionesGrupo2Respuesta1.add(opcion1Grupo2);
        opcionesGrupo2Respuesta1.add(opcion2Grupo2);

        ArrayList<OpcionSimple> opcionesGrupo1Respuesta2 = new ArrayList<>();
        ArrayList<OpcionSimple> opcionesGrupo2Respuesta2 = new ArrayList<>();

        opcionesGrupo1Respuesta2.add(opcion1Grupo2);
        opcionesGrupo1Respuesta2.add(opcion2Grupo2);
        opcionesGrupo2Respuesta2.add(opcion1Grupo1);
        opcionesGrupo2Respuesta2.add(opcion2Grupo1);

        RespuestaGroupChoice unaRespuesta = new RespuestaGroupChoice("Mamiferos",opcionesGrupo1Respuesta1, "Reptiles", opcionesGrupo2Respuesta1);
        RespuestaGroupChoice otraRespuesta = new RespuestaGroupChoice("Mamiferos",opcionesGrupo1Respuesta2, "Reptiles", opcionesGrupo2Respuesta2);

        assertFalse(unaRespuesta.esIgual(otraRespuesta));
    }

    @Test
    public void test03CreoUnaRespuestaGroupChoiceYLaComparoConUnaRespuestaGroupChoiceOrderedChoice(){

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("Conejo");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("Lagarto");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Iguana");

        ArrayList<OpcionSimple> opcionesGrupo1Respuesta1 = new ArrayList<>();
        ArrayList<OpcionSimple> opcionesGrupo2Respuesta1 = new ArrayList<>();

        opcionesGrupo1Respuesta1.add(opcion1Grupo1);
        opcionesGrupo1Respuesta1.add(opcion2Grupo1);
        opcionesGrupo2Respuesta1.add(opcion1Grupo2);
        opcionesGrupo2Respuesta1.add(opcion2Grupo2);

        RespuestaGroupChoice unaRespuesta = new RespuestaGroupChoice("Mamiferos", opcionesGrupo1Respuesta1,"Reptiles", opcionesGrupo2Respuesta1);
        RespuestaOrderedChoice otraRespuesta = new RespuestaOrderedChoice(opcionesGrupo1Respuesta1);

        assertFalse(unaRespuesta.esIgual(otraRespuesta));
    }

    @Test
    public void test04AlIntentarCrearUnaRespuestaGroupChoiceConMasDe6OpcionesSeDebeLanzarExcepcion(){

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("Conejo");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("Lagarto");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Iguana");



        ArrayList<OpcionSimple> opcionesGrupo1Respuesta1 = new ArrayList<>();
        opcionesGrupo1Respuesta1.add(opcion1Grupo1);
        opcionesGrupo1Respuesta1.add(opcion2Grupo1);

        ArrayList<OpcionSimple> opcionesGrupo2Respuesta1 = new ArrayList<>();
        opcionesGrupo2Respuesta1.add(opcion1Grupo2);
        opcionesGrupo2Respuesta1.add(opcion1Grupo2);
        opcionesGrupo2Respuesta1.add(opcion1Grupo2);
        opcionesGrupo2Respuesta1.add(opcion1Grupo2);
        opcionesGrupo2Respuesta1.add(opcion2Grupo2);


        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{ RespuestaGroupChoice unaRespuesta = new RespuestaGroupChoice("Mamiferos",opcionesGrupo1Respuesta1,"Reptiles", opcionesGrupo2Respuesta1);}
        );
    }

    @Test
    public void test05AlIntentarCrearUnaRespuestaGroupChoiceConMenosDe2OpcionesSeDebeLanzarExcepcion(){

        OpcionSimple unicaOpcion = new OpcionSimple("Gatito");


        ArrayList<OpcionSimple> opcionesGrupo1Respuesta1 = new ArrayList<>();
        opcionesGrupo1Respuesta1.add(unicaOpcion);

        ArrayList<OpcionSimple> opcionesGrupo2Respuesta1 = new ArrayList<>();

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{ RespuestaGroupChoice unaRespuesta = new RespuestaGroupChoice("Mamiferos",opcionesGrupo1Respuesta1,"Reptiles", opcionesGrupo2Respuesta1);}
        );
    }
}
