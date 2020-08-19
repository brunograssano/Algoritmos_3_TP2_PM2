package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vistas.EstilosApp;
import edu.fiuba.algo3.vistas.textos.TextoContadorPreguntas;
import edu.fiuba.algo3.vistas.textos.TextoTurno;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class EncabezadoPantalla extends HBox {

    public EncabezadoPantalla(){
        TextoTurno textoDelTurno = new TextoTurno();
        TextoContadorPreguntas textoContadorPreguntas = new TextoContadorPreguntas();
        CajaTurno cajaTurno = new CajaTurno(textoDelTurno,textoContadorPreguntas, EstilosApp.VIOLETA);
        cajaTurno.setAlignment(Pos.CENTER);

        Jugador jugador1 = AlgoHoot.getInstance().obtenerJugador1();
        CajaJugador cajaJugador1 = new CajaJugador(jugador1, EstilosApp.ROJO);
        cajaJugador1.setAlignment(Pos.CENTER);

        Jugador jugador2 = AlgoHoot.getInstance().obtenerJugador2();
        CajaJugador cajaJugador2 = new CajaJugador(jugador2, EstilosApp.AZUL);
        cajaJugador2.setAlignment(Pos.CENTER);

        super.setAlignment(Pos.TOP_CENTER);
        super.setSpacing(100);
        super.getChildren().add(cajaJugador1);
        super.getChildren().add(cajaTurno);
        super.getChildren().add(cajaJugador2);
    }

}
