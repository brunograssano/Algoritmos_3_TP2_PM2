package edu.fiuba.algo3.vistas.seccionesVista;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class CajaBonusJugador extends HBox {

    private static int ESPACIADO_BONUS = 5;

    public CajaBonusJugador(Jugador jugador) {
        super(ESPACIADO_BONUS);
        super.setAlignment(Pos.CENTER);
        ArrayList<MultiplicadorJugador> multiplicadores = jugador.multiplicadores();
        crearCirculosMultiplicador(multiplicadores);
        ArrayList<Exclusividad> exclusividades = jugador.exclusividades();
        crearCirculosExclusividad(exclusividades);
    }

    private void crearCirculosExclusividad(ArrayList<Exclusividad> exclusividades){
        for (Exclusividad exclusividad:exclusividades) {
            super.getChildren().add(new CirculoBonus(exclusividad));
        }
    }

    private void crearCirculosMultiplicador(ArrayList<MultiplicadorJugador> multiplicadores){
        for (MultiplicadorJugador multiplicador:multiplicadores) {
            super.getChildren().add(new CirculoBonus(multiplicador));
        }

    }
}
