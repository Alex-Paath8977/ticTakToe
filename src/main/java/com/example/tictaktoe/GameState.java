package com.example.tictaktoe;

import java.util.Arrays;

/** Класс GameState отвечает за храрнеие данных и за зменеие состояния игры (старт, пауза и завершение)*/
public class GameState {
    private char currentSymbol = 'X';
    private final char[][] gameField = new char[3][3];
    private boolean isGameActive = true;

    public char[][] getGameField() { //Геттер массива
        return Arrays.stream(gameField)
                .map(char[]::clone)
                .toArray(char[][]::new);
    }
    public GameState() {
        reset();
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

    public boolean isGameActive() { // Проверка активности игры геттер активности игры (геттер)
        return isGameActive;
    }

    public void setGameActive(boolean active) { // сеттер будет принмать свежее значение
        isGameActive = active;
    }

    public void reset() { // Обеспечивает что игра начинается именно с первоначальных значений и очищает клетки
        for (char[] row : gameField) {
            Arrays.fill(row, ' ');
        }

        currentSymbol = 'X';
        isGameActive = true;
    }

}
