package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vistas.textos.TextoContadorPreguntas;
import edu.fiuba.algo3.vistas.textos.TextoTurno;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class EncabezadoPantalla extends HBox {

    public EncabezadoPantalla(String colorLogo){
        TextoTurno textoDelTurno = new TextoTurno(colorLogo);
        TextoContadorPreguntas textoContadorPreguntas = new TextoContadorPreguntas(colorLogo);
        CajaTurno cajaTurno = new CajaTurno(textoDelTurno,textoContadorPreguntas);

        Jugador jugador1 = AlgoHoot.getInstance().obtenerJugador1();
        Jugador jugador2 = AlgoHoot.getInstance().obtenerJugador2();
        CajaJugador cajaJugador1 = new CajaJugador(jugador1);
        CajaJugador cajaJugador2 = new CajaJugador(jugador2);

        super.setAlignment(Pos.TOP_CENTER);
        super.setSpacing(100);
        super.getChildren().add(cajaJugador1);
        super.getChildren().add(cajaTurno);
        super.getChildren().add(cajaJugador2);
    }

}
