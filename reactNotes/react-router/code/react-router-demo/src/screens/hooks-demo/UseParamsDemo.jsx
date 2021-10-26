import React from 'react'
import { BrowserRouter as Router, Route, Switch,  Link, useParams } from 'react-router-dom'


export default function UseParamsDemo() {
    return (
        <Router>
            <div>

                <nav>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/about/111">about-111</Link>
                    </li>
                    <li>
                        <Link to="/about/222">about-222</Link>
                    </li>
                    <li>
                        <Link to="/about/333">about-333</Link>
                    </li>
                </nav>
            </div>

            <Switch>
                <Route path="/" exact>
                    <Home/>
                </Route>
                <Route path="/about/:aboutTitle">
                    <About/>
                </Route>
            </Switch>
        </Router>

    )
}

const Home = ()=>{
    return (
        <h1>Home</h1>
    )
}

const About = ()=>{

    const {aboutTitle} = useParams();

    return (
        <h1>About - {aboutTitle}</h1>
    )
}