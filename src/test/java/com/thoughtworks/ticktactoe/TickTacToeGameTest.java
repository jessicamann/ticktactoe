package com.thoughtworks.ticktactoe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static org.mockito.Mockito.*;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeGameTest {
    private TickTacToeGame tickTacToeGame;
    private GameBoard board;
    private Player player1;
    private Player player2;

    @Before
    public void setup(){
        // setup
        board = mock(GameBoard.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        tickTacToeGame = new TickTacToeGame(board, player1, player2);
    }

    @Test
    public void shouldPrintABoardWhenGameStarts(){
        tickTacToeGame.startGame();

        verify(board, times(10)).printBoard();
    }

    @Test
    public void shouldTellPlayerOneToMakeMoveWhenGameStarts(){
        tickTacToeGame.startGame();

        verify(player1, times(5)).move();
    }

    @Test
    public void shouldTellPlayerTwoToMakeMoveWhenPlayerOneHasFinished() {
        tickTacToeGame.startGame();

        verify(player2, times(4)).move();
    }

    @Test
    public void shouldAlternateFromPlayerOneToPlayerTwoWhenPlayerOneHasFinished(){

    }
}
