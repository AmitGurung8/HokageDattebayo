package org.example.hokagedattebayo.Controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import org.example.hokagedattebayo.Models.Character;
import org.example.hokagedattebayo.Models.Characters;
import org.example.hokagedattebayo.NarutoCharacterFinderApp;

import java.util.List;

public class NarutoCharacterFinderController {
    @FXML
    private TableView<Character> CharacterTable;

    @FXML

    private ImageView ImageOfTheCharacter;

    @FXML
    private TableColumn<Character, List<String>> Jutsu;

    @FXML
    private TableColumn<Character, String> Name;

    @FXML
    private TextField SearchBar;

    @FXML
    private Button SearchButton;
    private ObservableList<Character> characterData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        // Map columns to Character class properties
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        if (Jutsu != null)
        Jutsu.setCellValueFactory(new PropertyValueFactory<>("Jutsu"));

        // Add double-click listener to TableView rows
        CharacterTable.setRowFactory(tv -> {
            TableRow<Character> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Character rowData = row.getItem();
                    NarutoCharacterFinderApp.stage.setScene(NarutoCharacterFinderApp.scene2);
                    NarutoCharacterFinderApp.controller = NarutoCharacterFinderApp.loader2.getController();
                    NarutoCharacterFinderApp.controller.showDetails(rowData);
                }
            });
            return row;
        });

        // Set the TableView's items to the characterData list
        CharacterTable.setItems(characterData);
    }


    @FXML
    void SearchButtonAction(ActionEvent event) {
        String query = SearchBar.getText();
        query= "?name=" + query;
        try {
            Characters characters = ApiUtility.fetchCharacters(query);
            characterData.clear();
            characterData.addAll(characters.getCharacters());
            CharacterTable.setItems(characterData);

        } catch (Exception e) {
            showError("Failed to fetch data: " + e.getMessage());
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void CharacterSearch(ActionEvent actionEvent) {
    }
}

