package com.example.parsing_xls;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        XlsReader.main();
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}