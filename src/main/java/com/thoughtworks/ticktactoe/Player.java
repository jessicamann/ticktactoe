package com.thoughtworks.ticktactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by jmann on 6/21/15.
 */
public class Player {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private GameBoard gameBoard;
    private String symbol;
    private int number;

    public Player(PrintStream printStream, BufferedReader bufferedReader, GameBoard gameBoard, String symbol, int number) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.gameBoard = gameBoard;
        this.symbol = symbol;
        this.number = number;
    }

    public void move() {
        printStream.println("Player"+number+", please enter a number between 1 and 9");

        int position = readLine();

        if(gameBoard.cellNotTaken(position)) {
            gameBoard.mark(position, symbol);
        } else {
            printStream.println("Location already taken");
            move();
        }
    }

    private int readLine() {
        String input = "-1";
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(input);
    }


}
