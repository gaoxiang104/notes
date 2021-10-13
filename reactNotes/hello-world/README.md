# React 基础知识

- [React 基础知识](#react-基础知识)
  - [1、React 是什么？](#1react-是什么)
  - [2、安裝](#2安裝)
    - [2.1、在网站中添加 React](#21在网站中添加-react)
    - [2.1.1、一分钟用上 React](#211一分钟用上-react)
    - [2.1.2、CDN 链接](#212cdn-链接)
  - [2.2、创建新的 React 应用](#22创建新的-react-应用)
    - [2.2.1、推荐的工具链](#221推荐的工具链)
    - [2.2.2、Create React App](#222create-react-app)
      - [2.2.2.1、扩展 Create React App 的 Webpack 配置](#2221扩展-create-react-app-的-webpack-配置)
  - [3、核心概念](#3核心概念)
    - [3.1、HelloWorld](#31helloworld)
    - [3.2、JSX 简介](#32jsx-简介)
      - [3.2.1、为什么使用 JSX？](#321为什么使用-jsx)
      - [3.2.2、在 JSX 中嵌入表达式](#322在-jsx-中嵌入表达式)
      - [3.2.3、JSX 也是一个表达式](#323jsx-也是一个表达式)
      - [3.2.4、JSX 中指定属性](#324jsx-中指定属性)
      - [3.2.5、使用 JSX 指定子元素](#325使用-jsx-指定子元素)
      - [3.2.5、JSX 防止注入攻击](#325jsx-防止注入攻击)
      - [3.2.6、JSX 表示对象](#326jsx-表示对象)
    - [3.3、元素渲染](#33元素渲染)
      - [3.3.1、将一个元素渲染为 DOM](#331将一个元素渲染为-dom)
      - [3.3.2、更新已渲染的元素](#332更新已渲染的元素)
      - [3.3.3、React 只更新它需要更新的部分](#333react-只更新它需要更新的部分)

## 1、React 是什么？

React 是一个用于构建用户界面的 JavaScript 库。你可以在首页或教程中学习什么是 React。

- **'声明式':** React 使创建交互式 UI 变得轻而易举。为你应用的每一个状态设计简洁的视图，当数据变动时 React 能高效更新并渲染合适的组件。以声明式编写 UI，可以让你的代码更加可靠，且方便调试。

- **'组件化':** 构建管理自身状态的封装组件，然后对其组合以构成复杂的 UI。由于组件逻辑使用 JavaScript 编写而非模板，因此你可以轻松地在应用中传递数据，并保持状态与 DOM 分离。

- **'一次学习，跨平台编写':** 无论你现在使用什么技术栈，在无需重写现有代码的前提下，通过引入 React 来开发新功能。React 还可以使用 Node 进行服务器渲染，或使用 React Native 开发原生移动应用。

## 2、安裝

### 2.1、在网站中添加 React

React 在设计之初就可以被渐进式适配，并且**你可以根据需要选择性地使用 React**。可能你只想在现有页面中“局部地添加交互性”。使用 React 组件是一种不错的方式。

### 2.1.1、一分钟用上 React

- step1: 添加一个 DOM 容器到 HTML。在 `<body>` 标签内的任意位置放置一个“容器” `<div>`。根据需要，你可以在一个页面上放置多个独立的 DOM 容器。它们通常是空标签 —— React 会替换 DOM 容器内的任何已有内容。

``` html
<div id="root"></div>
```

- step2: 添加 Script 标签。用到以下三个包：

  - React - the React top level API.
  - React DOM - adds DOM-specific methods.
  - Babel - a JavaScript compiler that lets us use ES6+ in old browsers.

``` html
    <!-- 加载 React。-->
    <!-- 注意: 部署时，将 "development.js" 替换为 "production.min.js"。-->
    <script src="https://unpkg.com/react@17/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@17/umd/react-dom.development.js" crossorigin></script>

    <!-- 可以在任何 <script> 标签内使用 JSX，方法是在为其添加 type="text/babel" 属性。-->
    <script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>
```

- step3: 创建一个 React 组件

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

### 2.1.2、CDN 链接

```html

<!-- 开发环境，不适合用于生产环境。 -->
<script crossorigin src="https://unpkg.com/react@17/umd/react.development.js"></script>
<script crossorigin src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"></script>
<!-- 生产环境 -->
<script crossorigin src="https://unpkg.com/react@17/umd/react.production.min.js"></script>
<script crossorigin src="https://unpkg.com/react-dom@17/umd/react-dom.production.min.js"></script>
```

## 2.2、创建新的 React 应用

使用集成的工具链，以实现最佳的用户和开发人员体验。

### 2.2.1、推荐的工具链

React 团队主要推荐这些解决方案：

- 如果你是在学习 React 或创建一个新的单页应用，请使用 [Create React App](https://github.com/facebookincubator/create-react-app)。
- 如果你是在用 Node.js 构建服务端渲染的网站，试试 [Next.js](https://nextjs.org/)。
- 如果你是在构建内容主导的静态网站，试试 [Gatsby](https://www.gatsbyjs.org/)。
- 如果你是在打造组件库或将 React 集成到现有代码仓库，尝试[更灵活的工具链](https://zh-hans.reactjs.org/docs/create-a-new-react-app.html#more-flexible-toolchains)。

### 2.2.2、Create React App

`Create React App` 是一个用于学习 React 的舒适环境，也是用 React 创建新的单页应用的最佳方式。

它会配置你的开发环境，以便使你能够使用最新的 JavaScript 特性，提供良好的开发体验，并为生产环境优化你的应用程序。你需要在你的机器上安装 Node >= 14.0.0 和 npm >= 5.6。要创建项目，请执行：

```shell
npx create-react-app my-app
cd my-app && npm start
```

Create React App 不会处理后端逻辑或操纵数据库；它只是创建一个前端构建流水线（build pipeline），所以你可以使用它来配合任何你想使用的后端。它在内部使用 Babel 和 webpack，但你无需了解它们的任何细节。

当你准备好部署到生产环境时，执行 `npm run build` 会在 `build` 文件夹内生成你应用的优化版本。你能从[它的 README](https://github.com/facebookincubator/create-react-app#create-react-app--) 和[用户指南](https://facebook.github.io/create-react-app/)了解 Create React App 的更多信息。

#### 2.2.2.1、扩展 Create React App 的 Webpack 配置

Create React App已经封装了webpack 配置，如果要修改 webpack 配置该怎么办？办法有很多种，搜索了一下主流的做法，是使用 [react-app-rewired](https://github.com/timarney/react-app-rewired) + [customize-cra](https://github.com/arackaf/customize-cra) 进行修改 webpack 配置。

- `react-app-rewired`：此工具可以在不 'eject' 也不创建额外 react-scripts 的情况下修改 create-react-app 内置的 webpack 配置，然后你将拥有 create-react-app 的一切特性，且可以根据你的需要去配置 webpack 的 plugins, loaders 等。

- `customize-cra`：利用react-app-rewired的config-overrides.js文件。在`override`方法中调用`customize-cra`提供的API，可以很容易地修改底层配置对象（webpack，webpack-dev-server，babel等）。

安装步骤：

- step1：安装 `react-app-rewired` 和 `customize-cra`；

``` shell
npm install react-app-rewired customize-cra --save-dev
```

- step2：创建`config-overrides.js`文件，在`package.json`同级目录下；

``` javascript
module.exports = function override(config, env) {
  //do stuff with the webpack config...
  return config;
}
```

- step3：修改`package.json`中的`scripts`命令；

```json
  /* package.json */

  "scripts": {
-   "start": "react-scripts start",
+   "start": "react-app-rewired start",
-   "build": "react-scripts build",
+   "build": "react-app-rewired build",
-   "test": "react-scripts test",
+   "test": "react-app-rewired test",
    "eject": "react-scripts eject"
}
```

- step4：使用`customize-cra`，添加`img-loader`插件，修改`config-overrides.js`

```shell
npm install img-loader --save-dev
```

``` javascript
/* config-overrides.js */
const {
    override,
    disableEsLint,
    addWebpackModuleRule,
    overrideDevServer,
    watchAll
} = require("customize-cra");

module.exports = {
    webpack: override(
        // usual webpack plugin
        disableEsLint(),
        // Adds the provided rule to the webpack config's module.rules array.
        addWebpackModuleRule(
            { // img-loader
                test: /\.(jpe?g|png|gif|svg)$/i,
                use: [
                    'url-loader?limit=10000',
                    'img-loader'
                ]
            }
        ),
    ),
    devServer: overrideDevServer(
        // dev server plugin
        watchAll()
    )
};

```

更多的`customize-cra`的方法可以查阅[官方API](https://github.com/arackaf/customize-cra/blob/master/api.md)。

## 3、核心概念

### 3.1、HelloWorld

最简易的 React 示例如下：

``` javascript
ReactDOM.render(
  <h1>Hello, world!</h1>,
  document.getElementById('root')
);
```

### 3.2、JSX 简介

它被称为 JSX，是一个 JavaScript 的语法扩展。我们建议在 React 中配合使用 JSX，JSX 可以很好地描述 UI 应该呈现出它应有交互的本质形式。JSX 可能会使人联想到模板语言，但它具有 JavaScript 的全部功能。

#### 3.2.1、为什么使用 JSX？

React认为渲染逻辑本质上与其他UI逻辑内在耦合，比如，在UI中需要绑定处理事件、在某些时刻状态发生变化时需要通知到UI，以及需要在UI中展示准备好的数据。

React并没有采用将标记与逻辑进行分离到不同文件这种人为地分离方式，而是通过将二者共同存放在称之为“组件”的松散耦合单元之中，来实现[关注点分离]{<https://en.wikipedia.org/wiki/Separation_of_concerns>}。

React 不强制要求使用 JSX，但是大多数人发现，在 JavaScript 代码中将 JSX 和 UI 放在一起时，会在视觉上有辅助作用。它还可以使 React 显示更多有用的错误和警告消息。

#### 3.2.2、在 JSX 中嵌入表达式

在下面的例子中，我们声明了一个名为`name`的变量，然后再JSX中使用它，并将它包裹在大括号中：

``` JSX
const name = 'Josh Perez';
const element = <h1>hello, {name}</h1>;

ReactDOM.render(element,document.getElementById('root'));
```

在 JSX 语法中，你可以在大括号内放置任何有效的 [JavaScript 表达式](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Expressions_and_Operators#Expressions)。例如，`2 + 2`，`user.firstName` 或 `formatName(user)` 都是有效的 JavaScript 表达式。

#### 3.2.3、JSX 也是一个表达式

在编译之后，JSX 表达式会被转为普通 JavaScript 函数调用，并且对其取值后得到 JavaScript 对象。 也就是说，你可以在 if 语句和 for 循环的代码块中使用 JSX，将 JSX 赋值给变量，把 JSX 当作参数传入，以及从函数中返回 JSX。

#### 3.2.4、JSX 中指定属性

使用大括号，来在属性值中插入一个 JavaScript 表达式：

``` JSX
const element = <img src={user.avatarUrl}></img>;
```

在属性中嵌入 JavaScript 表达式时，***不要在大括号外面加上引号***。你应该仅使用引号（对于字符串值）或大括号（对于表达式）中的一个，对于同一属性不能同时使用这两种符号。

> **警告：**
>
> 因为 JSX 语法上更接近 JavaScript 而不是 HTML，所以 React DOM 使用 camelCase（小驼峰命名）来定义属性的名称，而不使用 HTML 属性名称的命名约定。
>
> 例如，JSX 里的 `class` 变成了 [className](https://developer.mozilla.org/en-US/docs/Web/API/Element/className)，而 `tabindex`  则变为 [tabIndex](https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/tabIndex)

#### 3.2.5、使用 JSX 指定子元素

假如一个标签里面没有内容，你可以使用 /> 来闭合标签，就像 XML 语法一样：

``` JSX
const element = <img src={user.avatarUrl} />;
```

JSX 标签里能够包含很多子元素:

``` JSX
const element = (
  <div>
    <h1>Hello!</h1>
    <h2>Good to see you here.</h2>
  </div>
);
```

#### 3.2.5、JSX 防止注入攻击

你可以安全地在 JSX 当中插入用户输入内容：

``` JSX
const title = response.potentiallyMaliciousInput;
// 直接使用是安全的：
const element = <h1>{title}</h1>;
```

React DOM 在渲染所有输入内容之前，默认会进行转义。它可以确保在你的应用中，永远不会注入那些并非自己明确编写的内容。所有的内容在渲染之前都被转换成了字符串。这样可以有效地防止 [XSS（cross-site-scripting, 跨站脚本）](https://en.wikipedia.org/wiki/Cross-site_scripting)攻击。

#### 3.2.6、JSX 表示对象

Babel 会把 JSX 转译成一个名为 `React.createElement()` 函数调用。

以下两种示例代码完全等效：

``` JSX
const element = (
  <h1 className="greeting">
    Hello, world!
  </h1>
);
```

``` JSX
const element = React.createElement(
  'h1',
  {className: 'greeting'},
  'Hello, world!'
);
```

`React.createElement()` 会预先执行一些检查，以帮助你编写无错代码，但实际上它创建了一个这样的对象：

这些对象被称为 “React 元素”。它们描述了你希望在屏幕上看到的内容。React 通过读取这些对象，然后使用它们来构建 DOM 以及保持随时更新。

### 3.3、元素渲染

元素是构成 React 应用的最小砖块。元素描述了你在屏幕上想看到的内容。与浏览器的 `DOM` `元素不同，React` 元素是创建开销极小的普通对象。`React DOM` 会负责更新 `DOM` 来与 `React` 元素保持一致。

#### 3.3.1、将一个元素渲染为 DOM

假设你的 HTML 文件某处有一个 `<div>`：

``` HTML
<div id="root"></div>
```

我们将其称为“根” DOM 节点，因为该节点内的所有内容都将由 `React DOM` 管理。

仅使用 React 构建的应用**通常只有单一的根 DOM 节点**。如果你在将 React 集成进一个已有应用，那么你可以在应用中包含任意多的独立根 DOM 节点。

想要将一个 React 元素渲染到根 DOM 节点中，只需把它们一起传入 `ReactDOM.render()`：

``` JSX
const element = <h1>Hello, world</h1>;
ReactDOM.render(element, document.getElementById('root'));
```

#### 3.3.2、更新已渲染的元素

React 元素是不可变对象。一旦被创建，你就无法更改它的子元素或者属性。一个元素就像电影的单帧：它代表了某个特定时刻的 UI。

根据我们已有的知识，更新 UI 唯一的方式是创建一个全新的元素，并将其传入 ReactDOM.render()。

> **注意：**
>
> 在实践中，大多数 React 应用只会调用一次 ReactDOM.render()。在下一个章节，我们将学习如何将这些代码封装到有状态组件中。

#### 3.3.3、React 只更新它需要更新的部分

React DOM 会将元素和它的子元素与它们之前的状态进行比较，并只会进行必要的更新来使 DOM 达到预期的状态。
