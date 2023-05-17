package com.example.teamprojectmusicandpainting;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}