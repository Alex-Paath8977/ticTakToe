package com.example.tictaktoe;
/** Checks for winning combination and a draw */
public class WinValidator {

    public boolean hasWinner(char[][] gameState) {

        for (int i = 0; i < 3; i++) {
            // Lines
            if (checkLine(
                    gameState[i][0], gameState[i][1], gameState[i][2])) {
                return true;
            }
            // Column
            if (checkLine(
                    gameState[0][i], gameState[1][i], gameState[2][i])) {
                return true;
            }
        }
        // Diagonals
        return checkLine(gameState[0][0], gameState[1][1], gameState[2][2]) ||
                checkLine(gameState[0][2], gameState[1][1], gameState[2][0]);
    }
    private boolean checkLine(char a, char b, char c) {
        return a != ' ' && a == b && b == c;
    }

    public boolean isDraw(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return !hasWinner(board);
    }

}

