# Scene

- [Scene](#scene)
  - [关于 Scene](#关于-scene)
  - [创建 Scene](#创建-scene)
  - [设置 Scene 到 Stage](#设置-scene-到-stage)
  - [Scene graph](#scene-graph)
  - [Scene Mouse Cursor （鼠标光标）](#scene-mouse-cursor-鼠标光标)

## 关于 Scene

- JavaFX `Scene（场景）` 对象是 JavaFX `Scene graph (场景图)` 的根。 换句话说，JavaFX `Scene`包含所有可视化 JavaFX GUI 组件。 JavaFX `Scene`由 javafx.scene.Scene 类表示。 `Scene`对象必须在 JavaFX Stage 上设置为可见。 在本 JavaFX Scene 教程中，我将向您展示如何创建 Scene 对象并向其添加 GUI 组件。

## 创建 Scene

``` java
VBox  vBox  = new VBox();
Scene scene = new Scene(vBox);
```

## 设置 Scene 到 Stage

``` java
VBox vBox = new VBox(new Label("A JavaFX Label"));
Scene scene = new Scene(vBox);

Stage stage = new Stage();
stage.setScene(scene);
```

## Scene graph

- JavaFX 的场景图（Scene Graph）是一个用于构建和管理用户界面的层次结构。它是 JavaFX UI 渲染和布局的基础，所有的 UI 元素都是在场景图中创建、管理和渲染的。

## Scene Mouse Cursor （鼠标光标）

- 设置鼠标光标

``` java
scene.setCursor(Cursor.OPEN_HAND);
```

- 鼠标光标的类型：

  - Cursor.OPEN_HAND
  - Cursor.CLOSED_HAND
  - Cursor.CROSSHAIR
  - Cursor.DEFAULT
  - Cursor.HAND
  - Cursor.WAIT
  - Cursor.H_RESIZE
  - Cursor.V_RESIZE
  - Cursor.MOVE
  - Cursor.TEXT