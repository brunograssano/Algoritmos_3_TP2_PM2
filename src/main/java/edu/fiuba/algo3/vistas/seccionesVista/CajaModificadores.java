package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.vistas.botones.BotonExclusividad;
import edu.fiuba.algo3.vistas.botones.BotonMultiplicador;
import edu.fiuba.algo3.vistas.textos.TextoSinExclusividad;
import edu.fiuba.algo3.vistas.textos.TextoSinMultiplicadores;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class CajaModificadores extends HBox {

    private static int ESPACIO_ENTRE_MULTIPLICADORES = 40;

    public CajaModificadores(){
        super(ESPACIO_ENTRE_MULTIPLICADORES);
        super.setAlignment(Pos.CENTER);
        Pregunta pregunta = AlgoHoot.getInstance().pedirPreguntaActual();
        if(pregunta.tipoPuntaje() instanceof PuntajePenalizable){
            ArrayList<MultiplicadorJugador> multiplicadores = AlgoHoot.getInstance().multiplicadoresJugador();
            crearBotonesMultiplicador(multiplicadores);
        }
        else{
            ArrayList<Exclusividad> exclusividades = AlgoHoot.getInstance().exclusividadesJugador();
            crearBotonExclusividad(exclusividades);
        }
    }

    private void crearBotonExclusividad(ArrayList<Exclusividad> exclusividades){
        if(exclusividades.isEmpty()){
            TextoSinExclusividad textoSinExclusividad = new TextoSinExclusividad();
            super.getChildren().add(textoSinExclusividad);
        }
        else{
            super.getChildren().add(new BotonExclusividad(exclusividades));
        }
    }

    private void crearBotonesMultiplicador(ArrayList<MultiplicadorJugador> multiplicadores){
        if(multiplicadores.isEmpty()){
            TextoSinMultiplicadores textoSinMultiplicadores = new TextoSinMultiplicadores();
            super.getChildren().add(textoSinMultiplicadores);
        }
        else{
            for (MultiplicadorJugador multiplicador:multiplicadores) {
                super.getChildren().add(new BotonMultiplicador(multiplicador));
            }
        }
    }
}
