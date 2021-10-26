import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
// import App from './App';
// import App from './screens/BaseRouting'
// import App from './screens/NestedRouting'
// import App from './screens/routing-class/RoutingClass'
// import App from './screens/hooks-demo/UseHistoryDemo'
// import App from './screens/hooks-demo/UseLocationDemo'
import App from './screens/hooks-demo/UseParamsDemo'

import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
