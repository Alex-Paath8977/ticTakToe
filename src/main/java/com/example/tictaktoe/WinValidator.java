package com.example.tictaktoe;
/** Выполняет функцию проверки победной компинации и ничьи */
public class WinValidator {

    public boolean hasWinner(char[][] gameState) {

        for (int i = 0; i < 3; i++) {
            //Строки
            if (neckline(
                    gameState[i][0], gameState[i][1], gameState[i][2])) {
                return true;
            }
            // Столбы
            if (neckline(
                    gameState[0][i], gameState[1][i], gameState[2][i])) {
                return true;
            }
        }
        // Диагонали
        return neckline(gameState[0][0], gameState[1][1], gameState[2][2]) ||
                neckline(gameState[0][2], gameState[1][1], gameState[2][0]);
    }
    private boolean neckline(char a, char b, char c) {
        return a != ' ' && a == b && b == c;
    }
}
