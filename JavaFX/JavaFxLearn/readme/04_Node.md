# Node

- [Node](#node)
  - [关于 Node](#关于-node)
  - [Node 基础知识](#node-基础知识)
  - [Node 属性](#node-属性)
  - [Node 坐标系](#node-坐标系)
  - [Node 边界框](#node-边界框)
  - [layoutX 和 layoutY](#layoutx-和-layouty)
  - [Preferred Width 和 Height](#preferred-width-和-height)
  - [最小宽高 Minimum Width and Height](#最小宽高-minimum-width-and-height)
  - [最大宽高 Maximum Width and Height](#最大宽高-maximum-width-and-height)
  - [用户数据 User Data](#用户数据-user-data)
  - [Items or Child Nodes](#items-or-child-nodes)
  - [JavaFX 属性示例](#javafx-属性示例)

## 关于 Node

- JavaFX `Node` 类 `javafx.scene.Node` 是添加到 JavaFX 场景图(Scene Graph) 的所有组件的基类（超类）。 JavaFX Node 类是*抽象的*，因此您只需将 Node 类的子类添加到场景图中。 场景图中的所有 JavaFX Node 实例共享一组由 JavaFX Node 类定义的通用属性。 本 JavaFX Node 教程将介绍这些常见属性。

## Node 基础知识

- 每个 JavaFX `Node`（子类）实例只能添加到 JavaFX 场景图中一次。换句话说，每个 Node 实例只能出现在场景图中的一个位置。如果您尝试多次将相同的 Node 实例或 Node 子类实例添加到场景图中，JavaFX 将抛出异常！

- JavaFX `Node` 有时可以有子项 - 也称为 `children`。给定的 Node 实例是否可以有 `children` 取决于具体的 Node 子类。JavaFX Node 的一个特殊子类 `Parent` 用于建模可以有子节点的 Node 实例。因此，可以有子节点的 Node 实例通常是 `Parent` 类的子节点，而不是直接的 Node 类。

- JavaFX Stage和JavaFX Scene类不是 JavaFX Node 类的子类。虽然这两个类用于显示 JavaFX 场景图，但只有添加到 JavaFX 场景实例的 Node 实例才被视为 JavaFX 场景图的一部分。

- 将 Node 实例附加到场景图后，仅允许 JavaFX 应用程序线程（管理 JavaFX 场景图的线程）修改 Node 实例。

## Node 属性

- JavaFX Node 类以及 Node 的所有子类都具有以下共同属性：

  - 笛卡尔坐标系
  - 由以下分隔的边界框：
    - 布局边界（Layout bounds）
    - 本地范围（Bounds in local）
    - 父级的界限（Bounds in parent）
  - layoutX
  - layoutY
  - 首选身高（Preferred height）
  - 首选宽度（Preferred width）
  - 最低高度（Minimum height）
  - 最小宽度（Minimum width）
  - 最大高度（Maximum height）
  - 最大宽度（Maximum width）
  - 用户数据（User data）
  - Items (Child nodes)

## Node 坐标系

- 每个 JavaFX Node 都有自己的笛卡尔坐标系。与常规笛卡尔坐标系的唯一区别是 Y 轴是相反的。这意味着，坐标系的原点位于坐标系的左上角。随着 Y 值增加，该点从坐标系顶部向下移动。Y 轴的这种反转在 2D 图形坐标系中是正常的。

- JavaFX 节点可能具有负 X 和 Y 坐标。

- 每个节点都有自己的坐标系。该坐标系用于在父节点内定位子节点实例，或者在 JavaFX Canvas 上绘图时使用。这意味着，作为另一个节点的子节点的节点都有自己的坐标系，以及其父节点坐标系内的位置（X，Y）。

## Node 边界框

JavaFX 节点有一个边界框。JavaFX 节点的边界框是围绕节点形状的逻辑框。完整的节点位于边界框内 - 从图形上看就是如此。换句话说，节点的所有角和边缘都包含在边界框内，并且节点周围没有额外的空间，除非通过效果、填充或应用于节点的其他内容添加。

实际上，一个 Node 有 3 个边界框：

| name | Description |
|-----|-----|
| 布局边界（Layout bounds） | 节点在其自己的坐标空间中的边界 - 没有应用任何效果、剪辑或变换。 |
| 本地范围（Bounds in local） | 节点在其自己的坐标空间中的边界 - 应用了效果和剪辑，但没有转换。 |
| 父级的界限（Bounds in parent） | 节点在其父坐标空间中的边界 - 应用了效果、剪辑和变​​换。 |

每个边界框尺寸都可以从具有相同名称的相应属性中读取，这意味着名为`layoutBounds`、`boundsInLocal` 和 `boundsInParent`。

边界boundsInParent框被父节点（Parent）用来布局其子节点。父节点需要知道总空间，包括节点的所有效果、剪辑和变​​换，以便能够为其分配空间。

## layoutX 和 layoutY

- `layoutX` 和  `layoutY` 属性是 JavaFX Node对象的包含其父对象内部Node的X和Y。
- 换句话说，`layoutX` 和  `layoutY` 是从父节点的0,0（origo）开始的偏移。

``` java
node.setLayoutX(100);
node.setLayoutY(100);
```

## Preferred Width 和 Height 

- `Preferred Width` 和 `Preferred Height` 属性，它们用于指定节点在布局过程中希望具有的首选宽度和高度。
- `Preferred Width` 和 `Preferred Height` 属性告诉布局管理器（例如布局容器、父节点等）节点希望在没有明确约束的情况下具有的理想大小。布局管理器可以根据这些首选尺寸以及其他因素（例如布局约束、父节点的大小等）来确定节点的实际大小和位置。
- `Preferred Width` 和 `Preferred Height` 属性用于指定节点在布局过程中的首选大小，但最终的大小可能会受到其他因素的影响。

``` java
node.setPrefWidth(100);
node.setPrefHeight(100);
```

## 最小宽高 Minimum Width and Height 

``` java
node.setMinWidth(50);
node.setMinHeight(50);
```

## 最大宽高 Maximum Width and Height

``` java
node.setMaxWidth(50);
node.setMaxHeight(50);
```

## 用户数据 User Data

- 在 JavaFX 中，每个节点（Node）都有一个名为 User Data 的属性，它允许开发人员将任意对象附加到节点上。User Data 属性允许开发人员在节点上存储任何自定义数据或对象，以便在应用程序中轻松地访问和管理。

``` java
node.setUserData(new MyObject("Hey - some data"));
```

## Items or Child Nodes

- `getItems()` 方法通常用于获取具有列表功能的节点中的数据集合，而 `getChildren()` 方法通常用于获取容器节点中的子节点集合。这两种方法都是用于访问节点的子元素，但它们的应用场景和用法略有不同。

## JavaFX 属性示例

[PropertyDemo.java](../src/main/java/pers/xgo/javafxlearn/d04/PropertyDemo.java)