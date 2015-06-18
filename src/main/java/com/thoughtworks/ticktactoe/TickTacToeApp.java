package com.thoughtworks.ticktactoe;

/**
 * Created by jmann on 6/18/15.
 */
public class TickTacToeApp {
    private TickTacToeGame tickTacToeGame;

    public TickTacToeApp(TickTacToeGame tickTacToeGame) {
        this.tickTacToeGame = tickTacToeGame;
    }

    public static void main(String[] args){
        TickTacToeGame game = new TickTacToeGame(System.out);
        game.startGame();
    }

    public void start() {
        tickTacToeGame.createBoard();
    }
}
