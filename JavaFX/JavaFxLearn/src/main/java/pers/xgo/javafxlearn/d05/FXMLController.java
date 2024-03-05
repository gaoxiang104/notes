package pers.xgo.javafxlearn.d05;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLController extends Application {

    @FXML
    private Label label1;
    @FXML
    private Button button;

    public static void main(String[] args) {
        System.out.println(FXMLDemo01.class.getResource(""));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLDemo01.class.getResource("FXMLController.fxml"));
        VBox vbox = fxmlLoader.load();
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(250);
        primaryStage.show();

    }

    @FXML
    public void reactToClick(){
        label1.setText("Button clicked");
    }
}
