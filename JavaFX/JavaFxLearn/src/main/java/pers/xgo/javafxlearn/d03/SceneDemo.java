package pers.xgo.javafxlearn.d03;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scene Demo");

        primaryStage.setWidth(300);
        primaryStage.setHeight(250);

        TextField textField = new TextField("输入内容");
        VBox vBox = new VBox(textField);
        Scene scene = new Scene(vBox);
        scene.setCursor(Cursor.DEFAULT); // 设置光标

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
