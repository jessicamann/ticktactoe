import com.thoughtworks.ticktactoe.GameBoard;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jmann on 6/18/15.
 */
public class GameBoardTest {
    GameBoard gameBoard;
    PrintStream printStream;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        gameBoard = new GameBoard(printStream);
    }

    @Test
    public void shouldPrintAThreeByThreeBoardWhenGameStarts(){
        // action
        gameBoard.printBoard();

        verify(printStream).print(
                        " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n");
    }

    @Test
    public void shouldPrintBoardWithOneXWhenThereIsOnlyOneMarkMadeOnTheBoard(){
        // action
        gameBoard.add(1, "X");
        gameBoard.printBoard();

        verify(printStream).print(
                        "X| | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n");
    }

    @Test
    public void shouldPrintOneXAndOneOWhenThereAreTwoMarksMadeOnTheBoard(){
        // action
        gameBoard.add(1, "X");
        gameBoard.add(2, "O");
        gameBoard.printBoard();

        verify(printStream).print(
                        "X|O| \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n");
    }
}
