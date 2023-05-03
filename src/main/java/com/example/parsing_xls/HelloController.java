package com.example.parsing_xls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {



    @FXML
    protected void onReadTestClick() throws IOException {
        XlsReader.SearchEngine();
    }

    public void onWriteTestClick(ActionEvent actionEvent) {
        DatabaseWriter.main();
        DatabaseWriter.QueryExecute();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}