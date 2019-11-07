package fiuba.algo3.algochess;


import fiuba.algo3.algochess.pieza.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ArmaTest {

    @Test
    public void test00EspadaPesadaMataAUnaPiezaQueEstaACortoAlcanceQueTiene10DeVida() throws ArmaFueraDeAlcanceException {
        //Arrange
        Arma espadaPesada = new EspadaPesada();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(2,0);
        objetivo.setPosicion(posObjetivo);
        objetivo.recibirDanio(90);
        //Act
        espadaPesada.atacarA(objetivo,posOrigen);
        //Assert
        assertFalse(objetivo.estaViva());
    }

    @Test
    public void test01EspadaPesadaNoMataAUnaPiezaQueEstaACortoAlcanceQueTiene11DeVida() throws ArmaFueraDeAlcanceException {
        //Arrange
        Arma espadaPesada = new EspadaPesada();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(2,0);
        objetivo.setPosicion(posObjetivo);
        objetivo.recibirDanio(89);
        //Act
        espadaPesada.atacarA(objetivo,posOrigen);
        //Assert
        assertTrue(objetivo.estaViva());
    }

    @Test
    public void test02EspadaPesadaAtacarAPiezaQueNoEstaACortoAlcanceLanzaArmaFueraDeAlcanceException() {
        //Arrange
        Arma espadaPesada = new EspadaPesada();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(7,8);
        objetivo.setPosicion(posObjetivo);

        //Act-Assert
        assertThrows(ArmaFueraDeAlcanceException.class,
                () -> {
                    espadaPesada.atacarA(objetivo,posOrigen);
                });
    }

    @Test
    public void test03EspadaLivianaMataAUnaPiezaQueEstaACortoAlcanceQueTiene5DeVida() throws ArmaFueraDeAlcanceException {
        //Arrange
        Arma espadaLiviana = new EspadaLiviana();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(2,0);
        objetivo.setPosicion(posObjetivo);
        objetivo.recibirDanio(95);
        //Act
        espadaLiviana.atacarA(objetivo,posOrigen);
        //Assert
        assertFalse(objetivo.estaViva());
    }

    @Test
    public void test04EspadaLivianaNoMataAUnaPiezaQueEstaACortoAlcanceQueTiene6DeVida() throws ArmaFueraDeAlcanceException {
        //Arrange
        Arma espadaLiviana = new EspadaLiviana();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(2,0);
        objetivo.setPosicion(posObjetivo);
        objetivo.recibirDanio(94);
        //Act
        espadaLiviana.atacarA(objetivo,posOrigen);
        //Assert
        assertTrue(objetivo.estaViva());
    }

    @Test
    public void test05EspadaLivianaAtacarAPiezaQueNoEstaACortoAlcanceLanzaArmaFueraDeAlcanceException() {
        //Arrange
        Arma espadaLiviana = new EspadaLiviana();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(7,8);
        objetivo.setPosicion(posObjetivo);

        //Act-Assert
        assertThrows(ArmaFueraDeAlcanceException.class,
                () -> {
                    espadaLiviana.atacarA(objetivo,posOrigen);
                });
    }

    @Test
    public void test06ArcoMataAUnaPiezaQueEstaAAlcanceMedioQueTiene15DeVida() throws ArmaFueraDeAlcanceException {
        //Arrange
        Arma arco= new Arco();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(4,4);
        objetivo.setPosicion(posObjetivo);
        objetivo.recibirDanio(85);
        //Act
        arco.atacarA(objetivo,posOrigen);
        //Assert
        assertFalse(objetivo.estaViva());
    }

    @Test
    public void test07ArcoNoMataAUnaPiezaQueEstaAAlcanceMedioQueTiene16DeVida() throws ArmaFueraDeAlcanceException {
        //Arrange
        Arma arco = new Arco();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(4,4);
        objetivo.setPosicion(posObjetivo);
        objetivo.recibirDanio(84);
        //Act
        arco.atacarA(objetivo,posOrigen);
        //Assert
        assertTrue(objetivo.estaViva());
    }

    @Test
    public void test08ArcoAtacarAPiezaQueNoEstaAAlcanceMedioLanzaArmaFueraDeAlcanceException() {
        //Arrange
        Arma arco = new Arco();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(1,1);
        objetivo.setPosicion(posObjetivo);

        //Act-Assert
        assertThrows(ArmaFueraDeAlcanceException.class,
                () -> {
                    arco.atacarA(objetivo,posOrigen);
                });
    }

    @Test
    public void test09ProyectilMataAUnaPiezaQueEstaAAlcanceLejanoQueTiene20DeVida() throws ArmaFueraDeAlcanceException {
        //Arrange
        Arma proyectil= new Proyectil();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(10,10);
        objetivo.setPosicion(posObjetivo);
        objetivo.recibirDanio(80);
        //Act
        proyectil.atacarA(objetivo,posOrigen);
        //Assert
        assertFalse(objetivo.estaViva());
    }

    @Test
    public void test10ProyectilNoMataAUnaPiezaQueEstaAAlcanceLejanoQueTiene21DeVida() throws ArmaFueraDeAlcanceException {
        //Arrange
        Arma proyectil = new Proyectil();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(10,10);
        objetivo.setPosicion(posObjetivo);
        objetivo.recibirDanio(79);
        //Act
        proyectil.atacarA(objetivo,posOrigen);
        //Assert
        assertTrue(objetivo.estaViva());
    }

    @Test
    public void test11ProyectilAtacarAPiezaQueNoEstaAAlcanceLejanoLanzaArmaFueraDeAlcanceException() {
        //Arrange
        Arma proyectil = new Proyectil();
        Posicion posOrigen = new Posicion(0,0);
        Pieza objetivo = new SoldadoDeInfanteria();
        Posicion posObjetivo = new Posicion(1,1);
        objetivo.setPosicion(posObjetivo);

        //Act-Assert
        assertThrows(ArmaFueraDeAlcanceException.class,
                () -> {
                    proyectil.atacarA(objetivo,posOrigen);
                });
    }


}




