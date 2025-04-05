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

    // Name matching is a must (fx:id="button00" in FXML)
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
    void buttonClick(ActionEvent event) {
        Button button = (Button) event.getSource();

        // Ignore the click if the game is finished or the cell is already occupied
        if (!gameState.isGameActive() || !button.getText().isEmpty())
            return;

        // Get the button index (default value is 0)
        int rowIndex = GridPane.getRowIndex(button) == null ? 0 : GridPane.getRowIndex(button);
        int columnIndex = GridPane.getColumnIndex(button) == null ? 0 : GridPane.getColumnIndex(button);

        gameState.setCell(rowIndex, columnIndex, gameState.getCurrentSymbol());
        button.setText(String.valueOf(gameState.getCurrentSymbol()));


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

        // Clears all buttons on the playing field
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

        // Processing of selection in dialog box
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == yesButton) {
                Platform.runLater(this::restartGame);
            }
        });
    }

}