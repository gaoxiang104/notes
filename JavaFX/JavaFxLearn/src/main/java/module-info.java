module pers.xgo.javafxlearn {
    requires javafx.controls;
    requires javafx.fxml;

    opens pers.xgo.javafxlearn to javafx.fxml;
    exports pers.xgo.javafxlearn;
}