# Stage

- [Stage](#stage)
  - [创建一个 Stage](#创建一个-stage)
  - [展示 Stage](#展示-stage)
    - [show() 和 showAndWait()](#show-和-showandwait)
  - [在 Stage 中添加 Scene](#在-stage-中添加-scene)
  - [设置 title](#设置-title)
  - [设置 position（位置）](#设置-position位置)
  - [设置 width 和 height](#设置-width-和-height)
  - [设置 Modality （模式）](#设置-modality-模式)
  - [Stage Owner](#stage-owner)
  - [Stage Style （风格）](#stage-style-风格)
  - [Stage Full Screen Mode (全屏模式)](#stage-full-screen-mode-全屏模式)
  - [Stage 生命周期](#stage-生命周期)
  - [Stage Keyboard Events (快捷键事件监听)](#stage-keyboard-events-快捷键事件监听)

## 创建一个 Stage

``` java
Stage stage = new Stage();
```

## 展示 Stage

``` java
Stage stage = new Stage();
stage.show()
```

### show() 和 showAndWait()

JavaFX `Stage` 方法 `show()` 和 `showAndWait()` 之间的区别在于，`show()` 使 `Stage` 可见并立即退出 `show()` 方法，而 `showAndWait()` 显示 Stage 对象然后阻塞（停留在 `showAndWait()` 方法）直到舞台关闭。

## 在 Stage 中添加 Scene 

``` java
VBox vBox = new VBox(new Label("A JavaFX Label"));
Scene scene = new Scene(vBox);

Stage stage = new Stage();
stage.setScene(scene);
```

## 设置 title

``` java
stage.setTitle("JavaFX Stage Window Title");
```

## 设置 position（位置）

``` java
Stage stage = new Stage();
stage.setX(50);
stage.setY(50);
```

## 设置 width 和 height

``` java
Stage stage = new Stage();
stage.setWidth(600);
stage.setHeight(500);
```

## 设置 Modality （模式）

``` java
public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX Stage Modality");

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initModality(Modality.WINDOW_MODAL);
//        stage.initModality(Modality.NONE);

        primaryStage.show();
        stage.showAndWait();
    }
```

- 具体而言，initModality 方法接受一个 Modality 枚举类型的参数，用于指定舞台的模态性。Modality 枚举定义了四种模态性：

  - APPLICATION_MODAL：应用程序模态，该舞台阻塞了它的所有者窗口（即它的父窗口）及其所有子窗口。用户必须首先关闭这个模态窗口，才能继续操作应用程序的其他窗口。
  - WINDOW_MODAL：窗口模态，该舞台阻塞了它的所有者窗口（即它的父窗口），但不阻塞它的其他兄弟窗口。用户必须首先关闭这个模态窗口，才能继续操作其所有者窗口及其其他兄弟窗口。
  - NONE：非模态，该舞台不会阻塞任何其他窗口，用户可以同时操作其他窗口和应用程序的其他部分。
  - TRANSPARENT：透明模态，类似于 APPLICATION_MODAL，但允许用户通过点击模态窗口之外的区域来关闭模态窗口。

## Stage Owner

``` java
// 初始化 ownerStage
Stage ownerStage = new Stage();

Stage currentStage = new Stage();
currentStage.initOwner(ownerStage);
```

- `stage.initOwner` 是用于设置 JavaFX 的 Stage（舞台）的所有者的方法。在 JavaFX 中，一个 Stage 可以有一个或多个父级 Stage，通过设置所有者，可以将一个 Stage 关联到另一个 Stage，并指定它们之间的关系。

- 具体而言，`initOwner` 方法接受一个 `Stage` 类型的参数，用于指定当前 Stage 的所有者。指定所有者后，如果所有者 Stage 被最小化、最大化或关闭，它的所有者 Stage 也会相应地受到影响。

- 通常情况下，使用 initOwner 方法可以实现以下几个方面的功能：

  1. 使得当前 Stage 成为另一个 Stage 的子窗口，即在另一个 Stage 上方显示，可以设置模态性、阻塞用户与其他窗口的交互等。
  2. 当另一个 Stage 被关闭时，关闭当前 Stage，使得窗口之间的关闭行为更加协调。
  3. 在多窗口应用程序中，将弹出的对话框或窗口与主窗口关联，使得用户界面更加清晰和易于管理。

## Stage Style （风格）

- Stage您可以通过 JavaFX 的方法设置其样式initStyle()。有一组不同的样式可供您选择：

  - DECORATED：是带有操作系统装饰（标题栏和最小化/最大化/关闭按钮）和白色背景的标准窗口。
  - UNDECORATED：是没有操作系统装饰的标准窗口，但仍具有白色背景。
  - TRANSPARENT：是具有透明背景的未修饰的窗口。
  - UNIFIED：就像一个装饰舞台，只不过装饰区域和主要内容区域之间没有边界。
  - UTILITY：是一扇经过装饰的窗户，但装饰最少。

## Stage Full Screen Mode (全屏模式)

``` java
VBox vbox = new VBox();
Scene scene = new Scene(vbox);

primaryStage.setScene(scene);
// 设置全屏模式
primaryStage.setFullScreen(true);

primaryStage.show();
```

## Stage 生命周期

- Stage 可以发出一些您可以监听的事件。这些舞台事件是：

  - Close Request
  - Hiding
  - Hidden
  - Showing
  - Shown

- 各项监听：

  - Close Stage Event Listener ：您可以侦听 JavaFX Stage 上的关闭事件，这意味着当用户单击 Stage 窗口右上角带有 X 的按钮时，您可以收到通知。如果您需要在主 Stage 窗口关闭后清理一些资源，或者需要停止某些线程等，那么侦听 Stage close 事件可能会很有用。以下是侦听 Stage close 事件的示例：

    ``` java
    primaryStage.setOnCloseRequest((event) -> {
        System.out.println("Closing Stage");
    });
    ```

  - Hiding Stage Event Listener ：您可以将 Stage 隐藏事件侦听器附加到 JavaFX stage。舞台隐藏事件侦听器在<u>隐藏舞台之前、请求隐藏舞台之后调用</u>。以下是将 Stage 隐藏事件侦听器附加到 JavaFX Stage 的示例：

    ``` java
    primaryStage.setOnHiding((event) -> {
        System.out.println("Hiding Stage");
    });
    ```

  - Hidden Stage Event Listener ：您可以将 Stage 隐藏事件侦听器附加到 JavaFX stage。舞台隐藏事件监听器在舞台<u>隐藏后</u>调用。以下是将 Stage 隐藏事件侦听器附加到 JavaFX Stage 的示例：

    ``` java
    primaryStage.setOnHidden((event) -> {
        System.out.println("Stage hidden");
    });
    ```

  - Showing Stage Event Listener ：您可以将显示事件侦听器的舞台附加到 JavaFX 舞台。舞台显示事件侦听器在<u>请求显示舞台之后、舞台显示之前调用</u>。以下是将显示事件侦听器的舞台附加到 JavaFX Stage 的示例：

    ``` java
    primaryStage.setOnShowing((event) -> {
        System.out.println("Showing Stage");
    });
    ```

  - Shown Stage Event Listener ：您可以将 Stage shown 事件侦听器附加到 JavaFX stage。Stage shown 事件侦听器在 Stage <u>显示后调用</u>。以下是将 Stage shown 事件侦听器附加到 JavaFX Stage 的示例：

    ``` java
    primaryStage.setOnShown((event) -> {
        System.out.println("Stage Shown");
    });
    ```

## Stage Keyboard Events (快捷键事件监听)

- 可以在 JavaFX Stage 上监听键盘事件。这样您就可以捕获舞台获得焦点时发生的所有键盘事件。以下是当 JavaFX Stage 获得焦点时侦听键盘上的 ESC 和 Return 键的示例：

``` java

```
