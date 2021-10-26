import React, { Component } from 'react'
import { BrowserRouter, Link, Switch, Route } from 'react-router-dom'
import RoutingClassChild from './RoutingClassChild'


export class RoutingClass extends Component {
    render() {
        return (
            <BrowserRouter>
                <div>
                    <nav>
                        <li>
                            <Link to="/">home</Link>
                        </li>
                        <li>
                            <Link to="/1">111</Link>
                        </li>
                        <li>
                            <Link to="/2">222</Link>
                        </li>
                        <li>
                            <Link to="/3">333</Link>
                        </li>
                    </nav>

                    <Switch>
                        <Route path="/" exact >
                            <h1>this is home</h1>
                        </Route>
                        <Route path="/:id" >
                            <RoutingClassChild/>
                        </Route>
                    </Switch>
                </div>
            </BrowserRouter>
        )
    }
}

export default RoutingClass
