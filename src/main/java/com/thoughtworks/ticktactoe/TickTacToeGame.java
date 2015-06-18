package com.thoughtworks.ticktactoe;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeGame {
    private final ArrayList<String> boardBlocks;
    private PrintStream printStream;

    public TickTacToeGame(PrintStream printStream) {

        this.printStream = printStream;
        this.boardBlocks = new ArrayList<String>();
        for(int i=0; i<9; i++){
            boardBlocks.add(null);
        }
    }

    public void createBoard() {
        printStream.print(
                        "       |       |       \n" +
                        "-----------------------\n" +
                        "       |       |       \n" +
                        "-----------------------\n" +
                        "       |       |       \n");
    }

    public void startGame() {

        createBoard();
    }

    public void drawX(int markSpot) {
        boardBlocks.add(markSpot, "X");
    }

    public String spotAt(int spotNumber) {
        return boardBlocks.get(spotNumber);
    }
}
