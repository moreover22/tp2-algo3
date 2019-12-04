package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.ParserObjeto;
import fiuba.algo3.algochess.model.Posicion;
import fiuba.algo3.algochess.model.pieza.Pieza;
import fiuba.algo3.algochess.model.pieza.alcance.Alcance;
import fiuba.algo3.algochess.view.CasilleroView;
import fiuba.algo3.algochess.view.JuegoView;
import fiuba.algo3.algochess.view.tablero.TableroView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PiezaMoverController implements EventHandler<MouseEvent> {
    private TableroView tableroView;
    private CasilleroView casilleroView;
    private JuegoView juego;

    public PiezaMoverController(TableroView tableroView, CasilleroView casilleroView, JuegoView juego) {
        this.tableroView = tableroView;
        this.casilleroView = casilleroView;
        this.juego = juego;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        Pieza pieza = casilleroView.getPieza();
        juego.setPiezaSeleccionada(pieza);
        System.out.println(juego.getPiezaSeleccionada().parsear());
        ParserObjeto infoPieza = pieza.parsear();

        Posicion posicion = (Posicion) infoPieza.get("posicion");
        ParserObjeto infoAlcance = (ParserObjeto) infoPieza.get("movimiento");
        Alcance alcance = (Alcance) infoAlcance.get("alcance");
        tableroView.desresaltarCasilleros();
        tableroView.resaltarParaMovimiento(alcance, posicion);
    }
}
