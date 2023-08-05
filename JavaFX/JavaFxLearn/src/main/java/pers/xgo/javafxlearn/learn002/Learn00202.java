package pers.xgo.javafxlearn.learn002;

import javafx.application.Application;
import javafx.stage.Stage;

// application的生命周期

public class Learn00202 extends Application {

    public static void main(String[] args) {
        System.out.println("main() -> " + Thread.currentThread().getName());
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("init() -> " + Thread.currentThread().getName());
        super.init();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop() -> " + Thread.currentThread().getName());
        super.stop();
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start() -> " + Thread.currentThread().getName());
        stage.setTitle("My first JavaFX02");
        stage.show();
    }

}
/* OUTPUT:
main() -> main
init() -> JavaFX-Launcher
start() -> JavaFX Application Thread
stop() -> JavaFX Application Thread
 */