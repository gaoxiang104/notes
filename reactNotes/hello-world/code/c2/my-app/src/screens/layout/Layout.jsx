import React from 'react'
import './Layout.css'
import { Link, Outlet } from 'react-router-dom'

export default function Layout() {
    return (
        <div className="layout-body">
            <nav className="layout-nav ">
                <li>
                    <Link to="/">/home</Link>
                </li>
                <li>
                    <Link to="/state/clock">/state/clock</Link>
                </li>
                <li>
                    <Link to="/handling-event/toggle">/handling-event/toggle</Link>
                </li>
            </nav>
            <Outlet />
        </div>
    )
}
