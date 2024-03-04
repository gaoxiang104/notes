module pers.xgo.javafxlearn {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.github.kwhat.jnativehook;

    opens pers.xgo.javafxlearn to javafx.fxml;

    exports pers.xgo.javafxlearn;
    exports pers.xgo.javafxlearn.learn001;
    exports pers.xgo.javafxlearn.learn002;
    exports pers.xgo.javafxlearn.d02;
    exports pers.xgo.javafxlearn.d03;
    exports pers.xgo.javafxlearn.d04;
    exports pers.xgo.javafxlearn.d05;
}