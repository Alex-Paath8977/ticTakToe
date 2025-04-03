package com.example.tictaktoe;

import java.util.Arrays;

/** Класс GameState отвечает за храрнеие данных и за зменеие состояния игры (старт, пауза и завершение)*/
public class GameState {
    private char currentSymbol = 'X';
    private final char[][] gameField = new char[3][3];
    private boolean isGameActive = true;

    public char[][] getGameField() {
        return Arrays.stream(gameField)
                .map(char[]::clone)
                .toArray(char[][]::new);
    }
    public GameState() {
        GameLogic();
    }
    public void GameLogic() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameField[i][j] = ' ';
            }
        }
    }

    public char getCurrentSymbol() { // геттер того символа что мы выводим
        return currentSymbol;
    }
    public void setCell(int row, int column, char currentSymbol) { // Установка символа в игровое поле
        gameField[row][column] = currentSymbol;
    }
    public void switchSymbol() { // Меняет символ
        currentSymbol = currentSymbol == 'X' ? 'O' : 'X';
    }

    public boolean isGameActive() { // Проверка активности игры геттер активности игры
        return isGameActive;
    }

    public void setGameActive(boolean active) { // сеттер будет принмать свежее значение
        isGameActive = active;
    }

}
