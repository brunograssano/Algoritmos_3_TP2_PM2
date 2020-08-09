package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vistas.seccionesVista.CajaJugador;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import javafx.scene.layout.HBox;

public class EncabezadoPantalla extends HBox {

    public EncabezadoPantalla(){
        AlgoHootPrincipal textoAlgoHootInicio = new AlgoHootPrincipal();
        Jugador jugador1 = AlgoHoot.getInstance().obtenerJugador1();
        Jugador jugador2 = AlgoHoot.getInstance().obtenerJugador2();
        CajaJugador cajaJugador1 = new CajaJugador(jugador1);
        CajaJugador cajaJugador2 = new CajaJugador(jugador2);

        super.getChildren().add(cajaJugador1);
        super.getChildren().add(textoAlgoHootInicio);
        super.getChildren().add(cajaJugador2);
    }

}
