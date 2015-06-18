package com.thoughtworks.ticktactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeApp {
    private TickTacToeGame tickTacToeGame;

    public TickTacToeApp(TickTacToeGame tickTacToeGame) {
        this.tickTacToeGame = tickTacToeGame;
    }

    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TickTacToeGame game = new TickTacToeGame(System.out, reader);
        game.startGame();
        game.drawX(7);
    }

    public void start() {
        tickTacToeGame.createBoard();
    }
}
