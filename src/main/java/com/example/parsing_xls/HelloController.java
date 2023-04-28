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

    public TableColumn<TestData, String> name;
    public TableColumn<TestData, Integer> age;
    public TableColumn<TestData, String> animal;
    public TableView<TestData> tbData;

    ObservableList<TestData> list = FXCollections.observableArrayList(
            new TestData("Даниил",20,"Собака"),
            new TestData("Анна",21,"Кошка"),
            new TestData("Марк", 22, "Птица")
    );

    @FXML
    protected void onReadTestClick() throws IOException {
        XlsReader.main();
    }

    public void onWriteTestClick(ActionEvent actionEvent) {
        DatabaseWriter.main();
        DatabaseWriter.QueryExecute();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<TestData , String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<TestData , Integer>("age"));
        animal.setCellValueFactory(new PropertyValueFactory<TestData , String>("animal"));

        tbData.setItems(list);
    }
}