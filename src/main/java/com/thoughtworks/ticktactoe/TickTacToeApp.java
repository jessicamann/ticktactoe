package com.thoughtworks.ticktactoe;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeApp {

    public static void main(String[] args){
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintStream printStream = System.out;
        List<String> cells = Arrays.asList(
                " ", " ", " ",
                " ", " ", " ",
                " ", " ", " ");
        GameBoard gameBoard = new GameBoard(printStream, cells);
        Player player1 = new Player(printStream, reader, gameBoard, "X", 1);
        Player player2 = new Player(printStream, reader, gameBoard, "O", 2);
        TickTacToeGame game = new TickTacToeGame(gameBoard, player1, player2, player1);
        game.startGame();
    }
}
