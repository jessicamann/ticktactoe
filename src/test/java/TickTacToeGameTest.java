import com.thoughtworks.ticktactoe.TickTacToeGame;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeGameTest {
    @Test
    public void shouldCreateAThreeByThreeBoardWhenGameStarts(){
        // setup
        PrintStream printStream = mock(PrintStream.class);
        TickTacToeGame tickTacToeGame = new TickTacToeGame(printStream);

        // action
        tickTacToeGame.createBoard();

        verify(printStream).print(
                        "       |       |       \n" +
                        "-----------------------\n" +
                        "       |       |       \n" +
                        "-----------------------\n" +
                        "       |       |       \n");

    }

    @Test
    public void shouldCreateAnXAtTheNumberedLocationUserIndicated(){
        // setup
        PrintStream printStream = mock(PrintStream.class);
        TickTacToeGame tickTacToeGame = new TickTacToeGame(printStream);

        // action
        tickTacToeGame.drawX(7);

        assertTrue(tickTacToeGame.spotAt(7).equals("X"));
    }


}
