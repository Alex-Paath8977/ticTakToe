package com.example.tictaktoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML private Button button00, button01, button02;
    @FXML private Button button10, button11, button12;
    @FXML private Button button20, button21, button22;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridPane;

    private GameState gameState = new GameState();
    private WinValidator winValidator = new WinValidator();

    @FXML
    void initialize() {
    }

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
            showEndGameMassage("Победитель: " + gameState.getCurrentSymbol());
            gameState.setGameActive(false);
        }
        else if (winValidator.isDraw(gameState.getGameField())) {
            showEndGameMassage("Ничья!");
        }
        else {
            gameState.switchSymbol();
        }

    }
    @FXML
    private void restartGame() {
        gameState = new GameState();
        winValidator = new WinValidator();
        // обнуляет значения именно в кнопке
        button00.setText(""); button10.setText(""); button01.setText("");
        button20.setText(""); button21.setText(""); button11.setText("");
        button02.setText(""); button22.setText(""); button12.setText("");
    }

    public void showEndGameMassage(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Игра окончена!");
        alert.setHeaderText(message);
        alert.setContentText("Хотите начать заново?");

        ButtonType yesButton = new ButtonType("Да", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("Нет", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(yesButton, noButton);

        // Обработка выбора
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == yesButton) {
                Platform.runLater(this::restartGame);
            }
        });
    }

}

