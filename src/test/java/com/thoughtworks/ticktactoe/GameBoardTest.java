package com.thoughtworks.ticktactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by jmann on 6/18/15.
 */
public class GameBoardTest {
    private GameBoard gameBoard;
    private PrintStream printStream;
    private List<String> cells;

    @Before
    public void setup(){
        cells = Arrays.asList(
                " ", " "," ",
                " ", " "," ",
                " ", " "," ");
        printStream = mock(PrintStream.class);
        gameBoard = new GameBoard(printStream, cells);
    }

    @Test
    public void shouldPrintAThreeByThreeGridWhenPrintBoard(){
        gameBoard.printBoard();

        verify(printStream).println(
                " | | \n" +
                "-----\n" +
                " | | \n" +
                "-----\n" +
                " | | \n");
    }

    @Test
    public void shouldSetCellZeroOfBoardToXWhenPlayerOneMarksPositionOne(){
        gameBoard.mark(1, "X");

        assertThat(cells.get(0), is("X"));
    }

    @Test
    public void shouldasldkfjasldf(){
        for(int i=1; i<10; i++){
            gameBoard.mark(i, ""+i);
        }
        gameBoard.printBoard();

        verify(printStream).println(
                "1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9\n");
    }

    @Test
    public void shouldTellGameThatCellZeroIsTakenWhenPositionOneOnBoardIsAlreadyMarked(){
        cells.set(0, "X");

        boolean isNotTaken = gameBoard.cellNotTaken(1);

        assertThat(isNotTaken, is(false));  //something weird is happening with java passing reference/value
    }

    @Test
    public void shouldTellGameThatCellZeroIsNotTakenWhenPositionOneOnBoardIsNotMarked() {
        cells.set(0, "X");

        boolean isNotTaken = gameBoard.cellNotTaken(2);

        assertThat(isNotTaken, is(true));
    }
}
