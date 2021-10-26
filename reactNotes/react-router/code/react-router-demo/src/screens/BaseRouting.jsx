import React from "react"
import {
    BrowserRouter as Router,
    Link,
    Switch,
    Route
} from "react-router-dom"

export default function BaseRouting() {
    return <Router>
        <div>
            <nav>
                <li>
                    <Link to="/">Home</Link>
                </li>
                <li>
                    <Link to="/about">About</Link>
                </li>
                <li>
                    <Link to="/users">Users</Link>
                </li>
            </nav>

            <Switch>
                <Route path="/about">
                    <About />
                </Route>
                <Route path="/users">
                    <Users />
                </Route>
                {/* 一定要将 ‘/’ 放在最后，因为这个始终会被匹配到；如果放在前面，则在他之后的将无法匹配上 */}
                <Route path="/">
                    <Home />
                </Route>
            </Switch>
        </div>
    </Router>
};

function Home() {
    return (
        <h2>Home</h2>
    )
}
function About() {
    return (
        <h2>About</h2>
    )
}
function Users() {
    return (
        <h2>Users</h2>
    )
}

