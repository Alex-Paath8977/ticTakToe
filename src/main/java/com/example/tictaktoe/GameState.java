package com.example.tictaktoe;

import java.util.Arrays;

/** The GameState class is responsible for storing data and for changing the game state (start, pause and end) */

public class GameState {
    private char currentSymbol = 'X';
    private final char[][] gameField = new char[3][3];
    private boolean isGameActive = true;

    // Returns a copy of the field for security
    public char[][] getGameField() {
        return Arrays.stream(gameField)
                .map(char[]::clone)
                .toArray(char[][]::new);
    }
    public GameState() {
        reset();
    }

    public char getCurrentSymbol() {
        return currentSymbol;
    }

    // Sets the symbol in the cell
    public void setCell(int row, int column, char currentSymbol) {
        gameField[row][column] = currentSymbol;
    }

    // Switches the symbol
    public void switchSymbol() {
        currentSymbol = currentSymbol == 'X' ? 'O' : 'X';
    }

    public boolean isGameActive() {
        return isGameActive;
    }

    public void setGameActive(boolean active) {
        isGameActive = active;
    }

    // Resetting the game: clearing  the field and setting 'X' first
    public void reset() {
        for (char[] row : gameField) {
            Arrays.fill(row, ' ');
        }
        currentSymbol = 'X';
        isGameActive = true;
    }

}
