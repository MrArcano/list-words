package com.exercises.listwords;

import com.exercises.listwords.model.Words;
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/fxml/Scene.fxml"));
        Parent root = fxmlLoader.load();

        MainController controller = fxmlLoader.getController();
        Words words = new Words(new ArrayList<String>());
        controller.setElenco(words);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(MainApplication.class.getResource("/styles/Styles.css").toString());

        stage.setTitle("List WORDS!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}