package com.thoughtworks.ticktactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jmann on 6/21/15.
 */
public class PlayerTest {

    private PrintStream printStream;
    private Player player;
    private GameBoard gameBoard;
    private BufferedReader bufferedReader;

    @Before
    public void setup(){
        bufferedReader = mock(BufferedReader.class);
        gameBoard = mock(GameBoard.class);
        printStream = mock(PrintStream.class);
        player = new Player(printStream, bufferedReader, gameBoard, "X", 1);
    }

    @Test
    public void shouldPromptPlayer1ForMoveWhenasdlkfjasd() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1");
        player.move();

        verify(printStream).println("Player1, please enter a number between 1 and 9");
    }

    @Test
    public void shouldSetPositionOnBoardWithAnXWhenPlayer1EntersANumber() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        player.move();

        verify(gameBoard).mark(1, "X");
    }

    @Test
    public void shouldSetPositionOnBoardWithAnOWhenPlayer2EntersANumber() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        Player player2 = new Player(printStream, bufferedReader, gameBoard, "O", 2);
        player2.move();

        verify(gameBoard).mark(1, "O");
    }

    @Test
    public void shouldPromptPlayer2ForMoveWhenasldkfjsd() throws IOException {
        when(bufferedReader.readLine()).thenReturn("-1");
        Player player2 = new Player(printStream, bufferedReader, gameBoard, "O", 2);
        player2.move();

        verify(printStream).println("Player2, please enter a number between 1 and 9");
    }

}