import React from 'react'
import {
    BrowserRouter as Router,
    Switch,
    Route,
    useHistory,
    Link
} from 'react-router-dom'



export default function UseHistoryDemo() {


    return (
        <Router>
            <div>

                <nav>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/about">about</Link>
                    </li>
                </nav>
                <Switch>
                    <Route path="/" exact>
                        <Home />
                    </Route>
                    <Route path="/about" exact>
                        <About />
                    </Route>
                </Switch>
            </div>
        </Router>
    )
}



const Home = () => {
    const history = useHistory();
    function go(path) {
        history.push(path);
    }
    return (
        <div>
            <h1>Home</h1>
            <h2>history.length : {history.length}</h2>
            <button onClick={(e) => go('/about', e)}>go about</button>
            <button onClick={(e) => history.goBack()}>goBack</button>
        </div>
    )
}

const About = () => {
    const history = useHistory();
    
    function go(path) {
        history.push(path);
    }
    return (
        <div>
            <h1>About</h1>
            <h2>history.length : {history.length}</h2>
            <button onClick={(e) => go('/',e)}>go home</button>
            <button onClick={(e) => history.goBack()}>goBack</button>
        </div>
    )
}








