package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.vistas.botones.BotonMultiplicador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class CajaModificadores extends HBox {

    public CajaModificadores(){
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
            // TODO agregar formato
            Label textoSinExclusividad = new Label("Se quedo sin exclusividad");
            super.getChildren().add(textoSinExclusividad);
        }
        else{
            super.getChildren().add(new BotonExclusividad(exclusividades));
        }
    }

    private void crearBotonesMultiplicador(ArrayList<MultiplicadorJugador> multiplicadores){
        if(multiplicadores.isEmpty()){
            // TODO agregar formato
            Label textoSinExclusividad = new Label("Se quedo sin multiplicadores");
            super.getChildren().add(textoSinExclusividad);
        }
        else{
            for (MultiplicadorJugador multiplicador:multiplicadores) {
                super.getChildren().add(new BotonMultiplicador(multiplicador));
            }
        }
    }
}
