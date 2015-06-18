package com.thoughtworks.ticktactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeGame {
    private final ArrayList<String> boardBlocks;
    private PrintStream printStream;
    private BufferedReader reader;
    private String gameBoard;
    public int currentPlayer;

    public TickTacToeGame(PrintStream printStream, BufferedReader reader) {

        this.printStream = printStream;
        this.reader = reader;
        this.boardBlocks = new ArrayList<String>();
        for(int i=0; i<9; i++){
            boardBlocks.add(" ");
        }
        this.currentPlayer = 1;
    }

    public void createBoard() {
        gameBoard = "";

        createBoardRow(1);
        createLine();
        createBoardRow(2);
        createLine();
        createBoardRow(3);

        printStream.print(gameBoard);
        System.out.println();
        System.out.println();
    }

    private void createLine() {
        gameBoard += "-----\n";
    }

    private void createBoardRow(int row) {
        gameBoard += boardBlocks.get(row*3-3);
        gameBoard += "|";
        gameBoard += boardBlocks.get(row*3-2);
        gameBoard += "|";
        gameBoard += boardBlocks.get(row*3-1)+"\n";
    }

    public void startGame() {
        createBoard();
        getUserInput();
    }

    public void drawMarkOnBoard(int markSpot) {
        if(currentPlayer==1) {
            boardBlocks.add(markSpot-1, "X");
        } else {
            boardBlocks.add(markSpot-1, "O");
        }
        createBoard();
    }

    public String spotAt(int spotNumber) {
        return boardBlocks.get(spotNumber-1);
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
