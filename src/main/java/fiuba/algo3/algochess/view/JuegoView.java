package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.AlgoChess;
import fiuba.algo3.algochess.model.ParserObjeto;
import fiuba.algo3.algochess.model.Posicion;
import fiuba.algo3.algochess.model.jugador.CantidadDePuntosInsuficientesException;
import fiuba.algo3.algochess.model.jugador.Jugador;
import fiuba.algo3.algochess.model.pieza.movimiento.Direccion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.view.tablero.TableroView;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import javafx.stage.Stage;
import javafx.util.Duration;

public class JuegoView {
    private Stage stage;
    private AlgoChess modelo;
    private TableroView tableroView;
    public CustomBorderPane contenedor;
    private PiezaItemView piezaSeleccionada;
    private ContenedorPiezas contenedorIzquierda;
    private ContenedorPiezas contenedorDerecha;
    private Button aceptar;

    private InformacionTurno infoTurno;

    public JuegoView(Stage stage, AlgoChess modelo) {
        this.stage = stage;
        this.modelo = modelo;
        this.contenedor = new CustomBorderPane();
        this.infoTurno = new InformacionTurno();

        Tablero tablero = new Tablero(16, 16);

        aceptar = new Button("Aceptar");
        aceptar.getStyleClass().add("aceptar-btn");
        StackPane.setAlignment(aceptar, Pos.BOTTOM_CENTER);
        StackPane.setMargin(aceptar, new Insets(100));

        this.tableroView = new TableroView(tablero, this, infoTurno, aceptar);

        aceptar.setOnAction((evt) -> {
            tablero.cambiarAlianza();
            tableroView.actualizarCasilleros();
            cambiarJugador();
        });

        contenedorIzquierda = new ContenedorPiezas("blanco", this);
        contenedorDerecha = new ContenedorPiezas("negro", this);

        contenedor.setCenter(tableroView);
        contenedor.setLeft(contenedorIzquierda);

    }



    public void iniciar(String nombrePrimerJugador, String nombreSegundoJugador) {
        modelo.agregarJugador(nombrePrimerJugador);
        modelo.agregarJugador(nombreSegundoJugador);
        modelo.empezar();

        ParserObjeto infoModelo = modelo.parsear();
        Jugador jugadorActual = (Jugador) infoModelo.get("jugador_actual");
        infoTurno.actualizarTurno(jugadorActual);

        stage.hide();
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setScene(new Scene(contenedor));
        stage.show();
    }

    public void cambiarJugador() {
        modelo.cambiarTurno();
        ParserObjeto infoModelo = modelo.parsear();
        Jugador jugadorActual = (Jugador) infoModelo.get("jugador_actual");

        infoTurno.actualizarTurno(jugadorActual);

        ocultarJugadorContenedor(contenedorIzquierda, Direccion.izquierda());
        aceptar.setOnAction((evt) -> {
            empezarAJugar();
            tableroView.actualizarCasilleros();
        });
    }

    public void empezarAJugar() {
        ocultarJugadorContenedor(contenedorDerecha, Direccion.derecha());
        infoTurno.setMensaje("Empezar a jugar");
    }

    private void ocultarJugadorContenedor(ContenedorPiezas contenedor, Direccion direccion) {
        TranslateTransition ocultarContenedor = new TranslateTransition(new Duration(300), contenedor);
        int factor = (direccion == Direccion.izquierda()) ? -1 : 1;
        ocultarContenedor.setToX(factor * contenedor.getWidth());
        ocultarContenedor.setOnFinished(evt -> {
            if (direccion == Direccion.izquierda()) {
                this.contenedor.getChildren().remove(contenedorIzquierda);
                this.contenedor.setRight(contenedorDerecha);
            } else {
                this.contenedor.getChildren().remove(contenedorDerecha);
            }
        });
        ocultarContenedor.play();
    }

    public void setPiezaSeleccionada(PiezaItemView piezaItemView) {
        if (tienePiezaSeleccionada())
            piezaSeleccionada.deseleccionar();
        piezaSeleccionada = piezaItemView;
        piezaSeleccionada.seleccionar();
    }

    public boolean tienePiezaSeleccionada() {
        return piezaSeleccionada != null;
    }

    public PiezaItemView getPiezaSeleccionada() {
        return piezaSeleccionada;
    }

    public void actualizarTablero() {
        tableroView.actualizarCasilleros();
    }


    public void colocarPieza(Posicion posicion, PiezaItemView piezaSeleccionada) {
        tableroView.colocarPieza(posicion, piezaSeleccionada.getTipoPieza(), piezaSeleccionada.getColor());
    }

    public void agregarPieza() throws CantidadDePuntosInsuficientesException {
        modelo.agregarPieza(piezaSeleccionada.getPieza());
        Jugador jugadorActual = (Jugador) modelo.parsear().get("jugador_actual");
        infoTurno.actualizarTurno(jugadorActual);
    }

    public void colocarPieza(Posicion posicion) {
        tableroView.colocarPieza(posicion, piezaSeleccionada.getTipoPieza(), piezaSeleccionada.getColor());
    }

    public ParserObjeto casilleroInfo(Posicion posicion) {
        return tableroView.casilleroInfo(posicion);
    }


    public void mostrarError(String titulo, String mensaje) {
        VentanaPopUp popUpError = new VentanaPopUp(contenedor, titulo, mensaje);
        contenedor.setCenter(popUpError);
    }
}