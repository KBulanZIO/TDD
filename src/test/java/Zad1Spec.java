import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class Zad1Spec {

    @Rule
    public ExpectedException exception= ExpectedException.none();
    private Zad1 zad1;

    @Before
    public final void before(){
        zad1=new Zad1();
    }
    // Wymaganie 1
    @Test
    public void whenXOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        zad1.play(5,2);
    }
    @Test
    public void whenYOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        zad1.play(2,5);
    }
    @Test
    public void whenOccupiedThenRuntimeException(){
        zad1.play(2,1);
        exception.expect(RuntimeException.class);
        zad1.play(2,1);
    }

    // Wymaganie 2
    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){
        assertEquals('X',zad1.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO() {
        // Zaczynamy - stawiamy  X
        zad1.play(2,1);
        // Nastepny gracz - O
        assertEquals('O',zad1.nextPlayer());
    }

//    @Test
//    public void givenLastTurnWasOWhenNextPlayerThenX() {
//        // Zaczynamy - stawiamy  X
//        zad1.play(2,1);
//        // Stawiamy  O
//        zad1.play(2,2);
//        // Nastepny gracz - X
//        assertEquals('X',zad1.nextPlayer());
//    }

    // Wymaganie 3
    @Test
    public void whenPlayThenNoWinner() {
        String actual = zad1.play(1,1);
        assertEquals("Brak zwyciezcy",actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        zad1.play(1, 1);//X
        zad1.play(1, 2);//0
        zad1.play(2, 1);//X
        zad1.play(2, 2);//O
        String actual = zad1.play(3, 1);//X
        assertEquals("Wygral X", actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        zad1.play(1, 1);//X
        zad1.play(2, 2);//0
        zad1.play(1, 2);//X
        zad1.play(2, 3);//O
        String actual = zad1.play(1, 3);//X
        assertEquals("Wygral X", actual);
    }

    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() {
        zad1.play(1, 3);//X
        zad1.play(1, 2);//O
        zad1.play(2, 2);//X
        zad1.play(3, 2);//O
        String actual = zad1.play(3, 1);//X
        assertEquals("Wygral X", actual);
    }

    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner() {
        zad1.play(3, 3);//X
        zad1.play(1, 2);//O
        zad1.play(2, 2);//X
        zad1.play(3, 2);//O
        String actual = zad1.play(1, 1);//X
        assertEquals("Wygral X", actual);
    }


}