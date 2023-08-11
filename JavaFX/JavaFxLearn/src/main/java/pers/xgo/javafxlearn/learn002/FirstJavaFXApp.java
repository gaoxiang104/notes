package pers.xgo.javafxlearn.learn002;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FirstJavaFXApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("My First JavaFX App");

        Label label = new Label("Hello World, JavaFX !");
        Scene scene = new Scene(label, 400, 200);
        stage.setScene(scene);

        stage.show();

        stage.heightProperty().addListener(
                (observableValue, number, t1) ->
                        System.out.println("高度：" + number));

        stage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
