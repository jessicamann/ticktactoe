package com.thoughtworks.ticktactoe;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jmann on 6/18/15.
 */
public class GameBoard {
    private List<String> cells;
    private PrintStream printStream;
    private String board;
    private int emptyCells;

    public GameBoard(PrintStream printStream, List<String> cells) {

        this.printStream = printStream;
        this.cells = Arrays.asList(
                " ", " "," ",
                " ", " "," ",
                " ", " "," ");
        emptyCells = 9;
    }

    public void printBoard() {
        board = String.format(
                "%s|%s|%s\n"+
                "-----\n"+
                "%s|%s|%s\n"+
                "-----\n"+
                "%s|%s|%s\n",
                cells.get(0), cells.get(1), cells.get(2),
                cells.get(3), cells.get(4), cells.get(5),
                cells.get(6), cells.get(7), cells.get(8));

        printStream.println(board);
    }

    public void mark(int position, String playerSymbol) {

        cells.set(position - 1, playerSymbol);
        emptyCells ++;
    }


    public boolean cellNotTaken(int position) {
        return cells.get(position-1).equals(" ");
    }

    public boolean isFilled(){
        return emptyCells!=0;
    }
}
