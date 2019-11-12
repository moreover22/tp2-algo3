package fiuba.algo3.algochess.pieza.habilidad;

import fiuba.algo3.algochess.Posicion;
import fiuba.algo3.algochess.pieza.Pieza;
import fiuba.algo3.algochess.pieza.alcance.Alcance;
import fiuba.algo3.algochess.pieza.alcance.AlcanceCercano;

public class Curacion implements Habilidad {
    private Alcance alcance;
    private float curacion;

    public Curacion(float curacion) {
        this.curacion = curacion;
        this.alcance = new AlcanceCercano();
    }

    @Override
    public void usarCon(Pieza objetivo, Posicion desde) throws HabilidadFueraDeAlcanceException, HabilidadConObjetivoInvalidoException {
        objetivo.recibirCuracion(curacion, desde,alcance);
    }

}











