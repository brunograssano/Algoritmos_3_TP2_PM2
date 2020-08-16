package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaOrderedChoice;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.VistaGanador;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import edu.fiuba.algo3.vistas.seccionesVista.OpcionOrderedChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Comparator;

public class ControladorEnviarOrderedChoice implements EventHandler<ActionEvent> {

    private Stage stage;
    private ArrayList<OpcionOrderedChoice> opcionesVista;
    private ArrayList<OpcionSimple> opcionesCorrectas;
    private ArrayList<OpcionSimple> opcionesJugador;
    private ContenedorPrincipal contenedorPrincipal;

    public ControladorEnviarOrderedChoice(Stage escenario, ContenedorPrincipal contenedorPrincipal){
        stage = escenario;
        opcionesJugador = new ArrayList<>();
        this.contenedorPrincipal = contenedorPrincipal;
    }
    public void agregarOpcionesSeleccionadas(ArrayList<OpcionOrderedChoice> opciones){
        opcionesVista = opciones;
    }

    public void agregarOpcionesCorrectas(ArrayList<OpcionSimple> opcionesCorrectas){
        this.opcionesCorrectas = opcionesCorrectas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {


        if(seRepiteOpcionSeleccionada()) {
            Alert repiteoOrden = new Alert(Alert.AlertType.ERROR);
            repiteoOrden.setHeaderText("Se repitieron posiciones");
            repiteoOrden.setContentText("Se deben elegir posiciones de orden distintas para cada opcion!");
            repiteoOrden.show();
        }
        else{
            convertirOpcionesSimples();
            RespuestaOrderedChoice respuestaDeUnJugador = new RespuestaOrderedChoice(opcionesJugador);
            AlgoHoot.getInstance().procesarTurno(respuestaDeUnJugador);
            if(AlgoHoot.getInstance().terminoElJuego()){
                contenedorPrincipal.setCentro(new VistaGanador(stage));
            }else{
                contenedorPrincipal.setCentro(new VistaTransicionPregunta(stage,contenedorPrincipal));
            }
        }

    }

    private void convertirOpcionesSimples() {

        ArrayList <OpcionSimple> opcionesSeleccionadas = new ArrayList<>();

        opcionesVista.sort(new Comparator<OpcionOrderedChoice>() {
            @Override
            public int compare(OpcionOrderedChoice opcion1, OpcionOrderedChoice opcion2) {
                int valor = 0;
                if (opcion1.getNumeroOrden() > opcion2.getNumeroOrden())
                    valor = 1;
                else if (opcion1.getNumeroOrden() < opcion2.getNumeroOrden())
                    valor = -1;
                return valor;
            }
        });
        for (OpcionOrderedChoice opcion : opcionesVista) {
            for (OpcionSimple opcionCorrecta : opcionesCorrectas){
                if(opcion.getEnunciadoOpcion().equals(opcionCorrecta.obtenerTexto())) {
                    opcionesSeleccionadas.add(opcionCorrecta);
                }
            }
        }
        this.opcionesJugador = opcionesSeleccionadas;
    }

        private boolean seRepiteOpcionSeleccionada() {

            int contadorPos1 = 0;
            int contadorPos2 = 0;
            int contadorPos3 = 0;
            int contadorPos4 = 0;
            int contadorPos5 = 0;

            ArrayList<Integer> listaAux = new ArrayList<Integer>();
            for(OpcionOrderedChoice opcion : opcionesVista){
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
            return ( (contadorPos1 > 1) || (contadorPos2 > 1) || (contadorPos3 > 1) || (contadorPos4 > 1) || (contadorPos5 > 1) );
        }
    }