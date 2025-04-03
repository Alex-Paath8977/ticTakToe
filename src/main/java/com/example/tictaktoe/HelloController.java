package com.example.tictaktoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private final GameState gameState = new GameState();
    private final WinValidator winValidator = new WinValidator();

    @FXML
    void buttonClick(ActionEvent event) { //При нажатие на кнопку будет отображен или Х или 0
        Button button = (Button) event.getSource(); // переменная кнопки


        if (!gameState.isGameActive() || !button.getText().isEmpty()) // Проверка активна ли игра и доступность кнопки
            return;

        int rowIndex = GridPane.getRowIndex(button) == null ? 0 : GridPane.getRowIndex(button); //получаем индекс и сразу обработываем на случай если значение 0
        int columnIndex = GridPane.getColumnIndex(button) == null ? 0 : GridPane.getColumnIndex(button);

        gameState.setCell(rowIndex, columnIndex, gameState.getCurrentSymbol());
        button.setText(String.valueOf(gameState.getCurrentSymbol())); // обращаем к кнопке и передаем значение

        if (winValidator.hasWinner(gameState.getGameField())) {
            showWinnerMassege(gameState.getCurrentSymbol());
            gameState.setGameActive(false);
        }
        else {
            gameState.switchSymbol();
        }

    }
        public void showWinnerMassege(char winnerSymbol) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("У нас есть победитель " + winnerSymbol + " !");
            alert.getButtonTypes().setAll(ButtonType.OK);
            alert.showAndWait();
        }

    @FXML
    void initialize() {

    }

}

