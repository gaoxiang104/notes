module pers.xgo.javafx-learn {
    requires javafx.controls;
    requires javafx.fxml;

    opens pers.xgo.javafx-learn to javafx.fxml;
    exports pers.xgo.javafx-learn;
}