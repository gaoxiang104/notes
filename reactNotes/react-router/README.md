# React-Router

参考文档：[https://reactrouter.com/web/guides/quick-start](https://reactrouter.com/web/guides/quick-start)

## 安装

首先用`create-react-app`创建项目:

``` shell
npx create-react-app react-router-demo
cd react-router-demo
```

安装 React Router:

``` shell
npm install react-router-dom
```

## 快速入门

### 示例1：基础路由

本例中包含3个页面：Home、About、Users。当点击不同的`Link`时，路由器会呈现匹配的`<Route>`;

> 注意：
> 
> `<Link>`实际会渲染出带有`href`的`<a>`标签，因此在浏览器地址栏输入不同的路由地址也能访问。

参考示例：[BaseRouting.jsx](./code/react-router-demo/src/screens/BaseRouting.jsx)

### 示例2：嵌套路由

此示例显示嵌套路由的工作原理。 路由 `/topics` 加载 Topics 组件，该组件根据路径 `:id` 值有条件地呈现任何进一步的 `<Route>`

参考示例：[NestedRouting.jsx](./code/react-router-demo/src/screens/NestedRouting.jsx)

## 基础组件

React Router 中的组件主要分为三类：

- routers(路由器)： `<BrowserRouter>` and `<HashRouter>`；
- route matchers(路由匹配器)： `<Route>` and `<Switch>`；
- navigation(导航)： `<Link>`, `<NavLink>`, and `<Redirect>`

### routers(路由器)

每个 React Router 应用程序的核心应该是一个路由器组件。 对于 web 项目，react-router-dom 提供了 `<BrowserRouter>` 和 `<HashRouter>` 路由器。 两者之间的主要区别在于它们存储 URL 以及与您的 Web 服务器通信的方式。

- `<BrowserRouter>` 使用常规 URL 路径，类似于`http://example.com/your/page`，但它们需要正确配置您的服务器。具体来说，您的 Web 服务器需要在由 React Router 客户端管理的所有 URL 上提供相同的页面。
- `<HashRouter>` 将当前位置存储在 URL 的哈希部分中，因此 URL 看起来类似于 `http://example.com/#/your/page`。 由于哈希从未发送到服务器，这意味着不需要特殊的服务器配置。

### route matchers(路由匹配器)

有两个路由匹配组件：`Switch` 和 `Route`。当 `<Switch>` 被渲染时，它会搜索它的子 `<Route>` 元素以找到路径与当前 URL 匹配的元素。当它找到一个时，它会渲染那个 `<Route>` 并忽略所有其他的。

这意味着您应该将具有更具体（通常更长）路径的 `<Route>` 放在不太具体的路径之前。

如果没有 `<Route>` 匹配，则 `<Switch>` 不渲染任何内容（空）。

> 注意：一件重要事情是 `<Route path>` 匹配 URL 的开头，而不是整个内容。 所以 `<Route path="/">` 将始终匹配 URL。 因此，我们通常将这个 `<Route>` 放在 `<Switch>` 的最后。另一种可能的解决方案是设置`exact`来精确匹配，`<Route exact path="/">`;

> 注意：尽管 React Router 确实支持在 `<Switch>` 之外渲染 `<Route>` 元素，但从 5.1 版本开始，我们建议您改用 `useRouteMatch` 钩子。 此外，我们不建议您在没有路径的情况下渲染 `<Route>`，而是建议您使用钩子来访问您需要的任何变量。

### navigation(导航)

- `<Link>`：React Router 提供了一个 `<Link>` 组件来在你的应用程序中创建链接。 无论您在何处呈现 `<Link>`，都将在您的 HTML 文档中呈现一个锚点 (`<a>`)。
- `<NavLink>`：是一种特殊类型的 `<Link>`，当它的 to prop 与当前位置匹配时，它可以设置特定的*样式*属性。
- `<Redirect>`：任何时候你想强制导航，你都可以渲染一个 `<Redirect>`。 当 `<Redirect>` 呈现时，它将使用它的 to prop 进行导航。

## Hooks

### useHistory

useHistory 挂钩使您可以访问可用于导航的`history`实例。

history 相关：

- length - (number) The number of entries in the history stack
- action - (string) The current action (PUSH, REPLACE, or POP)
- location - (object) The current location. May have the following properties:
  - pathname - (string) The path of the URL
  - search - (string) The URL query string
  - hash - (string) The URL hash fragment
  - state - (object) location-specific state that was provided to e.g. push(path, state) when this location was pushed onto the stack. Only available in browser and memory history.
- push(path, [state]) - (function) Pushes a new entry onto the history stack
- replace(path, [state]) - (function) Replaces the current entry on the history stack
- go(n) - (function) Moves the pointer in the history stack by n entries
- goBack() - (function) Equivalent to go(-1)
- goForward() - (function) Equivalent to go(1)
- block(prompt) - (function) Prevents navigation (see the history docs)


[useHistory 示例代码](./code/react-router-demo/src/screens/hooks-demo/UseHistoryDemo.jsx)

### useLocation

该`useLocation`钩子返回`location`表示当前URL对象。你可以把它想象`useState`成`location`在 URL 改变时返回一个新的。

[useLocation 示例代码 (获取url参数)](./code/react-router-demo/src/screens/hooks-demo/UseLocationDemo.jsx)

### useParams

`useParams`返回 URL 参数的键/值对对象。使用它来访问`match.params`当前`<Route>`.

[useParams 示例代码 ](./code/react-router-demo/src/screens/hooks-demo/UseParamsDemo.jsx)

### useRouteMatch

`useRouteMatch` 钩子尝试以与 `<Route>` 相同的方式匹配当前 URL。它对于在不实际渲染 `<Route>`的情况下访问匹配数据非常有用。