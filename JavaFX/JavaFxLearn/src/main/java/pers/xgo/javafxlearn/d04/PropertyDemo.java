package pers.xgo.javafxlearn.d04;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PropertyDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        ReadOnlyDoubleProperty widthProperty = pane.widthProperty();

        widthProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldVal, Number newVal) {
                System.out.println(String.format("widthProperty changed form %s to %s", oldVal, newVal));
            }
        });

        DoubleProperty prefWidthProperty = pane.prefWidthProperty();
        prefWidthProperty.addListener((observableValue, oldVal, newVal) ->
                System.out.println(String.format("prefWidthProperty changed form %s to %s", oldVal, newVal)));

        prefWidthProperty.set(123);

        Scene scene = new Scene(pane,1024,800, true);

        primaryStage.setScene(scene);
        primaryStage.setTitle("PropertyDemo");

        primaryStage.show();
    }
}
