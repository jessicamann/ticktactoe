package com.thoughtworks.ticktactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmann on 6/18/15.
 */
public class GameBoard {
    private List<String> boardArray;
    private PrintStream printStream;
    private String board;

    public GameBoard(PrintStream printStream) {

        this.printStream = printStream;
        this.boardArray = new ArrayList<String>();
        for(int i=0; i<9; i++){
            this.boardArray.add(" ");
        }
    }

    public void printBoard() {
        board = "";

        createBoardRow(1);
        createLine();
        createBoardRow(2);
        createLine();
        createBoardRow(3);

        printStream.print(board);
        System.out.println();
        System.out.println();
    }

    private void createLine() {
        board += "-----\n";
    }

    private void createBoardRow(int row) {
        board += boardArray.get(row*3-3);
        board += "|";
        board += boardArray.get(row*3-2);
        board += "|";
        board += boardArray.get(row*3-1)+"\n";
    }

    public void add(int spotToAddMarkTo, String playerMark) {
        boardArray.set(spotToAddMarkTo-1, playerMark);
    }
}
