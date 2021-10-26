import React, { Component } from 'react'
import { withRouter } from 'react-router'

export class RoutingClassChild extends Component {

    render() {
        const { id } = this.props.match.params;
        return (
            <h2> id :{id}</h2>
        )
    }
}

export default withRouter(RoutingClassChild)
