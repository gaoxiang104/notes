package pers.xgo.javafxlearn.d02;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class StageKeyboardDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stage Keyboard Events");

        primaryStage.setWidth(300);
        primaryStage.setHeight(200);

        // 禁用 JavaFX 自带的键盘事件处理
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> keyEvent.consume());

        try {
            // 注册全局键盘监听器
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("Failed to register native hook");
            ex.printStackTrace();
            System.exit(1);
        }

        // 设置监听器
        GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
            @Override
            public void nativeKeyPressed(NativeKeyEvent e) {
                System.out.println(String.format("key code : %s", e.getKeyCode()));
                // 将 NativeKeyEvent 转换成 JavaFX 的 KeyCode
                KeyCode keyCode = convertKeyCode(e.getKeyCode());
                if (keyCode != null) {
                    switch (keyCode) {
                        case ESCAPE:
                            Platform.runLater(() -> {
                                // 在 JavaFX 应用程序线程上执行的代码
                                primaryStage.close(); // 关闭主舞台
                            });
                            break;
                        case ENTER:
                            Platform.runLater(() -> {
                                // 在 JavaFX 应用程序线程上执行的代码
                                primaryStage.setWidth(primaryStage.getWidth() * 2);
                            });
                            break;
                        default:
                            System.out.println("Unrecognized key");
                    }
                }
            }

            @Override
            public void nativeKeyReleased(NativeKeyEvent e) {
                // 不需要处理释放事件
            }

            @Override
            public void nativeKeyTyped(NativeKeyEvent e) {
                // 不需要处理键入事件
            }

            // 将 JNativeHook 中的 KeyCode 转换成 JavaFX 的 KeyCode
            private KeyCode convertKeyCode(int nativeKeyCode) {
                switch (nativeKeyCode) {
                    case NativeKeyEvent.VC_ESCAPE:
                        return KeyCode.ESCAPE;
                    case NativeKeyEvent.VC_ENTER:
                        return KeyCode.ENTER;
                    // 添加其他按键的转换逻辑
                    default:
                        return null;
                }
            }
        });

        primaryStage.show();
    }
}
