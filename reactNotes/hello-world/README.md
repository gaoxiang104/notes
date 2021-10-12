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

* 如果你是在学习 React 或创建一个新的单页应用，请使用 [Create React App](https://github.com/facebookincubator/create-react-app)。
* 如果你是在用 Node.js 构建服务端渲染的网站，试试 [Next.js](https://nextjs.org/)。
* 如果你是在构建内容主导的静态网站，试试 [Gatsby](https://www.gatsbyjs.org/)。
* 如果你是在打造组件库或将 React 集成到现有代码仓库，尝试[更灵活的工具链](https://zh-hans.reactjs.org/docs/create-a-new-react-app.html#more-flexible-toolchains)。

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

* `react-app-rewired`：此工具可以在不 'eject' 也不创建额外 react-scripts 的情况下修改 create-react-app 内置的 webpack 配置，然后你将拥有 create-react-app 的一切特性，且可以根据你的需要去配置 webpack 的 plugins, loaders 等。

* `customize-cra`：利用react-app-rewired的config-overrides.js文件。在`override`方法中调用`customize-cra`提供的API，可以很容易地修改底层配置对象（webpack，webpack-dev-server，babel等）。

安装步骤：

* step1：安装 `react-app-rewired` 和 `customize-cra`；

``` shell
npm install react-app-rewired customize-cra --save-dev
```

* step2：创建`config-overrides.js`文件，在`package.json`同级目录下；

``` javascript
module.exports = function override(config, env) {
  //do stuff with the webpack config...
  return config;
}
```

* step3：修改`package.json`中的`scripts`命令；

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

* step4：使用`customize-cra`，添加`img-loader`插件，修改`config-overrides.js`

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


