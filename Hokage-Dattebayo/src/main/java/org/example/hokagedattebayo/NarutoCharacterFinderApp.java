package org.example.hokagedattebayo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.hokagedattebayo.Controllers.DetailsController;

public class NarutoCharacterFinderApp extends Application {
    public static Scene scene1, scene2;
    public static FXMLLoader loader1, loader2;
    public static DetailsController controller;
    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        NarutoCharacterFinderApp.stage = stage;
         loader1 = new FXMLLoader(getClass().getResource("ff.fxml"));
         loader2 = new FXMLLoader(getClass().getResource("details.fxml"));
        NarutoCharacterFinderApp.scene1 = new Scene(loader1.load());
        NarutoCharacterFinderApp.scene2 = new Scene(loader2.load());
        scene1.getStylesheets().add(getClass().getResource("styles2.css").toExternalForm());
        stage.setTitle("Naruto Character Finder");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
