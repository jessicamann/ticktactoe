package com.thoughtworks.ticktactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by jmann on 6/18/15.
 * This class will start a game and end a game.
 */
public class TickTacToeGame {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TickTacToeGame(GameBoard board, Player player1, Player player2) {

        this.gameBoard = board;
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;

    }

    public void startGame() {
        gameBoard.printBoard();

        while(!gameBoard.isFilled()) {

            nextTurn();
        }
    }

    private void nextTurn() {
        currentPlayer.move();
        gameBoard.printBoard();
        alternatePlayer();
    }

    private void alternatePlayer() {
        if(currentPlayer.equals(player1)){
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

}
