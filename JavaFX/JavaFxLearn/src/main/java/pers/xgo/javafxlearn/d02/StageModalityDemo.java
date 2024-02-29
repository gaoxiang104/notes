package pers.xgo.javafxlearn.d02;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 测试 Modality
 */
public class StageModalityDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Stage Modality");

        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initModality(Modality.WINDOW_MODAL);
//        stage.initModality(Modality.NONE);

        // 设置所属
        stage.initOwner(primaryStage);

        // 风格
        primaryStage.initStyle(StageStyle.DECORATED);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.initStyle(StageStyle.UNIFIED);
//        primaryStage.initStyle(StageStyle.UTILITY);

        stage.initStyle(StageStyle.UNIFIED);

        primaryStage.show();
        stage.showAndWait();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
