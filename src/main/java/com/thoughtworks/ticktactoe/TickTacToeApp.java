package com.thoughtworks.ticktactoe;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeApp {
    private TickTacToeGame tickTacToeGame;

    public TickTacToeApp(TickTacToeGame tickTacToeGame) {
        this.tickTacToeGame = tickTacToeGame;
    }

    public static void main(String[] args){
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintStream printStream = System.out;
        GameBoard gameBoard = new GameBoard(printStream);
        TickTacToeGame game = new TickTacToeGame(System.out, reader, gameBoard);
        game.startGame();
    }

    public void start() {
        tickTacToeGame.startGame();
    }
}
