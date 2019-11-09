package fiuba.algo3.algochess;

import fiuba.algo3.algochess.tablero.casillero.CasilleroException;
import fiuba.algo3.algochess.tablero.casillero.ColocarEnCasilleroEnemigoException;
import fiuba.algo3.algochess.tablero.casillero.ColocarEnCasilleroOcupadoException;
import fiuba.algo3.algochess.tablero.casillero.VaciarCasilleroVacioException;
import fiuba.algo3.algochess.pieza.Pieza;

import fiuba.algo3.algochess.pieza.SoldadoDeInfanteria;
import fiuba.algo3.algochess.tablero.FueraDelTableroException;
import fiuba.algo3.algochess.tablero.Tablero;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {
    @Mock
    private Pieza pieza;
/*
    @Test
    public void testTableroRecienCreadoEstaVacio() {
        Tablero tablero = new Tablero();
        assertTrue(tablero.estaVacio());
    }

    @Test
    public void testTableroAlColocarUnaPiezaDejaDeEstarVacio() throws CasilleroException, FueraDelTableroException {
        Tablero tablero = new Tablero();
        Pieza piezaConcreta = new SoldadoDeInfanteria();
        tablero.posicionar(piezaConcreta, 0, 0);
        assertFalse(tablero.estaVacio());
    }
*/
    @Test
    public void testTableroAlColocarUnaPiezaEnUnCasilleroOcupadoSeLanzaCasilleroOcupadoException() throws CasilleroException, FueraDelTableroException {
        // Arrange
        Tablero tablero = new Tablero();
        Pieza piezaConcreta = new SoldadoDeInfanteria();
        Pieza otraPiezaConcreta = new SoldadoDeInfanteria();
        tablero.posicionar(otraPiezaConcreta, new Posicion(0, 0));
        // Act - Assert
        assertThrows(ColocarEnCasilleroOcupadoException.class,
                () -> {
                    tablero.posicionar(piezaConcreta, new Posicion(0, 0));
                });
    }

    @Test
    public void testTableroAlColocarUnaPiezaEnUnCasilleroEnemigoSeLanzaCasilleroEnemigoException() {
        // Arrange
         Tablero tablero = new Tablero();
        Pieza piezaConcreta = new SoldadoDeInfanteria();
        // Act - Assert
        assertThrows(ColocarEnCasilleroEnemigoException.class,
                () -> {
                    tablero.posicionar(piezaConcreta, new Posicion(0, 10));
                });
    }
/*
    @Test
    public void testTableroAlColocarYSacarUnaPiezaElTableroQuedaVacio() throws CasilleroException, FueraDelTableroException {
        // Arrange
        Tablero tablero = new Tablero();
        Pieza piezaConcreta = new SoldadoDeInfanteria();
        // Act
        tablero.posicionar(piezaConcreta, 0, 0);
        tablero.sacar(0, 0);
        // Assert
        assertTrue(tablero.estaVacio());
    }
*/

    @Test
    public void testTableroSacarPiezaDeCasilleroVacioLanzaVaciarCasilleroVacioException() {
        // Arrange
        Tablero tablero = new Tablero();
        // Act - Assert
        assertThrows(VaciarCasilleroVacioException.class,
                () -> {
                        tablero.sacar(new Posicion(0, 0));
                });
    }

    @Test
    public void testTableroSePuedeColocarPiezaEnCasilleroDespuesDeColocarYSacarOtraPiezaEnElMismoCasillero() throws CasilleroException, FueraDelTableroException {
        // Arrange
        Tablero tablero = new Tablero();
        Pieza piezaConcreta = new SoldadoDeInfanteria();
        Pieza otraPiezaConcreta = new SoldadoDeInfanteria();
        tablero.posicionar(otraPiezaConcreta, new Posicion(0, 0));
        tablero.sacar(new Posicion(0, 0));
        // Act
        tablero.posicionar(piezaConcreta, new Posicion(0, 0));
        // Assert
//        assertFalse(tablero.estaVacio());
//        assertEquals(piezaConcreta.getPosicion(), posicion);
//        assertNotEquals(otraPiezaConcreta, posicion);
    }

    @Test
    public void testTableroColocarPiezaFueraDelRangoEnFilasLanzaFueraDelTableroException() {
        // Arrange
        Tablero tablero = new Tablero();
        // Act - Assert
        assertThrows(FueraDelTableroException.class,
                () -> {
                    tablero.posicionar(pieza, new Posicion(0, 21));
                });
    }

    @Test
    public void testTableroColocarPiezaFueraDelRangoEnColumnasLanzaFueraDelTableroException() {
        // Arrange
        Tablero tablero = new Tablero();
        // Act - Assert
        assertThrows(FueraDelTableroException.class,
                () -> {
                    tablero.posicionar(pieza, new Posicion(21, 0));
                });
    }

    @Test
    public void testTableroColocarPiezaFueraDelRangoEnFilasYColumnasLanzaFueraDelTableroException() {
        // Arrange
        Tablero tablero = new Tablero();
        // Act - Assert
        assertThrows(FueraDelTableroException.class,
                () -> {
                    tablero.posicionar(pieza, new Posicion(21, 21));
                });
    }

    @Test
    public void testTableroColocarPiezaEnPoscicionNegativaLanzaFueraDelTableroException() {
        // Arrange
        Tablero tablero = new Tablero();
        // Act - Assert
        assertThrows(FueraDelTableroException.class,
                () -> {
                    tablero.posicionar(pieza, new Posicion(-1, -1));
                });
    }
}
