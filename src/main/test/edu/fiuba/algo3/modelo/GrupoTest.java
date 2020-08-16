package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupoTest {

    @Test
    public void test01CreoUnGrupoCon3ElementosLePidoLaCantidadDeElementosDebenSer3(){
        String nombreGrupo = "Lenguajes de programacion";
        OpcionSimple elemento1 = new OpcionSimple("Java");
        OpcionSimple elemento2 = new OpcionSimple("C#");
        OpcionSimple elemento3 = new OpcionSimple("C++");

        ArrayList<OpcionSimple> elementos = new ArrayList<>();
        elementos.add(elemento1);
        elementos.add(elemento2);
        elementos.add(elemento3);

        Grupo grupo = new Grupo(nombreGrupo, elementos);

        assertEquals(3, grupo.cantidadElementos());
    }

    @Test
    public void test02CreoUnGrupoSinElementosLePidoLaCantidadDeElementosDebenSer0(){
        String nombreGrupo = "Lenguajes de programacion";

        ArrayList<OpcionSimple> elementos = new ArrayList<>();

        Grupo grupo = new Grupo(nombreGrupo, elementos);

        assertEquals(0, grupo.cantidadElementos());
    }

    @Test
    public void test03CreoUnGrupoYLoComparoConOtroIgual(){
        String nombreGrupo = "Lenguajes de programacion";
        OpcionSimple elemento1 = new OpcionSimple("Java");
        OpcionSimple elemento2 = new OpcionSimple("C#");
        OpcionSimple elemento3 = new OpcionSimple("C++");

        ArrayList<OpcionSimple> elementosGrupo1 = new ArrayList<>();
        elementosGrupo1.add(elemento1);
        elementosGrupo1.add(elemento2);
        elementosGrupo1.add(elemento3);

        ArrayList<OpcionSimple> elementosGrupo2 = new ArrayList<>();
        elementosGrupo2.add(elemento1);
        elementosGrupo2.add(elemento2);
        elementosGrupo2.add(elemento3);

        Grupo grupo1 = new Grupo(nombreGrupo, elementosGrupo1);
        Grupo grupo2 = new Grupo(nombreGrupo, elementosGrupo2);

        assertEquals(true,grupo1.esIgual(grupo2));
    }

    @Test
    public void test04CreoUnGrupoYLoComparoConOtroDeElementosDistintos(){
        String nombreGrupo = "Lenguajes de programacion";

        OpcionSimple elemento1 = new OpcionSimple("Java");
        OpcionSimple elemento2 = new OpcionSimple("C#");
        OpcionSimple elemento3 = new OpcionSimple("C++");
        OpcionSimple elemento4 = new OpcionSimple("C");

        ArrayList<OpcionSimple> elementosGrupo1 = new ArrayList<>();
        elementosGrupo1.add(elemento1);
        elementosGrupo1.add(elemento2);
        elementosGrupo1.add(elemento3);

        ArrayList<OpcionSimple> elementosGrupo2 = new ArrayList<>();
        elementosGrupo2.add(elemento1);
        elementosGrupo2.add(elemento2);
        elementosGrupo2.add(elemento3);
        elementosGrupo2.add(elemento4);

        Grupo grupo1 = new Grupo(nombreGrupo, elementosGrupo1);
        Grupo grupo2 = new Grupo(nombreGrupo, elementosGrupo2);

        assertEquals(false,grupo1.esIgual(grupo2));
    }
}
