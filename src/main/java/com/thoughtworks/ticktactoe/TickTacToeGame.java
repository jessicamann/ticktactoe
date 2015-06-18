package com.thoughtworks.ticktactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeGame {
    private PrintStream printStream;
    private BufferedReader reader;
    private GameBoard gameBoard;
    public int currentPlayer;

    public TickTacToeGame(PrintStream printStream, BufferedReader reader, GameBoard board) {

        this.printStream = printStream;
        this.reader = reader;
        this.gameBoard = board;

        this.currentPlayer = 1;
    }

    public void startGame() {
        gameBoard.printBoard();
        getUserInput();
    }

    public void drawMarkOnBoard(int markSpot) {
        if(currentPlayer==1) {
            gameBoard.add(markSpot, "X");
        } else {
            gameBoard.add(markSpot, "O");
        }
        gameBoard.printBoard();
    }

    public void getUserInput() {
        if(currentPlayer==1){
            printStream.print("Player1, Please enter the numeric spot (1-9) for where you'd like to place your mark: ");
        } else{
            printStream.print("Player2, Please enter the numeric spot (1-9) for where you'd like to place your mark: ");
        }
        int spotOnBoard = -1;
        try {
            spotOnBoard = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(spotOnBoard>0 && spotOnBoard<10){
            drawMarkOnBoard(spotOnBoard);
        }
        currentPlayer%=2;
        currentPlayer+=1;
    }
}
