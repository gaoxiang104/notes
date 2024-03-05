package pers.xgo.javafxlearn.d05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FXMLEventHandlers extends Application {

    public static void main(String[] args) {
        System.out.println();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLDemo01.class.getResource("FXMLEventHandlers.fxml"));
        VBox vbox = fxmlLoader.load();
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(250);
        primaryStage.show();
    }
}
