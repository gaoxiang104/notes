import React from 'react'

import { BrowserRouter as Router, Switch, Route, useLocation, Link } from 'react-router-dom'


export default function UseLocationDemo() {

    return (
        <Router>
            <div>
                <nav>
                    <li>
                        <Link to="/?name=111">111</Link>
                    </li>
                    <li>
                        <Link to="/?name=222">222</Link>
                    </li>
                    <li>
                        <Link to="/?name=333">333</Link>
                    </li>{/*  */}
                </nav>

                <Switch>
                    <Route path="/" exact>
                        <Home/>
                    </Route>
                </Switch>
            </div>
        </Router>
    )
}


function Home(params) {
    const location = useLocation();
    
    const query = (p)=>{
        /*
        step1 : 获取 location.search
        step2 : 使用 URLSearchParams 进行解析获取对应参数
        */
        return new URLSearchParams(location.search).get(p);
    }

    return (
        <div>
            <h2>name = {query('name')}</h2>
        </div>
    )
}
