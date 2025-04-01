package com.example.tictaktoe;

import javafx.scene.control.Button;


public class GameLogic {
    private char currentSymbol = 'X';
    private char[][] gameField = new char[3][3];
    private boolean isGameActive = true;

    public GameLogic() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameField[i][j] = ' ';
            }
        }
    }

    public boolean isGameActive() { // Проверка активности игрв
        return isGameActive;
    }

    public void setIsGameActive(boolean active) {
        isGameActive = active;
    }

    public void switchSymbol() { // Меняет символ
        currentSymbol = currentSymbol == 'X' ? 'O' : 'X';
    }

    public void setCell(int row, int column) { // Установка символа в игровое поле
        gameField[row][column] = currentSymbol;
    }

    public boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if ((gameField[i][0] != ' ') &&
                    gameField[i][0] == gameField[i][1] &&
                    gameField[i][1] == gameField[i][2])
                return true;
            else if ((gameField[0][i] != ' ') &&
                    gameField[0][i] == gameField[1][i] &&
                    gameField[1][i] == gameField[2][i])
                return true;
            else if ((gameField[0][0] != ' ') &&
                    gameField[0][0] == gameField[1][1] &&
                    gameField[1][1] == gameField[2][2])
                return true;
            else if ((gameField[0][2] != ' ') &&
                    gameField[0][2] == gameField[1][1] &&
                    gameField[1][1] == gameField[2][0])
                return true;
        }
        return false;
    }

    public char getCurrentSymbol() {
        return currentSymbol;
    }

    public char[][] getGameField() {
        return gameField;
    }
}
