package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vistas.textos.TextoContadorPreguntas;
import edu.fiuba.algo3.vistas.textos.TextoTurno;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class EncabezadoPantalla extends HBox {

    private static String GRIS = "D8DDEF";
    private static String VIOLETA = "9370DB";
    private static String VERDE= "33FF96";
    private static String AZUL = "0083E0";
    private static String AMARILLO = "FBD87F";
    private static String ROJO = "EF2D56";

    public EncabezadoPantalla(){
        TextoTurno textoDelTurno = new TextoTurno();
        TextoContadorPreguntas textoContadorPreguntas = new TextoContadorPreguntas();
        CajaTurno cajaTurno = new CajaTurno(textoDelTurno,textoContadorPreguntas, GRIS);
        cajaTurno.setAlignment(Pos.CENTER);

        Jugador jugador1 = AlgoHoot.getInstance().obtenerJugador1();
        CajaJugador cajaJugador1 = new CajaJugador(jugador1, GRIS);
        cajaJugador1.setAlignment(Pos.CENTER);

        Jugador jugador2 = AlgoHoot.getInstance().obtenerJugador2();
        CajaJugador cajaJugador2 = new CajaJugador(jugador2, GRIS);
        cajaJugador2.setAlignment(Pos.CENTER);

        super.setAlignment(Pos.TOP_CENTER);
        super.setSpacing(100);
        super.getChildren().add(cajaJugador1);
        super.getChildren().add(cajaTurno);
        super.getChildren().add(cajaJugador2);
    }

}
