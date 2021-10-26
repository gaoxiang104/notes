import React from 'react'
import {
    BrowserRouter as Router,
    Link,
    Switch,
    Route,
    useRouteMatch,
    useParams
} from 'react-router-dom'

export default function NestedRouting() {
    return (
        <Router>
            <div>
                <nav>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/about">About</Link>
                    </li>
                    <li>
                        <Link to="/topics">Topics</Link>
                    </li>
                </nav>
            </div>

            <Switch>
                <Route path="/" component={Home} exact />
                <Route path="/about" component={About} />
                <Route path="/topics" component={Topics} />
            </Switch>
        </Router>
    )
}

function Home() {
    return <h2>Home</h2>;
}
function About() {
    return <h2>About</h2>;
}
function Topics() {
    const match = useRouteMatch();
    return (
        <div>
            <h2>Topics</h2>

            <ul>
                <li>
                    <Link to={`${match.url}/components`}>Components</Link>
                </li>
                <li>
                    <Link to={`${match.url}/props-v-state`}>Props v. State</Link>
                </li>
            </ul>

            <Switch>
                <Route exact path={match.path}>
                    <h3>Please select a topic.</h3>
                </Route>
                <Route path={`${match.path}/:topicId`}>
                    <Topic />
                </Route>
            </Switch>
        </div>
    );
}

function Topic() {
    const { topicId } = useParams();
    return <h3>Requested topic ID : {topicId}</h3>
}