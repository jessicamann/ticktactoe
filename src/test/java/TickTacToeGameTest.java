import com.thoughtworks.ticktactoe.TickTacToeGame;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeGameTest {
    PrintStream printStream;
    BufferedReader reader;
    TickTacToeGame tickTacToeGame;

    @Before
    public void setup(){
        // setup
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        tickTacToeGame = new TickTacToeGame(printStream, reader);
    }

    @Test
    public void shouldPrintAThreeByThreeBoardWhenGameStarts(){
        // action
        tickTacToeGame.createBoard();

        verify(printStream).print(
                                " | | \n" +
                                "-----\n" +
                                " | | \n" +
                                "-----\n" +
                                " | | \n");

    }

    @Test
    public void shouldStoreAnXAtTheNumberedLocationUserIndicated(){
        // action
        tickTacToeGame.drawX(7);

        assertTrue(tickTacToeGame.spotAt(7).equals("X"));
    }

    @Test
    public void shouldPrintBoardWithAnXAtNumberedLocationUserIndicated(){
        // action
        tickTacToeGame.drawX(7);

        verify(printStream).print(
                        " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        "X| | \n");
    }

    @Test
    public void shouldPrintPromptForUserToTypeInLocationNumberToMarkXWhenBeginToTakeInUserInput() throws IOException {
        // action
        when(reader.readLine()).thenReturn("7");
        tickTacToeGame.getUserInput();

        verify(printStream).print("Please enter the numeric spot (1-9) for where you'd like to place your mark: ");
    }


}
