package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.respuestas.RespuestaOrderedChoice;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.seccionesVista.spinners.SpinnerOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorEnviarOrderedChoice extends ControladorPreguntasJuego implements EventHandler<ActionEvent> {

    private ArrayList<SpinnerOrderedChoice> opcionesVista;
    private HashMap<String,OpcionSimple> opcionesOrdenHash;
    private ArrayList<OpcionSimple> opcionesJugador;

    public ControladorEnviarOrderedChoice(Stage escenario, ContenedorPrincipal contenedorPrincipal){
        this.contenedorPrincipal = contenedorPrincipal;
        stage = escenario;
        opcionesJugador = new ArrayList<>();
        opcionesOrdenHash = new HashMap<>();
    }

    public void agregarOpcionesSeleccionadas(ArrayList<SpinnerOrderedChoice> opciones){
        opcionesVista = opciones;
    }

    public void agregarOpcionesCorrectas(ArrayList<OpcionSimple> opcionesCorrectas){
        for (OpcionSimple opcion:opcionesCorrectas) {
            opcionesOrdenHash.put(opcion.obtenerTexto(),opcion);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(seRepitenOpcionesSeleccionadas()) {
            Alert repiteoOrden = new Alert(Alert.AlertType.ERROR);
            repiteoOrden.setHeaderText("Se repitieron posiciones");
            repiteoOrden.setContentText("Se deben elegir posiciones de orden distintas para cada opcion!");
            repiteoOrden.show();
        }
        else{
            convertirOpcionesSimples();
            RespuestaOrderedChoice respuestaDeUnJugador = new RespuestaOrderedChoice(opcionesJugador);
            definirSiguienteVista(respuestaDeUnJugador);
        }
    }

    private boolean seRepitenOpcionesSeleccionadas() {
        int contadorPos1 = 0, contadorPos2 = 0;
        int contadorPos3 = 0, contadorPos4 = 0;
        int contadorPos5 = 0;

        ArrayList<Integer> listaAux = new ArrayList<>();
        for(SpinnerOrderedChoice opcion : opcionesVista){
            listaAux.add(opcion.getNumeroOrden());
        }
        for(int orden : listaAux){
            if(orden == 1)
                contadorPos1++;
            if(orden == 2)
                contadorPos2 ++;
            if(orden == 3)
                contadorPos3 ++;
            if(orden == 4)
                contadorPos4 ++;
            if(orden == 5)
                contadorPos5 ++;
        }
        return hayMasDeUnaOpcionEnElMismoLugar(contadorPos1, contadorPos2, contadorPos3, contadorPos4, contadorPos5);
    }

    private boolean hayMasDeUnaOpcionEnElMismoLugar(int contadorPos1, int contadorPos2, int contadorPos3, int contadorPos4, int contadorPos5) {
        return (contadorPos1 > 1) || (contadorPos2 > 1) || (contadorPos3 > 1) || (contadorPos4 > 1) || (contadorPos5 > 1);
    }

    private void convertirOpcionesSimples() {
        opcionesVista.sort(new ComparadorOrderedChoice());

        for (SpinnerOrderedChoice opcionVista:opcionesVista) {
            opcionesJugador.add(opcionesOrdenHash.get(opcionVista.getEnunciadoOpcion()));
        }
    }

}