# 1. Cat Photo

- [1. Cat Photo](#1-cat-photo)
  - [1.1. h5 标签应用](#11-h5-标签应用)
    - [1.1.1. `<section>`](#111-section)
    - [1.1.2. `<figure>`](#112-figure)
      - [1.1.2.1. `<figcaption>`](#1121-figcaption)
    - [1.1.3. `<em>`](#113-em)
    - [1.1.4. `<strong>`](#114-strong)
    - [1.1.5. `<fieldset>`](#115-fieldset)
      - [1.1.5.1. `<legend>`](#1151-legend)
    - [1.1.6. `<article>`](#116-article)


## 1.1. h5 标签应用

### 1.1.1. `<section>`

- 表示一部分

### 1.1.2. `<figure>`

- `figure` 元素代表独立的内容

#### 1.1.2.1. `<figcaption>`

- 图像标题（`figcaption`）元素用于添加标题以描述 `figure` 元素中包含的图像。

### 1.1.3. `<em>`

- `<em>`：强调元素; 斜体

### 1.1.4. `<strong>`

- `<strong>`: 元素用于指示某些文本非常重要或紧急。粗体

### 1.1.5. `<fieldset>`

- `<fieldset>`: 元素用于在 Web 表单中将相关的输入和标签组合在一起。 `<fieldset>` 元素是块级元素，这意味着它们出现在新的一行上。

#### 1.1.5.1. `<legend>`

- `<legend>`: 元素充当 `<fieldset>` 元素中内容的标题。 它为用户提供了有关他们应该在表单的该部分中输入什么的上下文。

### 1.1.6. `<article>`

- `<article>` 元素表示文档、页面、应用或网站中的独立结构，其意在成为可独立分配的或可复用的结构，如在发布中，它可能是论坛帖子、杂志或新闻文章、博客、用户提交的评论、交互式组件，或者其他独立的内容项目。

``` html
<article class="forecast">
  <h1>Weather forecast for Seattle</h1>
  <article class="day-forecast">
    <h2>03 March 2018</h2>
    <p>Rain.</p>
  </article>
  <article class="day-forecast">
    <h2>04 March 2018</h2>
    <p>Periods of rain.</p>
  </article>
</article>
```
