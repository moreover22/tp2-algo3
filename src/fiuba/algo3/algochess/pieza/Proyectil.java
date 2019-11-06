package fiuba.algo3.algochess.pieza;

import fiuba.algo3.algochess.pieza.alcance.AlcanceLejano;

public class Proyectil extends Arma {

    public Proyectil(){
        super(20, new AlcanceLejano());
    }
}
