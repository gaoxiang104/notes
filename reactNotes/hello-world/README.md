# React 核心概念

## 1、React 是什么？

React 是一个用于构建用户界面的 JavaScript 库。你可以在首页或教程中学习什么是 React。

* **'声明式':** React 使创建交互式 UI 变得轻而易举。为你应用的每一个状态设计简洁的视图，当数据变动时 React 能高效更新并渲染合适的组件。以声明式编写 UI，可以让你的代码更加可靠，且方便调试。

* **'组件化':** 构建管理自身状态的封装组件，然后对其组合以构成复杂的 UI。由于组件逻辑使用 JavaScript 编写而非模板，因此你可以轻松地在应用中传递数据，并保持状态与 DOM 分离。

* **'一次学习，跨平台编写':** 无论你现在使用什么技术栈，在无需重写现有代码的前提下，通过引入 React 来开发新功能。React 还可以使用 Node 进行服务器渲染，或使用 React Native 开发原生移动应用。

## 2、安裝

### 2.1、在网站中添加 React

React 在设计之初就可以被渐进式适配，并且**你可以根据需要选择性地使用 React**。可能你只想在现有页面中“局部地添加交互性”。使用 React 组件是一种不错的方式。

### 2.1.1、一分钟用上 React

* step1: 添加一个 DOM 容器到 HTML。在 <body> 标签内的任意位置放置一个“容器” `<div>`。根据需要，你可以在一个页面上放置多个独立的 DOM 容器。它们通常是空标签 —— React 会替换 DOM 容器内的任何已有内容。

``` html
<div id="root"></div>
```

* step2: 添加 Script 标签。用到以下三个包：

  * React - the React top level API.
  * React DOM - adds DOM-specific methods.
  * Babel - a JavaScript compiler that lets us use ES6+ in old browsers.

``` html
    <!-- 加载 React。-->
    <!-- 注意: 部署时，将 "development.js" 替换为 "production.min.js"。-->
    <script src="https://unpkg.com/react@17/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@17/umd/react-dom.development.js" crossorigin></script>

    <!-- 可以在任何 <script> 标签内使用 JSX，方法是在为其添加 type="text/babel" 属性。-->
    <script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>
```

* step3: 创建一个 React 组件

``` html
    <script type="text/babel">
        class App extends React.Component { // 创建React组件
            render() {
                return (
                    <h1>一分钟添加 React</h1>
                );
            }
        }

        // 最后，我们将使用 React DOM render() 方法将我们创建的 App 类渲染到 HTML 的根 div 中。
        ReactDOM.render(<App />, document.getElementById('root'));
    </script>
```

### 2.2、创建新的 React 应用

