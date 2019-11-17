package fiuba.algo3.algochess.pieza;

import fiuba.algo3.algochess.pieza.habilidad.AtaqueAAliadoException;
import fiuba.algo3.algochess.pieza.habilidad.CuracionAEnemigoException;

public class Vida {
    private float vidaInicial;
    private float vidaActual;
    public Vida(float vidaInicial) {
        this.vidaInicial = vidaInicial;
        this.vidaActual = vidaInicial;
    }

    public float vidaActual() {
        return vidaActual;
    }

    public void recibirCuracion(float curacion, PiezaAlianza alianza) throws CuracionAEnemigoException {
        vidaActual = alianza.recibirCuracion(vidaActual, curacion);
        if(vidaActual > vidaInicial) {
            vidaActual = vidaInicial;
        }
    }

    public void recibirDanio(float danio, PiezaAlianza alianza) throws AtaqueAAliadoException {
        vidaActual = alianza.recibirDanio(vidaActual, danio);
    }

    public boolean tieneVida() {
        return vidaActual > 0;
    }
}