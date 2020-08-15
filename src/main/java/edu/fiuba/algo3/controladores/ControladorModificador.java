package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.Multiplicador;
import edu.fiuba.algo3.vistas.botones.BotonMultiplicador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorModificador implements EventHandler<ActionEvent> {

    private Button boton;
    private Modificador multiplicador;

    public ControladorModificador(Button botonDelmodificador, Modificador multiplicador) {
        this.boton = botonDelmodificador;
        this.multiplicador = multiplicador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boton.setDisable(true);
        AlgoHoot.getInstance().usarModificador(multiplicador);
    }
}
