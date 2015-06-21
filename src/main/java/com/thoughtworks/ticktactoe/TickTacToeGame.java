package com.thoughtworks.ticktactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by jmann on 6/18/15.
 * This class will start a game and manage turns for players until game ends.
 */
public class TickTacToeGame {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TickTacToeGame(GameBoard board, Player player1, Player player2, Player currentPlayer) {

        this.gameBoard = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = currentPlayer;

    }

    public void startGame() {
        gameBoard.printBoard();

        player1.move();
        gameBoard.printBoard();

        player2.move();
        gameBoard.printBoard();

        player1.move();
        gameBoard.printBoard();

        player2.move();
        gameBoard.printBoard();

        player1.move();
        gameBoard.printBoard();

        player2.move();
        gameBoard.printBoard();

        player1.move();
        gameBoard.printBoard();

        player2.move();
        gameBoard.printBoard();

        player1.move();
        gameBoard.printBoard();
    }
}
