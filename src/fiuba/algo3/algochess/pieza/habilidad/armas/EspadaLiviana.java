package fiuba.algo3.algochess.pieza.habilidad.armas;

import fiuba.algo3.algochess.pieza.Pieza;
import fiuba.algo3.algochess.pieza.alcance.AlcanceCercano;
import fiuba.algo3.algochess.pieza.habilidad.armas.Arma;

public class EspadaLiviana extends Arma {
    public EspadaLiviana() {
        super(5, new AlcanceCercano());
    }

    @Override
    final protected int contarAliado(Pieza pieza, int cantidadAliados) {
        return pieza.contarAliadosDeCaballeria(cantidadAliados);
    }

    @Override
    final protected boolean criterioDeActualizacion(int cantidadAliados, int cantidadEnemigos) {
        return cantidadAliados > 0 || cantidadEnemigos == 0;
    }

    @Override
    final protected Arma armaActualizada() {
        return new ArcoYFlecha();
    }
}



















