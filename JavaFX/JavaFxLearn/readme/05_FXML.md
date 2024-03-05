# FXML

- [FXML](#fxml)
  - [关于 FXML](#关于-fxml)
  - [FXML 示例](#fxml-示例)
  - [加载 FXML 文件](#加载-fxml-文件)
  - [在 FXML 中导入类](#在-fxml-中导入类)
  - [在 FXML 中创建对象](#在-fxml-中创建对象)
    - [通过 FXML 元素和无参数构造函数创建对象](#通过-fxml-元素和无参数构造函数创建对象)
    - [通过 valueOf() 方法创建对象](#通过-valueof-方法创建对象)
    - [通过工厂方法创建对象](#通过工厂方法创建对象)
  - [FXML 中的属性](#fxml-中的属性)
    - [属性名称匹配](#属性名称匹配)
    - [默认属性](#默认属性)
  - [FXML命名空间](#fxml命名空间)
  - [FXML 元素 ID](#fxml-元素-id)
  - [FXML 事件处理程序](#fxml-事件处理程序)
  - [FXML CSS 样式](#fxml-css-样式)
  - [FXML 控制器类](#fxml-控制器类)
    - [在 FXML 中指定控制器类](#在-fxml-中指定控制器类)
    - [在 FXMLLoader 上设置控制器实例](#在-fxmlloader-上设置控制器实例)
    - [将 JavaFX 组件绑定到控制器字段](#将-javafx-组件绑定到控制器字段)
    - [引用控制器中的方法](#引用控制器中的方法)
    - [从FXMLLoader获取控制器实例](#从fxmlloader获取控制器实例)

## 关于 FXML

- JavaFX FXML是一种 XML 格式，使您能够以类似于在 HTML 中编写 Web GUI 的方式编写 JavaFX GUI。因此， FXML使您能够将 JavaFX 布局代码与应用程序代码的其余部分分开。这会清理布局代码和其余应用程序代码。

- FXML 既可用于组成整个应用程序 GUI 的布局，也可用于组成应用程序 GUI 的一部分，例如表单、选项卡、对话框等的一部分的布局。

## FXML 示例

``` XML
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>

<VBox>
    <children>
        <Label text="Hello World FXML" />
    </children>
</VBox>
```

## 加载 FXML 文件

``` java
public void start(Stage primaryStage) throws IOException {
        // 加载 FXML 文件
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HelloWorld.fxml"));
        VBox vbox = (VBox) fxmlLoader.load();
        vbox.getChildren().add(new Label("add label"));


        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(250);
        primaryStage.show();
    }
```

## 在 FXML 中导入类

``` XML
<?import javafx.scene.layout.VBox?>
```

## 在 FXML 中创建对象

- FXML 可以创建 JavaFX GUI 对象以及非 JavaFX 对象。在 FXML 中创建对象的方法有多种。在下面的部分中，我们将看到这些选项是什么。

### 通过 FXML 元素和无参数构造函数创建对象

- 在 FXML 中创建对象的最简单方法是通过 FXML 文件中的 FXML 元素。FXML 中使用的元素名称与不带包名称的 Java 类名称相同。通过 FXML 导入语句导入类后，您可以使用其名称作为 FXML 元素名称。

- 在以下示例中，元素名称VBox和Label是有效的，因为这两个类是在 FXML 文件的前面使用 import 语句声明的：

``` java
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>

<VBox>
    <children>
        <Label text="Hello world FXML"/>
    </children>
</VBox>
```

### 通过 valueOf() 方法创建对象

- `valueOf()` 在 FXML 中创建对象的另一种方法是在要创建对象的类中 *调用静态方法*。通过方法创建对象的方法是在 FXML 元素中valueOf()插入 属性。value这是一个例子：

- Java 类

    ``` java
    // 通过 valueOf() 方法创建对象
    public class CreateObjByValueOf {

        public static CreateObjByValueOf valueOf(String value) {
            return new CreateObjByValueOf(value);
        }

        private String value;

        public CreateObjByValueOf(String value) {
            this.value = value;
        }
    }
    ```

- FXML 文件

    ``` XML
    <?xml version="" encoding="utf-8" ?>
    <?import pers.xgo.javafxlearn.d05.CreateObjByValueOf?>
    <CreateObjByValueOf value="The Value" />
    ```

### 通过工厂方法创建对象

- Java 类

    ``` java
    // 通过工厂方法创建对象
    public class CreateObjByFactory {
        public static CreateObjByFactory instance() {
            return new CreateObjByFactory();
        }
    }
    ```

- FXML 文件

    ``` xml
    <?xml version="1.0" encoding="utf-8" ?>
    <?import pers.xgo.javafxlearn.d05.CreateObjByFactory?>
    <CreateObjByFactory
        xmlns="http://javafx.com/javafx"
        xmlns:fx="http://javafx.com/fxml"
        fx:factory="instance"/>
    ```

- 要调用另一个工厂方法来创建对象，您需要插入一个fx:factory属性。该属性的值fx:factory应该是要调用的工厂方法的名称。这是一个例子：
- 注意instance()方法。该方法是从fx:factory 上面的 FXML 片段中的属性引用的。
- 请注意，工厂方法必须是<u>无参方法</u>才能从属性调用它fx:factory。

## FXML 中的属性

- 一些 JavaFX 对象具有属性。事实上，他们中的大多数人都是这样做的。您可以通过两种方式设置属性的值。第一种方法是使用 XML 属性来设置属性值。第二种方法是使用嵌套的 XML 元素来设置属性值。

- 为了更好地理解如何在 FXML 元素中设置属性，让我们看一个示例：

``` xml
<?xml version="1.0" encoding="utf-8"?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>

<VBox spacing="20" >
    <children>
        <Label text="Line 1" />
        <Label text="Line 2" />
    </children>
</VBox>
```

- 此示例显示 3 个属性示例。
  - 第一个示例是元素spacing中的属性 VBox。属性中设置的值spacing作为参数传递给基于该元素创建的对象setSpacing()的方法 。 VBoxVBox
  - 第二个例子是children元素内部嵌套的元素VBox。该元素对应于类getChildren()的方法VBox。嵌套在元素内的元素children将转换为 JavaFX 组件，这些组件将添加到从 父元素表示的对象getChildren()的方法获得的集合中。 VBoxVBox
  - 第三个示例是text嵌套Label在children. 属性的值text将作为参数传递给元素创建的对象setText()的属性 。 LabelLabel

### 属性名称匹配

- FXML 将“属性”视为通过 `getter` 和 `setter` 访问的成员变量。例如 `getText()`和`setText()`。

- 正如您从上一节的示例中看到的，JavaFX 类的属性名称通过以下方式与属性和元素名称进行匹配：
  - 删除属性名称中的任何获取/设置。
  - 将属性名称的第一个剩余字符转换为小写。

- 因此，`getter` 方法`getChildren()`将首先简化为 `Children` ，然后简化为 `children`。同样，`setter` 方法`setText`将简化为`Text`，然后简化为`text`。

### 默认属性

- JavaFX 组件可以具有默认属性。这意味着，如果 FXML 元素包含未嵌套在属性元素内的子元素，则假定这些子元素属于默认属性。

- 让我们看一个例子。该类VBox具有该`children`属性作为默认属性。这意味着我们可以省略该`children`元素。因此，这个 FXML：

``` xml
<?xml version="1.0" encoding="utf-8"?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>

<VBox spacing="20" >
    <children>
        <Label text="Line 1" />
        <Label text="Line 2" />
    </children>
</VBox>
```

可以缩短为：

``` xml
<?xml version="1.0" encoding="utf-8"?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>

<VBox spacing="20" >
    <Label text="Line 1" />
    <Label text="Line 2" />
</VBox>
```

- 然后假定这两个`Label`元素属于 的`默认属性VBox`，即 属性`children`。

- 默认属性用 `JavaFX` 注释进行标记，`@DefaultProperty(value="propertyName")` 其中值是应作为默认属性的属性的名称。例如， `@DefaultProperty(value="children")` 声明将使该`children`属性成为默认属性。

## FXML命名空间

- FXML 有一个命名空间，您可以在 FXML 文件的根元素上设置。某些 FXML 属性（如属性）需要 FXML 命名空间fx:id（请参阅本 FXML 教程的下一部分）。

- 在 FXML 文件的根元素上设置 FXML 命名空间如下所示：

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.VBox?>

<VBox xmlns="http://javafx.com/javafx"
    xmlns:fx="http://javafx.com/fxml">
</VBox>
```

## FXML 元素 ID

- 您可以将 ID 分配给 FXML 元素。 这些 ID 可用于引用 FXML 文件中其他位置的 FXML 元素。 为 FXML 元素指定 ID 是通过 FXML 命名空间中的 id 属性完成的。 以下是为 FXML 元素指定 ID 的示例：

``` xml
<?xml version="1.0" encoding="utf-8"?>

<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>
<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml">
    <Label fx:id="lavle1" text="Line 1"/>
</VBox>
```

- 请注意 Label 元素中的属性声明 fx:id="label1"。 该属性声明该 Label 元素的 ID。 现在，可以通过 FXML 文档中其他位置的 ID label1 引用此特定 Label 元素。 例如，此 ID 可用于引用 CSS 中的 FXML 元素。 您将在本 FXML 教程后面看到通过 ID 引用 FXML 元素的示例。

## FXML 事件处理程序

- 可以从定义 JavaFX 对象的 FXML 文件内部对 JavaFX 对象设置事件处理程序。 您可能更喜欢在 Java 代码中设置高级事件处理程序，但对于简单的事件处理程序，从 FXML 中设置它们可能也不错。

- 为了定义事件处理程序，您需要使用脚本元素。 FXML 脚本元素的外观如下：

``` xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox xmlns="http://javafx.com/javafx"
            xmlns:fx="http://javafx.com/fxml"
            prefHeight="400.0" prefWidth="600.0" >
    <Label fx:id="label" text="Button not click"/>
    <Button fx:id="button" text="Click me!"  onAction="reactToClick()"/>

    <!-- fx:script 已被废弃 -->
    <fx:script>
        function reactToClick(){
            label.setText("Button clicked")
        }
    </fx:script>
</VBox>

```

- JavaFX Script：JavaFX 最初提供的脚本语言，与 JavaFX 紧密集成。它具有类似于 Java 的语法，但添加了一些特定于 JavaFX 的语法和功能。尽管 JavaFX Script 已经被弃用，但仍然可以在一些旧的项目中使用。

## FXML CSS 样式

- 可以对 FXML 文件中声明的 JavaFX 组件进行样式设置。您可以通过 style在 FXML 元素中嵌入一个元素来实现此目的。以下是在 FXML 文件中设置 JavaFX 按钮 CSS 样式的示例：

``` xml
<?xml version="1.0" encoding="UTF-8"?>


<?import javafx.scene.control.Button?>
<?import javafx.scene.layout.VBox?>
<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      prefHeight="400.0" prefWidth="600.0">


    <Button fx:id="button" text="Click me!" style="
        -fx-min-width: 90px;
        -fx-min-height: 55px;
        -fx-border-width: 3px;
        -fx-border-color: red;
    "></Button>
</VBox>
```

## FXML 控制器类

- 您可以为 FXML 文档设置控制器类。 FXML 控制器类可以将 FXML 文件中声明的 GUI 组件绑定在一起，使控制器对象充当中介（设计模式）。

- 有两种方法可以为 FXML 文件设置控制器。 设置控制器的
  - 第一种方法是在 FXML 文件中指定它。 
  - 第二种方法是在用于加载 FXML 文档的 FXMLLoader 实例上设置控制器类的实例。 

``` xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.VBox?>
<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      prefHeight="400.0"
      prefWidth="600.0"
      alignment="CENTER"
      fx:controller="pers.xgo.javafxlearn.d05.FXMLController">
    <Label fx:id="label1" text="Button not click"/>
    <Button fx:id="button" text="Click me!" onAction="#reactToClick"/>
</VBox>

```

``` java
public class FXMLController extends Application {

    @FXML
    private Label label1;
    @FXML
    private Button button;

    public static void main(String[] args) {
        System.out.println(FXMLDemo01.class.getResource(""));
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLDemo01.class.getResource("FXMLController.fxml"));
        VBox vbox = fxmlLoader.load();
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(250);
        primaryStage.show();
    }

    @FXML
    public void reactToClick(){
        label1.setText("Button clicked");
    }
}
```

### 在 FXML 中指定控制器类

- 如上面的代码，控制器类是使用 `fx:controller` 属性在 FXML 文件的根元素中指定的。


### 在 FXMLLoader 上设置控制器实例

- 在 上设置控制器实例时，FXMLLoader您必须首先创建控制器类的实例，然后在 上设置该实例FXMLLoader。以下是在实例上设置控制器实例的示例FXMLLoader：

``` java
MyFxmlController controller = new MyFxmlController();

FXMLLoader loader = new FXMLLoader();
loader.setController(controller);
```

### 将 JavaFX 组件绑定到控制器字段

- 您可以将 FXML 文件中的 JavaFX 组件绑定到控制器类中的字段。 要将 JavaFX 组件绑定到控制器类中的字段，您需要为 JavaFX 组件的 FXML 元素提供一个 `fx:id` 属性，该属性具有要绑定到的控制器`字段的名称`作为值。 这是一个示例控制器类：

``` java
//  <Label fx:id="label1" text="Button not click"/>
// fx:id="label1" 对应：label1
@FXML
private Label label1;
```


### 引用控制器中的方法

- 可以从 FXML 引用控制器实例中的方法。例如，您可以将 JavaFX GUI 组件的事件绑定到控制器的方法。以下是将 JavaFX 组件的事件绑定到控制器中的方法的示例：

``` java
// <Button fx:id="button" text="Click me!" onAction="#reactToClick"/>
// onAction="#reactToClick" 对应 reactToClick()， 注意添加 # 号
@FXML
public void reactToClick(){
    label1.setText("Button clicked");
}
```

- `@FXML` 此注释将该方法标记为 FXML 绑定的目标。

### 从FXMLLoader获取控制器实例

- 一旦FXMLLoader实例加载了 FXML 文档，您就可以通过该方法获取对控制器实例的引用FXMLLoader getController()。这是一个例子：

``` java
MyFxmlController controllerRef = loader.getController();
```
