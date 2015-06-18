import com.thoughtworks.ticktactoe.GameBoard;
import com.thoughtworks.ticktactoe.TickTacToeGame;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
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
    GameBoard board;

    @Before
    public void setup(){
        // setup
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = mock(GameBoard.class);
        tickTacToeGame = new TickTacToeGame(printStream, reader, board);
    }

    @Test
    public void shouldPrintPromptForUserToTypeInLocationNumberToMarkXWhenBeginToTakeInUserInput() throws IOException {
        // action
        when(reader.readLine()).thenReturn("7");
        tickTacToeGame.getUserInput();

        verify(printStream).print("Player1, Please enter the numeric spot (1-9) for where you'd like to place your mark: ");
    }

    @Test
    public void shouldPromptPlayer2ForLocationNumberToMarkOIfItIsPlayerTwosTurn() throws IOException {
        // action
        when(reader.readLine()).thenReturn("6");
        tickTacToeGame.currentPlayer = 2;
        tickTacToeGame.getUserInput();

        verify(printStream).print("Player2, Please enter the numeric spot (1-9) for where you'd like to place your mark: ");
    }

    @Test
    public void shouldSwitchPlayerFromOneToTwoAfterPlayerOneHasInputtedLocationToMark() throws IOException {
        // action
        when(reader.readLine()).thenReturn("6");
        tickTacToeGame.currentPlayer = 1;
        tickTacToeGame.getUserInput();

        assertEquals(2, tickTacToeGame.currentPlayer);
    }



}
