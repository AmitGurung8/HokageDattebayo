package org.example.hokagedattebayo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.hokagedattebayo.Models.Character;
import org.example.hokagedattebayo.NarutoCharacterFinderApp;

public class DetailsController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label Debutlabel;

    @FXML
    private Label Jutsu;

    @FXML
    private ImageView ImageOfTheCharacter;

    public void showDetails(Character rowData) {
        if (rowData == null) return;
        if (rowData.getName() != null)
        nameLabel.setText(rowData.getName());
        if (rowData.getDebut() != null)
        Debutlabel.setText(rowData.getDebut().getManga());
        if (Jutsu != null)
        Jutsu.setText(rowData.getJutsu().getFirst());
        // set the image with the text stored in getimage
        if (rowData.getImages() != null) {
            if (rowData.getImages().size() > 1)
                ImageOfTheCharacter.setImage(new Image(rowData.getImages().get(1)));
            else
                ImageOfTheCharacter.setImage(new Image(rowData.getImages().get(0)));

        }
    }


    @FXML
    void back(ActionEvent event) {
        NarutoCharacterFinderApp.stage.setScene(NarutoCharacterFinderApp.scene1);
    }
}
